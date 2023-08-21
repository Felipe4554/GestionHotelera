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
    public void Eliminar(Habitacion habitacion)  {
        // Verifica si la habitación está ocupada
        if (habitacion.isOcupada()) {
            view.displayErrorMessaje("No se puede eliminar una habitación ocupada.");
        }

        // Si la habitación no está ocupada, procede con la eliminación
        if (list.Eliminar(habitacion)) {
            view.displayMessaje("Habitación eliminada exitosamente.");
        } else {
            view.displayErrorMessaje("No se pudo eliminar la habitación.");
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

