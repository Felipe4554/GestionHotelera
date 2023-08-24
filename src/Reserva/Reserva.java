/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Habitacion.TipoHabitacion;
import Models.Entity;
import static Reserva.EstadoReserva.PENDIENTE;
import java.util.Date;

public class Reserva implements Entity {
    private int numeroReserva; // Autonumérico
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int duracionEstadia;
    private double precioSubtotal;
    private double impuestos;
    private double precioTotal;
    private EstadoReserva estado;

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public int getDuracionEstadia() {
        return duracionEstadia;
    }

    public double getPrecioSubtotal() {
        return precioSubtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setDuracionEstadia(int duracionEstadia) {
        this.duracionEstadia = duracionEstadia;
    }

    public void setPrecioSubtotal(double precioSubtotal) {
        this.precioSubtotal = precioSubtotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Reserva(int numeroReserva, Cliente cliente, Habitacion habitacion, Date fechaEntrada, Date fechaSalida, int duracionEstadia, double precioSubtotal, double impuestos, double precioTotal, EstadoReserva estado) {
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.duracionEstadia = duracionEstadia;
        this.precioSubtotal = precioSubtotal;
        this.impuestos = impuestos;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }
    
    public Reserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
        this.cliente = null;
        this.habitacion = null;
        this.fechaEntrada = null;
        this.fechaSalida = null;
        this.duracionEstadia = 0;
        this.precioSubtotal = 0;
        this.impuestos = 0;
        this.precioTotal = 0;
        this.estado = PENDIENTE;
    }
    
    @Override
    public boolean isComplete() {
                // Verificar que los campos obligatorios estén completos
        return numeroReserva > 0 && cliente != null && habitacion != null
                && fechaEntrada != null && fechaSalida != null
                && duracionEstadia > 0 && precioSubtotal >= 0 && impuestos >= 0
                && precioTotal >= 0 && estado != null;
    }

    @Override
    public Object[] toArrayObject() {
         // Representar los datos de la reserva como un arreglo de objetos
        return new Object[]{
            numeroReserva,
            cliente.getIdentificacion(), // Puedes obtener la cédula del cliente si es necesario
            habitacion.getNumeroHabitacion(), // Puedes obtener el número de habitación si es necesario
            fechaEntrada,
            fechaSalida,
            duracionEstadia,
            precioSubtotal,
            impuestos,
            precioTotal,
            estado.toString() // Representar el estado como una cadena de texto
        };
    }

    public TipoHabitacion getTipoHabitacion() {
        return habitacion.getTipoHabitacion();
    }

    public int getIdCliente() {
        return cliente.getIdentificacion();
    }
}
