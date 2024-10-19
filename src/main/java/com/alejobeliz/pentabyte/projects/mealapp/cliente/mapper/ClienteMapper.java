package com.alejobeliz.pentabyte.projects.mealapp.cliente.mapper;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.DiasLaboralesDto;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {
    public List<DiasLaboralesDto> mapearAListaDiasLAboralesDto(Cliente cliente){
        DiasLaboralesDto lunes = new DiasLaboralesDto("Lunes", cliente.getLunes());
        DiasLaboralesDto martes = new DiasLaboralesDto("Martes", cliente.getMartes());
        DiasLaboralesDto miercoles = new DiasLaboralesDto("Miercoles", cliente.getMiercoles());
        DiasLaboralesDto jueves = new DiasLaboralesDto("Jueves", cliente.getJueves());
        DiasLaboralesDto viernes = new DiasLaboralesDto("Viernes", cliente.getViernes());

        List<DiasLaboralesDto> diasLaboralesDtos = new ArrayList<>();
        diasLaboralesDtos.add(lunes);
        diasLaboralesDtos.add(martes);
        diasLaboralesDtos.add(miercoles);
        diasLaboralesDtos.add(jueves);
        diasLaboralesDtos.add(viernes);
        return diasLaboralesDtos;
    }
}
