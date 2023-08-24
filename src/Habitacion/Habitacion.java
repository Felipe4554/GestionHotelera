/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Models.Entity;

public class Habitacion implements Entity {
    private int numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private boolean ocupada;
    private double precio;

    public Habitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion, boolean ocupada, double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.ocupada = ocupada;
        this.precio = precio;
    }

    public Habitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.ocupada = false; 
        this.precio = calcularPrecioPredeterminado(tipoHabitacion);
    }

    Habitacion(int numeroHabitacion, String tipo, int precio, boolean ocupada) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.ocupada = ocupada; 
    }

    Habitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }


    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    
    public String estado(){
        if(this.ocupada){
            return "Ocupada";
        }else{
            return "Disponible";
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
        this.precio = calcularPrecioPredeterminado(tipoHabitacion);
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double calcularPrecioPredeterminado(TipoHabitacion tipoHabitacion) {
        switch (tipoHabitacion) {
            case Individual:
                return 45000.0;
            case Doble:
                return 80000.0;
            case Suite:
                return 140000.0;
            default:
                return 0.0; 
        }
    }

    @Override
    public boolean isComplete() {
        return this.numeroHabitacion > 0 && this.tipoHabitacion != null && !this.tipoHabitacion.toString().isEmpty();
    }

    @Override
    public Object[] toArrayObject() {
        return new Object[]{this.numeroHabitacion, this.tipoHabitacion.toString(), this.estado(), this.precio};
    }
}