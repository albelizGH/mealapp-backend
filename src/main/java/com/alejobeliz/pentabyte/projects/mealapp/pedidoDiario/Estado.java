package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario;

public enum Estado {
    Pendiente("Pendiente"),
    Confirmado("Listo"),
    Entregado("Entregado");

    private String estado;

    Estado(String estado){
        this.estado=estado;
    }

    public String getEstado(){
        return estado;
    }

    @Override
    public String toString() {
        return estado;
    }

}
