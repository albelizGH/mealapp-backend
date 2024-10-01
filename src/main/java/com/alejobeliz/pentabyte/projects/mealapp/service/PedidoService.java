package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.dto.in.PedidoSemanalDtoIn;
import com.alejobeliz.pentabyte.projects.mealapp.dto.out.PedidoSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.dto.DetallePedidoDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.validaciones.ValidadorDeDetallesDePedidos;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.validaciones.ValidadorDePedidos;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia.Dia;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia.PedidoDia;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia.PedidoDiaDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import com.alejobeliz.pentabyte.projects.mealapp.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private PedidoDiaRepository pedidoDiaRepository;
    private PlatoRepository platoRepository;
    private DetallePedidoRepository detallePedidoRepository;
    private List<ValidadorDePedidos> validadorDePedidos;
    private List<ValidadorDeDetallesDePedidos> validadorDeDetallesDePedidos;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         PedidoDiaRepository pedidoDiaRepository,
                         PlatoRepository platoRepository,
                         DetallePedidoRepository detallePedidoRepository,
                         List<ValidadorDePedidos> validadorDePedidos,
                         List<ValidadorDeDetallesDePedidos> validadorDeDetallesDePedidos) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoDiaRepository = pedidoDiaRepository;
        this.platoRepository = platoRepository;
        this.detallePedidoRepository = detallePedidoRepository;
        this.validadorDePedidos=validadorDePedidos;
        this.validadorDeDetallesDePedidos=validadorDeDetallesDePedidos;
    }


    public void crearNuevoPedido(PedidoSemanalDtoIn pedidoEntrante){

        //Comprobamos si no existe un pedido con esa fecha para el pedido usando la fecha de entrega ya que la de pedido varia segun el dia
        LocalDate semana = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        boolean verificarPedidoExistente = pedidoRepository.existePedidoConEsaFecha(pedidoEntrante.clienteId(),semana);

        if(verificarPedidoExistente){
            throw new RuntimeException("Ya existe un pedido creado para la semana siguiente");
        }

        Cliente clienteDb = clienteRepository.getClienteById(pedidoEntrante.clienteId()).orElseThrow(()->new EntityNotFoundException("No existe el cliente con id "+pedidoEntrante.clienteId()));

        Pedido pedido = new Pedido(clienteDb);
        validadorDePedidos.forEach(validador->validador.validar(pedido));
        pedidoRepository.save(pedido);

        for(PedidoSemanalDtoIn.ComidaPorDia comidaPorDiaDto: pedidoEntrante.comidasPorDia()){
            Dia dia = Dia.valueOf(comidaPorDiaDto.dia());

            PedidoDia pedidoDelDia = new PedidoDia(dia,pedido);

            pedidoDiaRepository.save(pedidoDelDia);

            for(PedidoSemanalDtoIn.ComidaPorDia.DetallePedido detalleDePedido:comidaPorDiaDto.detalles()){
                Plato platoDb = platoRepository.getReferenceById(detalleDePedido.platoId());
                DetallePedido detallePedido=new DetallePedido();
                detallePedido.setCantidad(detalleDePedido.cantidad());
                detallePedido.setComentario(detalleDePedido.comentario());
                detallePedido.setPedidoDia(pedidoDelDia);
                detallePedido.setPlato(platoDb);

                validadorDeDetallesDePedidos.forEach(validador->validador.validar(detallePedido,platoDb));

                detallePedidoRepository.save(detallePedido);

            }
        }

    }


    public PedidoSemanalDto getPedidoProximaSemana(Long idCliente) {
        Cliente clienteDb = clienteRepository.getClienteById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el cliente con id: " + idCliente));

        LocalDate proximoLunes = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        Pedido pedidoDb = pedidoRepository.PedidoConFecha(idCliente, proximoLunes)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra un pedido asignado a la fecha de entrega: " + proximoLunes.toString()));

        //Obtengo todos los pedidos diarios que tiene un pedido
        List<PedidoDia> pedidosDias = pedidoDiaRepository.findPedidoDiasByPedidoId(pedidoDb.getId());

        List<Long> pedidoDiaIds = pedidosDias.stream().map(PedidoDia::getId).collect(Collectors.toList());

        List<DetallePedido> detallePedidos = detallePedidoRepository.findDetallePedidosByPedidoDiaId(pedidoDiaIds);

        List<PedidoDiaDto> comidasPorDia = pedidosDias.stream().map(pd -> {
            List<DetallePedidoDto> detalles = detallePedidos.stream()
                    .filter(d -> d.getPedidoDia().getId().equals(pd.getId()))
                    .map(d -> new DetallePedidoDto(d, d.getPlato()))
                    .collect(Collectors.toList());

            return new PedidoDiaDto(pd.getId(), pd.getDia().name(), detalles);
        }).collect(Collectors.toList());

        return new PedidoSemanalDto(pedidoDb.getId(), pedidoDb.getFechaDePedido().toString(), pedidoDb.getEstado(), comidasPorDia);
    }

    public void eliminarUlitmoPedido(Long idCliente) {
        Cliente clienteDb = clienteRepository.getClienteById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el cliente con id: " + idCliente));

        LocalDate proximoLunes = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        Pedido pedidoDb = pedidoRepository.PedidoConFecha(idCliente, proximoLunes)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra un pedido asignado a la fecha de entrega: " + proximoLunes.toString()));

        pedidoRepository.delete(pedidoDb);

    }
}
