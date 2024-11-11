package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.service;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.DetalleDePedido;
import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.repository.DetalleDePedidoRepository;
import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.validaciones.ValidadorDeDetallesDePedidos;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.Dia;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiaDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiario;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.repository.PedidoDiarioRepository;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.PedidoSemanal;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto.PedidoSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto.PedidoSemanalDtoIn;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.repository.PedidoSemanalRepository;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.validaciones.ValidadorDePedidosSemanales;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.repository.PlatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private PedidoSemanalRepository pedidoSemanalRepository;
    private ClienteRepository clienteRepository;
    private PedidoDiarioRepository pedidoDiarioRepository;
    private PlatoRepository platoRepository;
    private DetalleDePedidoRepository detalleDePedidoRepository;
    private List<ValidadorDePedidosSemanales> validadorDePedidoSemanales;
    private List<ValidadorDeDetallesDePedidos> validadorDeDetallesDePedidos;

    @Autowired
    public PedidoService(PedidoSemanalRepository pedidoSemanalRepository,
                         ClienteRepository clienteRepository,
                         PedidoDiarioRepository pedidoDiarioRepository,
                         PlatoRepository platoRepository,
                         DetalleDePedidoRepository detalleDePedidoRepository,
                         List<ValidadorDePedidosSemanales> validadorDePedidoSemanales,
                         List<ValidadorDeDetallesDePedidos> validadorDeDetallesDePedidos) {
        this.pedidoSemanalRepository = pedidoSemanalRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoDiarioRepository = pedidoDiarioRepository;
        this.platoRepository = platoRepository;
        this.detalleDePedidoRepository = detalleDePedidoRepository;
        this.validadorDePedidoSemanales = validadorDePedidoSemanales;
        this.validadorDeDetallesDePedidos = validadorDeDetallesDePedidos;
    }


    public void crearNuevoPedido(PedidoSemanalDtoIn pedidoEntrante, Long idCliente) {

        //Comprobamos si no existe un pedido con esa fecha para el pedido usando la fecha de entrega ya que la de pedido varia segun el dia
        LocalDate semana = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//        boolean verificarPedidoExistente = pedidoSemanalRepository.existePedidoConEsaFecha(idCliente, semana);
//
//        if (verificarPedidoExistente) {
//            throw new RuntimeException("Ya existe un pedido creado para la semana siguiente");

        Optional<PedidoSemanal> pedidoExistente = pedidoSemanalRepository.PedidoConFecha(idCliente,semana);

        if(pedidoExistente.isPresent()){
            pedidoSemanalRepository.delete(pedidoExistente.get());
        }

        Cliente clienteDb = clienteRepository.getClienteById(idCliente).get();

        PedidoSemanal pedidoSemanal = new PedidoSemanal(clienteDb);
        validadorDePedidoSemanales.forEach(validador -> validador.validar(pedidoSemanal));
        pedidoSemanalRepository.save(pedidoSemanal);

        for (PedidoSemanalDtoIn.ComidaPorDia comidaPorDiaDto : pedidoEntrante.comidasPorDia()) {
            Dia dia = Dia.valueOf(comidaPorDiaDto.dia());

            PedidoDiario pedidoDiario = new PedidoDiario(dia, pedidoSemanal);

            pedidoDiarioRepository.save(pedidoDiario);

            for (PedidoSemanalDtoIn.ComidaPorDia.DetallePedido detalleDePedido : comidaPorDiaDto.detalles()) {
                Plato platoDb = platoRepository.getReferenceById(detalleDePedido.platoId());
                DetalleDePedido detallePedido = new DetalleDePedido();
                detallePedido.setCantidad(detalleDePedido.cantidad());
                detallePedido.setComentario(detalleDePedido.comentario());
                detallePedido.setPedidoDiario(pedidoDiario);
                detallePedido.setPlato(platoDb);

                validadorDeDetallesDePedidos.forEach(validador -> validador.validar(detallePedido, platoDb));

                detalleDePedidoRepository.save(detallePedido);

            }
        }

    }


    public PedidoSemanalDto getPedidoProximaSemana(Long idCliente) {

        LocalDate proximoLunes = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        PedidoSemanal pedidoSemanalDb = pedidoSemanalRepository.PedidoConFecha(idCliente, proximoLunes)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra un pedido asignado a la fecha de entrega: " + proximoLunes.toString()));

        //Obtengo todos los pedidos diarios que tiene un pedido
        List<PedidoDiario> pedidosDias = pedidoDiarioRepository.findPedidoDiasByPedidoId(pedidoSemanalDb.getId());

        List<Long> pedidoDiaIds = pedidosDias.stream().map(PedidoDiario::getId).collect(Collectors.toList());

        List<DetalleDePedido> detalleDePedidos = detalleDePedidoRepository.findDetallePedidosByPedidoDiaId(pedidoDiaIds);

        Integer cantidadDePlatos=0;

        List<PedidoDiaDto> comidasPorDia = pedidosDias.stream().map(pd -> {
            List<PlatoDto> platos = detalleDePedidos.stream()
                    .filter(d -> d.getPedidoDiario().getId().equals(pd.getId()))
                    .map(d -> new PlatoDto(
                            d.getPlato().getId(),
                            d.getPlato().getNombre(),
                            d.getPlato().getDescripcion(),
                            d.getPlato().getEtiqueta(),
                            d.getPlato().getImagen(),
                            d.getPlato().getCantidadMaxima(),
                            d.getPlato().getTipoDePlato().getNombre(),
                            d.getCantidad(),
                            d.getComentario()
                    )).collect(Collectors.toList());
            return new PedidoDiaDto(pd.getId(), pd.getDia().name(), pd.getFechaDeEntrega(), platos);
        }).collect(Collectors.toList());

        for(PedidoDiaDto pedido : comidasPorDia){
            cantidadDePlatos+=pedido.platos().size();
        }

        return new PedidoSemanalDto(pedidoSemanalDb.getId(), pedidoSemanalDb.getFechaDePedido().toString(),cantidadDePlatos,comidasPorDia);
    }

    public void eliminarUlitmoPedido(Long idCliente) {

        LocalDate proximoLunes = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        PedidoSemanal pedidoSemanalDb = pedidoSemanalRepository.PedidoConFecha(idCliente, proximoLunes)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra un pedido asignado a la fecha de entrega: " + proximoLunes.toString()));

        validadorDePedidoSemanales.forEach(validacion -> validacion.validar(pedidoSemanalDb));

        pedidoSemanalRepository.delete(pedidoSemanalDb);

    }


    public void eliminarPedido(Long id) {
        PedidoSemanal pedidosemanal = pedidoSemanalRepository.getById(id);
        pedidoSemanalRepository.delete(pedidosemanal);
    }
}


