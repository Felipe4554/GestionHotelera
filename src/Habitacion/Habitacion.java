/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import javax.management.relation.Role;

/**
 *
 * @author ´Felipe Chacón
 */
public class Habitacion {
    private int numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private boolean ocupada;
    private double precio;

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTipoHabitacion(TipoHabitacion TipoHabitacion) {
        this.tipoHabitacion = TipoHabitacion;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Habitacion(int numeroHabitacion, TipoHabitacion TipoHabitacion, boolean ocupada, double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = TipoHabitacion;
        this.ocupada = ocupada;
        this.precio = precio;
    }
}
