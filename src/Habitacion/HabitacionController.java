/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Controller.Controller;
import Models.HabitacionOcupadaException;
import Views.View;

public class HabitacionController implements Controller<Habitacion> {
    private HabitacionList list;
    private View view;

    public HabitacionController(View view) {
        list = HabitacionList.getInstance();
        this.view = view;
    }

    @Override
    public void Agregar(Habitacion habitacion) {
        if (list.Agregar(habitacion)) {
            view.displayMessaje("Habitación agregada exitosamente.");
        } else {
            view.displayErrorMessaje("No se pudo agregar la habitación.");
        }
    }

    @Override
    public void Actualizar(Habitacion habitacion) {
        // Lógica para actualizar el tipo de habitación
        if (list.actualizarTipoHabitacion(habitacion.getNumeroHabitacion(), habitacion.getTipoHabitacion())) {
            view.displayMessaje("Tipo de habitación actualizado exitosamente.");
        } else {
            view.displayErrorMessaje("No se pudo actualizar el tipo de habitación.");
        }
    }

    @Override
    public void Eliminar(Habitacion habitacion) {
        try {
            Habitacion habitacionAEliminar = list.Buscar(habitacion.getNumeroHabitacion());
            if (habitacionAEliminar != null && !habitacionAEliminar.isOcupada()) {
                list.Eliminar(habitacionAEliminar);
                this.buscarTodo();
                view.displayMessaje("Habitación eliminada con éxito.");
            } else if (habitacionAEliminar != null && habitacionAEliminar.isOcupada()) {
                throw new HabitacionOcupadaException("No se puede eliminar la habitación. Está ocupada.");
            } else {
                view.displayErrorMessaje("No se encontró la habitación con el número proporcionado.");
            }
        } catch (IllegalArgumentException e) {
            view.displayErrorMessaje("No se puede eliminar la habitación. No se encontró en la lista.");
        } catch (HabitacionOcupadaException e) {
            view.displayErrorMessaje("No se puede eliminar la habitación. Está ocupada.");
        }
    }

    @Override
    public void Buscar(Object id) {
        if (id instanceof Integer) {
            Habitacion habitacion = list.Buscar(id);
            if (habitacion != null) {
                view.display(habitacion);
            } else {
                view.displayErrorMessaje("No se encontró la habitación con el número proporcionado.");
            }
        } else {
            view.displayErrorMessaje("El número de habitación debe ser un valor entero.");
        }
    }

    @Override
    public void buscarTodo() {
        Habitacion[] habitaciones = list.toArray();
        if (habitaciones.length > 0) {
            view.displayAll(habitaciones);
        } else {
            view.displayMessaje("No hay habitaciones registradas.");
        }
    }
}
