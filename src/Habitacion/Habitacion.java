/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Models.Entity;
import javax.management.relation.Role;

/**
 *
 * @author ´Felipe Chacón
 */
public class Habitacion implements Entity {
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
    
    public Habitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.ocupada = false; // Por defecto, una habitación nueva no está ocupada.
        // Establecer un precio predeterminado según el tipo de habitación
        this.precio = calcularPrecioPredeterminado(tipoHabitacion);
    }
        
    public double calcularPrecioPredeterminado(TipoHabitacion tipoHabitacion) {
        // Lógica para calcular el precio predeterminado según el tipo de habitación
        // Puedes definir esta lógica según tus requerimientos.
        // Aquí, solo se proporciona un ejemplo básico:
        switch (tipoHabitacion) {
            case Individual:
                return precio = 45000.0;
            case Doble:
                return precio = 80000.0;
            case Suite:
                return precio = 140000.0;
            default:
                return precio = 0.0; // Tipo de habitación desconocido
        }
    }
    
     @Override
     public Object[] toArrayObject() {
        return new Object[]{this.numeroHabitacion,this.tipoHabitacion.toString(),this.ocupada,this.precio};
     }

    @Override
    public boolean isComplete() {
        // Verifica si el número de habitación es mayor que cero
        // y si el tipo de habitación no es null ni una cadena vacía
        return this.numeroHabitacion > 0 && this.tipoHabitacion != null && !this.tipoHabitacion.toString().isEmpty();
    }
}
