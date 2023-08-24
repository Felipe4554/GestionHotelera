/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Views.View;
import Controller.Controller;


/**
 *
 * @author rsand
 */
public class ServicioControler implements Controller<Servicio> {
    private ServicioList list; 
    private View view; 

    public ServicioControler(View view) {
        list = ServicioList.getInstance(); 
        this.view = view; 
    }

    @Override
    public void Agregar(Servicio servicio) {
        if (servicio.isComplete()) {
            list.Agregar(servicio);
            view.displayMessaje("Servicio agregado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede agregar el servicio. Faltan datos.");
        }
    }

    @Override
    public void Actualizar(Servicio servicio) {
        if (servicio.isComplete()) {
            list.Actualizar(servicio);
            view.displayMessaje("Servicio actualizado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede actualizar el servicio. Faltan datos.");
        }
    }

    @Override
    public void Eliminar(Servicio servicio) {
        if (list.Eliminar(servicio)) {
            view.displayMessaje("Servicio eliminado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede eliminar el servicio. No se encontró en la lista.");
        }
    }

    @Override
    public void Buscar(Object id) {
        Servicio servicio = list.Buscar(id);
        if (servicio != null) {
            view.display(servicio);
        } else {
            view.displayErrorMessaje("No se encontró el servicio con el ID proporcionado.");
        }
    }

    @Override
    public void buscarTodo() {
        Servicio[] servicios = list.toArray();
        if (servicios.length > 0) {
            view.displayAll(servicios);
        }
    }
}
    