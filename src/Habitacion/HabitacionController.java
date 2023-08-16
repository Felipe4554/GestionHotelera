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
    public boolean Agregar(Habitacion obj) {
        return list.Agregar(obj);
    }

    @Override
    public boolean Actualizar(Habitacion obj) {
        if (list.Actualizar(obj)) {
            view.displayMessaje("Habitación actualizada correctamente.");
            return true;
        } else {
            view.displayErrorMessaje("No se pudo actualizar la habitación.");
            return false;
        }
    }

    @Override
    public boolean Eliminar(Habitacion obj) {
        if (obj.isOcupada()) {
            view.displayErrorMessaje("No se puede eliminar una habitación ocupada.");
            return false;
        }

        if (list.Eliminar(obj)) {
            view.displayMessaje("Habitación eliminada correctamente.");
            return true;
        } else {
            view.displayErrorMessaje("No se pudo eliminar la habitación.");
            return false;
        }
    }

    @Override
    public boolean Buscar(Object id) {
        if (list.Buscar(id)) {
            view.displayMessaje("Habitación encontrada.");
            return true;
        } else {
            view.displayErrorMessaje("Habitación no encontrada.");
            return false;
        }
    }
}

