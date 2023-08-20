/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;

import Models.List;
import java.util.HashMap;

/**
 *
 * @author rsand
 */
public class EmpleadoList implements List<Empleado> {

    // Patrón de diseño singleton
    private static EmpleadoList empleadoList;

    // HashMap para almacenar los empleados
    private HashMap<String, Empleado> empleados;

    // Método estático para obtener la instancia única de la lista de empleados
    public static EmpleadoList getInstance() {
        if (empleadoList == null) {
            empleadoList = new EmpleadoList();
        }
        return empleadoList;
    }

    private EmpleadoList() {
        empleados = new HashMap<>();
    }

    @Override
    public boolean Agregar(Empleado obj) {
        if (obj != null && obj.getIdentificacion() != null && !obj.getIdentificacion().isEmpty()) {
            empleados.put(obj.getIdentificacion(), obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean Actualizar(Empleado obj) {
        return Agregar(obj);
    }

    @Override
    public boolean Eliminar(Empleado obj) {
        if (obj != null && obj.getIdentificacion() != null && !obj.getIdentificacion().isEmpty()) {
            Empleado removedEmpleado = empleados.remove(obj.getIdentificacion());
            return removedEmpleado != null;
        }
        return false;
    }

    @Override
    public Empleado Buscar(Object id) {
        if (id instanceof String) {
            return empleados.get(id);
        }
        return null;
    }

    @Override
    public Empleado[] toArray() {
        return empleados.values().toArray(new Empleado[0]);
    }

    public void showAll() {
        for (Empleado empleado : empleados.values()) {
            System.out.println(empleado);
        }
    }
}