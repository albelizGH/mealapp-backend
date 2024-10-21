package com.alejobeliz.pentabyte.projects.mealapp.page.controller;

import com.alejobeliz.pentabyte.projects.mealapp.infra.security.SecurityContextService;
import com.alejobeliz.pentabyte.projects.mealapp.page.dto.MenuSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.page.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente/pages")
public class PageController {

    private final PageService pageService;
    private final SecurityContextService securityContextService;

    @Autowired
    public PageController(PageService pageService, SecurityContextService securityContextService) {
        this.pageService = pageService;
        this.securityContextService = securityContextService;
    }

    @GetMapping("/menu")
    public ResponseEntity<MenuSemanalDto> getMenuSemanal(@PageableDefault(size = 10,sort = "id", direction = Sort.Direction.ASC) Pageable paginacion){
        MenuSemanalDto menuSemanalDto = pageService.getMenuSemanal(securityContextService.getIdDeUsuarioDesdeAuthenticated(),paginacion);
        return ResponseEntity.ok(menuSemanalDto);
    }

}
