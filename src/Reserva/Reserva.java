/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Habitacion.TipoHabitacion;
import Models.Entity;
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

    Reserva(String clienteCedula, String tipoHabitacion, Date fechaEntrada, Date fechaSalida, String estado, String precio) {
        // Aquí debes implementar la lógica para obtener el cliente y la habitación a partir de los parámetros
        // Supongamos que cliente y habitación se obtienen correctamente.
        this.cliente = ReservaList.getInstance().obtenerClientePorCedula(clienteCedula);
        this.habitacion = ReservaList.getInstance().obtenerHabitacionDisponiblePorTipo(tipoHabitacion, fechaEntrada, fechaSalida);
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = EstadoReserva.valueOf(estado);

        // Calcula la duración de la estadía en días
        long diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
        this.duracionEstadia = (int) (diferenciaEnMilisegundos / (1000 * 60 * 60 * 24));

        // Calcula el precio a partir del precio en formato String y considerando el impuesto del 13%
        this.precioTotal = ReservaList.getInstance().calcularPrecio(precio);
    }

    Reserva(String clienteCedula, String tipoHabitacion, Date fechaEntrada, Date fechaSalida, String estado, double precio) {
       
    }

    Reserva(int reservaId) {
        
    }
    
    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaEntrada, Date fechaSalida, EstadoReserva estado, double precio) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;

        // Calcula la duración de la estadía en días
        long diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
        this.duracionEstadia = (int) (diferenciaEnMilisegundos / (1000 * 60 * 60 * 24));

        // Calcula el precio subtotal (supongo que el precio por noche ya incluye los impuestos)
        this.precioSubtotal = precio * duracionEstadia;

        // Calcula los impuestos (supongo que ya están incluidos en el precio)
        this.impuestos = 0.0;

        // Calcula el precio total
        this.precioTotal = precioSubtotal + impuestos;
    }


    // Constructor, getters y setters

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getDuracionEstadia() {
        return duracionEstadia;
    }

    public void setDuracionEstadia(int duracionEstadia) {
        this.duracionEstadia = duracionEstadia;
    }

    public double getPrecioSubtotal() {
        return precioSubtotal;
    }

    public void setPrecioSubtotal(double precioSubtotal) {
        this.precioSubtotal = precioSubtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
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
