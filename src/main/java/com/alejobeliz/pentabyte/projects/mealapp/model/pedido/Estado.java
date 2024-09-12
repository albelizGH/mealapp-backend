package com.alejobeliz.pentabyte.projects.mealapp.model.pedido;

public enum Estado {
    PENDIENTE("Pendiente"),
    CONFIRMADO("Confirmado"),
    ENTREGADO("Entregado");

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
