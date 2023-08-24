/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Servicio;

/**
 *
 * @author ´Felipe Chacón
 */
public enum TipoServicio {
Limpieza(800000),
Servicio_Habitación(1400000),
Seguridad(550000);

private final double precio;

TipoServicio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}

