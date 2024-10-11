package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.out.MenuSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/menu")
    public ResponseEntity<MenuSemanalDto> getMenuSemanal(@RequestParam Long idCliente,@PageableDefault(size = 10,sort = "id", direction = Sort.Direction.ASC) Pageable paginacion){
        MenuSemanalDto menuSemanalDto = pageService.getMenuSemanal(idCliente,paginacion);
        return ResponseEntity.ok(menuSemanalDto);
    }

}
