package com.alejobeliz.pentabyte.projects.mealapp.mapper;

import com.alejobeliz.pentabyte.projects.mealapp.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    private final ObjectMapper objectMapper;

    public ClienteMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public ClienteDto clienteToClienteDto(Cliente cliente) {
        return objectMapper.convertValue(cliente, ClienteDto.class);
    }

    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        return objectMapper.convertValue(clienteDto, Cliente.class);
    }
}
