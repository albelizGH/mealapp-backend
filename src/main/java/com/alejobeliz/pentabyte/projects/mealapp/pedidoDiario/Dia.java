package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario;

import lombok.Getter;

import java.time.DayOfWeek;

@Getter
public enum Dia {
    Lunes("Lunes"),
    Martes("Martes"),
    Miercoles("Miércoles"),
    Jueves("Jueves"),
    Viernes("Viernes");

    private final String dia;

    Dia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return dia;
    }

    public DayOfWeek toDayOfWeek() {
        switch (this) {
            case Lunes:
                return DayOfWeek.MONDAY;
            case Martes:
                return DayOfWeek.TUESDAY;
            case Miercoles:
                return DayOfWeek.WEDNESDAY;
            case Jueves:
                return DayOfWeek.THURSDAY;
            case Viernes:
                return DayOfWeek.FRIDAY;
            default:
                throw new IllegalArgumentException("Día no válido: " + this);
        }
    }
}
