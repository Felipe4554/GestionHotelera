/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author rsand
 */
import Models.List;
import java.util.HashMap;

/**
 * Clase que representa una lista de servicios utilizando el patrón de diseño singleton.
 */
public class ServicioList implements List<Servicio> {

    // Patrón de diseño singleton
    private static ServicioList servicioList;

    // HashMap para almacenar los servicios
    private HashMap<Integer, Servicio> servicios;

    // Método estático para obtener la instancia única de la lista de servicios
    public static ServicioList getInstance() {
        if (servicioList == null) {
            servicioList = new ServicioList();
        }
        return servicioList;
    }

    private ServicioList() {
        servicios = new HashMap<>();
    }

    @Override
    public boolean Agregar(Servicio obj) {
        if (obj != null && obj.getCodigoServicio() != 0) {
            servicios.put(obj.getCodigoServicio(), obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean Actualizar(Servicio obj) {
        return Agregar(obj);
    }

    @Override
    public boolean Eliminar(Servicio obj) {
        if (obj != null && obj.getCodigoServicio() != 0) {
            Servicio removedServicio = servicios.remove(obj.getCodigoServicio());
            return removedServicio != null;
        }
        return false;
    }

    @Override
    public Servicio Buscar(Object id) {
        if (id instanceof Integer) {
            return servicios.get(id);
        }
        return null;
    }

    @Override
    public Servicio[] toArray() {
        return servicios.values().toArray(new Servicio[0]);
    }

    public void showAll() {
        for (Servicio servicio : servicios.values()) {
            System.out.println(servicio);
        }
    }
}