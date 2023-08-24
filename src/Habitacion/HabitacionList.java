/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Models.List;
import Reserva.ReservaList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;


public class HabitacionList implements List<Habitacion> {

    private static HabitacionList habitacionList;
    private Map<Integer, Habitacion> habitaciones;
    private static ReservaList reservas;

    public static HabitacionList getInstance() {
        if (habitacionList == null) {
            habitacionList = new HabitacionList();
        }
        return habitacionList;
    }

    public HabitacionList() {
        habitaciones = new HashMap<>();
    }

    @Override
    public boolean Agregar(Habitacion obj) {
        if (obj != null && !habitaciones.containsKey(obj.getNumeroHabitacion())) {
            habitaciones.put(obj.getNumeroHabitacion(), obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean Actualizar(Habitacion obj) {
        if (obj != null && habitaciones.containsKey(obj.getNumeroHabitacion())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean Eliminar(Habitacion obj) {
       if (obj != null && habitaciones.containsKey(obj.getNumeroHabitacion()) && !obj.isOcupada()) {
           habitaciones.remove(obj.getNumeroHabitacion());
           return true;
       }
       return false;
   }

    @Override
    public Habitacion Buscar(Object id) {
        if (id instanceof Integer) {
            int numeroHabitacionBuscado = (int) id;
            return habitaciones.getOrDefault(numeroHabitacionBuscado, null);
        }
        return null;
    }

    public Habitacion obtenerHabitacionPorNumero(int numeroHabitacionBuscado) {
        return habitaciones.getOrDefault(numeroHabitacionBuscado, null);
    }

    public boolean actualizarTipoHabitacion(int numeroHabitacion, TipoHabitacion nuevoTipo) {
        Habitacion habitacion = habitaciones.get(numeroHabitacion);
        if (habitacion != null) {
            habitacion.setTipoHabitacion(nuevoTipo); 
            return true; 
        }
        return false; 
    }

    @Override
    public Habitacion[] toArray() {
        return habitaciones.values().toArray(new Habitacion[0]);
    }
    public Habitacion obtenerHabitacionDisponiblePorTipo(String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
        for (Habitacion habitacion : habitaciones.values()) {
            if (habitacion.getTipoHabitacion().toString().equals(tipoHabitacion) && !habitacion.isOcupada()) {
                if (reservas.verificarDisponibilidadFechas(habitacion, fechaEntrada, fechaSalida)) {
                    return habitacion; 
                }
            }
        }
        return null; 
    }
    public boolean marcarHabitacionComoOcupada(int numeroHabitacion) {
        Habitacion habitacion = habitaciones.get(numeroHabitacion);
        if (habitacion != null && !habitacion.isOcupada()) {
            habitacion.setOcupada(true); 
            return true;
        }
        return false; 
    }
    public boolean marcarHabitacionComoDisponible(int numeroHabitacion) {
        Habitacion habitacion = habitaciones.get(numeroHabitacion);
        if (habitacion != null && habitacion.isOcupada()) {
            habitacion.setOcupada(false); 
            return true;
        }
        return false; 
    }

    public Habitacion obtenerHabitacionDisponiblePorTipo(String tipoHabitacion) {
        for (Habitacion habitacion : habitaciones.values()) {
            if (habitacion.getTipoHabitacion().toString().equals(tipoHabitacion) && !habitacion.isOcupada()) {
                return habitacion;
            }
        }
        return null; 
    }
}