/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;

import Views.View;
import Controller.Controller;
/**
 *
 * @author rsand
 */


public class EmpleadoControler implements Controller<Empleado> {
    // Atributos de la clase
    private EmpleadoList list; // Atributo EmpleadoList
    private View view; // Atributo View

    // Constructor que recibe una instancia de la vista para interactuar con ella
    public EmpleadoControler(View view) {
        list = EmpleadoList.getInstance(); // Crear una nueva instancia de EmpleadoList
        this.view = view; // Asignar la vista proporcionada al atributo view
    }

    @Override
    public void Agregar(Empleado empleado) {
        if (empleado.isComplete()) {
            list.Agregar(empleado);
            view.displayMessaje("Empleado agregado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede agregar el empleado. Faltan datos.");
        }
    }

    @Override
    public void Actualizar(Empleado empleado) {
        if (empleado.isComplete()) {
            list.Actualizar(empleado);
            view.displayMessaje("Empleado actualizado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede actualizar el empleado. Faltan datos.");
        }
    }

    @Override
    public void Eliminar(Empleado empleado) {
        if (list.Eliminar(empleado)) {
            view.displayMessaje("Empleado eliminado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede eliminar el empleado. No se encontró en la lista.");
        }
    }

    @Override
    public void Buscar(Object id) {
        Empleado empleado = list.Buscar(id);
        if (empleado != null) {
            view.display(empleado);
        } else {
            view.displayErrorMessaje("No se encontró el empleado con el ID proporcionado.");
        }
    }

    @Override
    public void buscarTodo() {
        Empleado[] empleados = list.toArray();
        if (empleados.length > 0) {
            view.displayAll(empleados);
        }
    }
}
