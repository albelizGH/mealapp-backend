package com.alejobeliz.pentabyte.projects.mealapp.page.local;

import com.alejobeliz.pentabyte.projects.mealapp.page.local.dto.PedidoPageDto;
import com.alejobeliz.pentabyte.projects.mealapp.page.local.service.PedidoPageService;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.Dia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/local/pages")
public class PedidoPageController {

    @Autowired
    private PedidoPageService pedidoPageService;


    @GetMapping("pedidos")
    public ResponseEntity<Page<PedidoPageDto>> getPedidosPorDiaYFecha(@RequestParam Dia dia, @RequestParam LocalDate fecha, @PageableDefault(size = 10,page = 0)Pageable paginacion){
        Page<PedidoPageDto> pedidos = pedidoPageService.getPedidosPorDiaFecha(dia,fecha,paginacion);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("pedidos/vigentes")
    public ResponseEntity<Page<PedidoPageDto>> getPedidosVigente(@PageableDefault(size = 10,page = 0)Pageable paginacion){
        Page<PedidoPageDto> pedidos=pedidoPageService.getPedidosVigentes(paginacion);
        return ResponseEntity.ok(pedidos);
    }

}
