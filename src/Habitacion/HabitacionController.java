/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Habitacion;

import Controller.Controller;
import Views.View;

/**
 *
 * @author ´Felipe Chacón
 */

public class HabitacionController implements Controller<Habitacion> {
    // Atributos de la clase
    private HabitacionList list; // Atributo HabitacionList
    private View view; // Atributo View

    // Constructor que recibe una instancia de la vista para interactuar con ella
    public HabitacionController(View view) {
        list = HabitacionList.getInstance(); // Crear una nueva instancia de HabitacionList
        this.view = view; // Asignar la vista proporcionada al atributo view
    }

    @Override
    public void Agregar(Habitacion habitacion) {
        // Lógica para agregar una habitación
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
        // Lógica para eliminar una habitación
        if (list.Eliminar(habitacion)) {
            view.displayMessaje("Habitación eliminada exitosamente.");
        } else {
            view.displayErrorMessaje("No se pudo eliminar la habitación.");
        }
    }

    @Override
    public void Buscar(Object id) {
        // Lógica para buscar una habitación por su número
        if (list.Buscar(id)) {
            // Si se encuentra la habitación, muestra sus detalles en la vista
            Habitacion habitacion = list.obtenerHabitacionPorNumero((int) id);
            view.display(habitacion);
        } else {
            view.displayErrorMessaje("Habitación no encontrada.");
        }
    }
}
