package com.alejobeliz.pentabyte.projects.mealapp.domain.pedidosdia;

public enum Dia {
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miercoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes");

    private String dia;

    Dia(String dia){
        this.dia=dia;
    }

    public String getDia(){
        return dia;
    }

    @Override
    public String toString(){
        return dia;
    }


}
