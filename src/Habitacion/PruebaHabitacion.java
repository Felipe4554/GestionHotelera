/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Habitacion;

import Habitacion.*;

public class PruebaHabitacion {
    public static void main(String[] args) {
        // Crear algunas habitaciones
        Habitacion habitacion1 = new Habitacion(101, TipoHabitacion.Individual);
        Habitacion habitacion2 = new Habitacion(102, TipoHabitacion.Doble);
        Habitacion habitacion3 = new Habitacion(103, TipoHabitacion.Suite);

        // Obtener una instancia de HabitacionList
        HabitacionList habitacionList = HabitacionList.getInstance();

        // Agregar las habitaciones a la lista
        habitacionList.Agregar(habitacion1);
        habitacionList.Agregar(habitacion2);
        habitacionList.Agregar(habitacion3);

        // Mostrar todas las habitaciones
        System.out.println("Habitaciones disponibles:");
        for (Habitacion habitacion : habitacionList.toArray()) {
            System.out.println("Número: " + habitacion.getNumeroHabitacion() + ", Tipo: " + habitacion.getTipoHabitacion() + ", Estado: " + habitacion.estado() + ", Precio: " + habitacion.getPrecio());
        }

        // Actualizar el tipo de una habitación
        int numeroHabitacionActualizar = 102; // Número de habitación a actualizar
        TipoHabitacion nuevoTipo = TipoHabitacion.Individual;
        boolean actualizacionExitosa = habitacionList.actualizarTipoHabitacion(numeroHabitacionActualizar, nuevoTipo);
        if (actualizacionExitosa) {
            System.out.println("Tipo de habitación actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar el tipo de habitación.");
        }

        // Eliminar una habitación (si no está ocupada)
        int numeroHabitacionEliminar = 103; // Número de habitación a eliminar
        Habitacion habitacionAEliminar = habitacionList.Buscar(numeroHabitacionEliminar);
        if (habitacionAEliminar != null) {
            if (!habitacionAEliminar.isOcupada()) {
                habitacionList.Eliminar(habitacionAEliminar);
                System.out.println("Habitación eliminada con éxito.");
            } else {
                System.out.println("No se puede eliminar la habitación. Está ocupada.");
            }
        } else {
            System.out.println("No se encontró la habitación con el número proporcionado.");
        }
        
               // Mostrar todas las habitaciones
        System.out.println("Habitaciones disponibles:");
        for (Habitacion habitacion : habitacionList.toArray()) {
            System.out.println("Número: " + habitacion.getNumeroHabitacion() + ", Tipo: " + habitacion.getTipoHabitacion() + ", Estado: " + habitacion.estado() + ", Precio: " + habitacion.getPrecio());
        }
    }
}