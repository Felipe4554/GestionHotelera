/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;


import Models.Entity;
/**
 *
 * @author rsand
 */
public class Servicio implements Entity {
    private int codigoServicio;
    private String nombre;
    private String descripcion;
    private double precio;

    // Constructores

    // Constructor completo
    public Servicio(int codigoServicio, String nombre, String descripcion, double precio) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Constructor con valores por defecto
    public Servicio(int codigoServicio, String nombre) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcion = "";
        this.precio = 0.0;
    }

    // Métodos de acceso

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean isComplete() {
        return codigoServicio != 0 && !nombre.equals("");
    }

    @Override
    public Object[] toArrayObject() {
        return new Object[]{codigoServicio, nombre, descripcion, precio};
    }

    @Override
    public String toString() {
        return "Código de Servicio=" + codigoServicio + ", Nombre=" + nombre + ", Descripción=" + descripcion + ", Precio=" + precio;
    }
}
