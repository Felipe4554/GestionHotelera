/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;


import Models.Entity;
/**
 *
 * @author rsand
 */
public class Empleado implements Entity {
    private String identificacion;
    private String nombre;
    private String telefono;
    private String puesto;
    private double salario;


    public Empleado(String identificacion, String nombre, String telefono, String puesto, double salario) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Empleado(String identificacion, String nombre, String puesto) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = "";
        this.puesto = puesto;
        this.salario = 0.0;
    }
   public Empleado(String identificacion){
       this.identificacion = identificacion;
   }
  
    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public boolean isComplete() {
        return !identificacion.equals("") && !nombre.equals("") && !puesto.equals("");
    }

    @Override
    public Object[] toArrayObject() {
        return new Object[]{identificacion, nombre, telefono, puesto, salario};
    }

    @Override
    public String toString() {
        return "Identificación=" + identificacion + ", Nombre=" + nombre + ", Teléfono=" + telefono + ", Puesto=" + puesto + ", Salario=" + salario;
    }

}