/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Models.Entity;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ´Felipe Chacón
 */
public class Cliente implements Entity {
    
    private int identificacion;
    private String nombre;
    private Date fechaNacimiento;
    private int telefono;
    private String correo;

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Cliente(int identificacion){
       this.identificacion = identificacion;
   }
    public int getEdad() {
        // Calcular la edad en base a la fecha de nacimiento
        Date fechaActual = new Date();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaActual.getMonth() < fechaNacimiento.getMonth()
                || (fechaActual.getMonth() == fechaNacimiento.getMonth()
                && fechaActual.getDay() < fechaNacimiento.getDay())) {
            edad--;
        }
        return edad;
    }

    public Cliente(int identificacion, String nombre, Date fechaNacimiento, int telefono, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(int identificacion, String nombre, Date fechaNacimiento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = 0;
        this.correo = "";
    } 

    @Override
    public boolean isComplete() {
        // Verificar que los campos obligatorios estén completos
        return identificacion != 0 && !nombre.isEmpty() && fechaNacimiento != null;
    }

    @Override
    public Object[] toArrayObject() {
        // Convertir los datos del cliente a un arreglo de objetos
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimientoStr = dateFormat.format(fechaNacimiento);
        return new Object[]{identificacion, nombre, telefono, getEdad(), correo,fechaNacimientoStr };
    }
}
