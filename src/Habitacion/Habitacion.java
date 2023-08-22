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
        this.ocupada = false; // Por defecto, una habitación nueva no está ocupada.
        // Establecer un precio predeterminado según el tipo de habitación
        this.precio = calcularPrecioPredeterminado(tipoHabitacion);
    }

    Habitacion(int numeroHabitacion, String tipo, int precio, boolean ocupado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.ocupada = ocupada; // Por defecto, una habitación nueva no está ocupada.
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
        // Cuando se cambia el tipo de habitación, se recalcula el precio
        this.precio = calcularPrecioPredeterminado(tipoHabitacion);
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double calcularPrecioPredeterminado(TipoHabitacion tipoHabitacion) {
        // Lógica para calcular el precio predeterminado según el tipo de habitación
        // Puedes definir esta lógica según tus requerimientos.
        // Aquí, solo se proporciona un ejemplo básico:
        switch (tipoHabitacion) {
            case Individual:
                return 45000.0;
            case Doble:
                return 80000.0;
            case Suite:
                return 140000.0;
            default:
                return 0.0; // Tipo de habitación desconocido
        }
    }

    @Override
    public boolean isComplete() {
        // Verifica si el número de habitación es mayor que cero
        // y si el tipo de habitación no es null ni una cadena vacía
        return this.numeroHabitacion > 0 && this.tipoHabitacion != null && !this.tipoHabitacion.toString().isEmpty();
    }

    @Override
    public Object[] toArrayObject() {
        return new Object[]{this.numeroHabitacion, this.tipoHabitacion.toString(), this.estado(), this.precio};
    }
}