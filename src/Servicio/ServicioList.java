/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author rsand
 */
import Cliente.Cliente;
import Habitacion.Habitacion;
import Models.List;
import java.util.HashMap;

/**
 * Clase que representa una lista de servicios utilizando el patrón de diseño singleton.
 */
public class ServicioList implements List<Servicio> {
    private static ServicioList servicioList;
    private static int nextCodigoServicio = 1;
    private HashMap<Integer, Servicio> servicios;

    public static ServicioList getInstance() {
        if (servicioList == null) {
            servicioList = new ServicioList();
        }
        return servicioList;
    }
public int getNextCodigoServicio() {
        int maxCodigo = 0;
        for (Servicio servicio : servicios.values()) {
            if (servicio.getCodigoServicio() > maxCodigo) {
                maxCodigo = servicio.getCodigoServicio();
            }
        }
        return maxCodigo + 1;
    }
    private ServicioList() {
        servicios = new HashMap<>();
    }

    @Override
public boolean Agregar(Servicio obj) {
    if (obj != null) {
        int codigoServicio = nextCodigoServicio++;
        obj.setCodigoServicio(codigoServicio);
        servicios.put(codigoServicio, obj);
        return true;
    }
    return false;
}

    @Override
    public boolean Actualizar(Servicio obj) {
        if (obj != null && servicios.containsKey(obj.getCodigoServicio())) {
            return true;
        }
        return false;
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
public Servicio Buscar(Object codigoServicio) {
    if (codigoServicio instanceof Integer) {
        int id = (int) codigoServicio;
        for (Servicio servicio : servicios.values()) {
            if (servicio.getCodigoServicio() == id) {
                return servicio;
            }
        }
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