package com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia;

public enum Dia {
    Lunes("Lunes"),
    Martes("Martes"),
    Miercoles("Miércoles"),
    Jueves("Jueves"),
    Viernes("Viernes");

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
