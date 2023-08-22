/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Models.List;
import Reserva.GestorReservas;
import java.util.ArrayList;
import java.util.Date;


public class HabitacionList implements List<Habitacion> {

    private static HabitacionList habitacionList;
    private ArrayList<Habitacion> habitaciones;
    private static GestorReservas reservas;

    public static HabitacionList getInstance() {
        if (habitacionList == null) {
            habitacionList = new HabitacionList();
        }
        return habitacionList;
    }

    public HabitacionList() {
        habitaciones = new ArrayList<>();
    }

    @Override
    public boolean Agregar(Habitacion obj) {
        if (obj != null && !habitaciones.contains(obj)) {
            habitaciones.add(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean Actualizar(Habitacion obj) {
        if (obj != null && habitaciones.contains(obj)) {
            // Actualizar lógica aquí (solo permitir modificar el tipo)
            return true;
        }
        return false;
    }

    @Override
    public boolean Eliminar(Habitacion obj) {
        if (obj != null && habitaciones.contains(obj) && obj.isOcupada()) {
            habitaciones.remove(obj);
            return true;
        }
        return false;
    }

    @Override
    public Habitacion Buscar(Object id) {
        if (id instanceof Integer) {
            int numeroHabitacionBuscado = (int) id;
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.getNumeroHabitacion() == numeroHabitacionBuscado) {
                    return habitacion;
                }
            }
        }
        return null; // Devuelve null si no se encuentra la habitación
    }

    public Habitacion obtenerHabitacionPorNumero(int numeroHabitacionBuscado) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacionBuscado) {
                return habitacion; // Devuelve la habitación encontrada
            }
        }
        return null; // Devuelve null si la habitación no se encuentra
    }

    public boolean actualizarTipoHabitacion(int numeroHabitacion, TipoHabitacion nuevoTipo) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                habitacion.setTipoHabitacion(nuevoTipo); // Actualiza el tipo de habitación
                return true; // Indica que se realizó la actualización
            }
        }
        return false; // Indica que no se encontró la habitación con el número especificado
    }

    @Override
    public Habitacion[] toArray() {
        return habitaciones.toArray(new Habitacion[0]);
    }

    // Método para buscar una habitación disponible del tipo especificado para un rango de fechas
    public Habitacion obtenerHabitacionDisponiblePorTipo(String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipoHabitacion().toString().equals(tipoHabitacion) && !habitacion.isOcupada()) {
                // Verificar disponibilidad para las fechas dadas
                if (reservas.verificarDisponibilidadFechas(habitacion, fechaEntrada, fechaSalida)) {
                    return habitacion; // Devuelve la primera habitación disponible que cumple con los criterios
                }
            }
        }
        return null; // Devuelve null si no se encontró una habitación disponible que cumpla con los criterios
    }
}

