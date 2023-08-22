/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import java.util.ArrayList;
import java.util.Date;
import Cliente.Cliente;
import Cliente.ClienteList;
import Habitacion.Habitacion;
import Habitacion.HabitacionList;
import Models.List;

public class GestorReservas {
    private ArrayList<Reserva> reservas;
    private HabitacionList habitacionList;
    private ClienteList clienteList;

    public GestorReservas(HabitacionList habitacionList, ClienteList clienteList) {
        this.reservas = new ArrayList<>();
        this.habitacionList = habitacionList;
        this.clienteList = clienteList;
    }

// Método para agregar una reserva
public boolean agregarReserva(int numeroReserva, String identificacion, String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
    // Buscar el cliente por cédula
    Cliente cliente = clienteList.Buscar(identificacion);

    // Validar que el cliente existe
    if (cliente == null) {
        return false; // El cliente no está registrado
    }

        // Obtener la habitación disponible del tipo especificado
        Habitacion habitacionDisponible = habitacionList.obtenerHabitacionDisponiblePorTipo(tipoHabitacion, fechaEntrada, fechaSalida);

        // Validar que se encontró una habitación disponible
        if (habitacionDisponible == null) {
            return false; // No hay habitaciones disponibles del tipo especificado o todas están ocupadas
        }

        // Calcular la duración de la estadía en días
        long diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
        int duracionEstadia = (int) (diferenciaEnMilisegundos / (1000 * 60 * 60 * 24));

        // Calcular el precio subtotal
        double precioSubtotal = habitacionDisponible.getPrecio() * duracionEstadia;

        // Calcular los impuestos (suponemos que ya están incluidos en el precio)
        double impuestos = 0.0;

        // Calcular el precio total
        double precioTotal = precioSubtotal + impuestos;

        // Crear la reserva
        Reserva reserva = new Reserva(numeroReserva, cliente, habitacionDisponible, fechaEntrada, fechaSalida, duracionEstadia, precioSubtotal, impuestos, precioTotal, EstadoReserva.PENDIENTE);

        // Agregar la reserva a la lista
        reservas.add(reserva);

        // Marcar la habitación como no disponible
        habitacionDisponible.setOcupada(true);

        return true;
    }
    
    public boolean verificarDisponibilidadFechas(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                // Verificar si las fechas de entrada y salida de la reserva se superponen con las fechas dadas
                if (!(fechaSalida.before(reserva.getFechaEntrada()) || fechaEntrada.after(reserva.getFechaSalida()))) {
                    // Las fechas se superponen, la habitación no está disponible
                    return false;
                }
            }
        }
        // Si no se encontraron conflictos, la habitación está disponible
        return true;
    }
    
    // Método para buscar una reserva por número de reserva
    public Reserva buscarReserva(int numeroReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroReserva() == numeroReserva) {
                return reserva; // Retorna la reserva encontrada
            }
        }
        return null; // Retorna null si no se encuentra la reserva
    }

    // Método para activar una reserva
    public boolean activarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.EJECUCION);
            reserva.getHabitacion().setOcupada(true); // Marcar la habitación como no disponible
            return true;
        }
        return false; // No se pudo activar la reserva
    }

    // Método para finalizar una reserva
    public boolean finalizarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.EJECUCION) {
            reserva.setEstado(EstadoReserva.FINALIZADA);
            reserva.getHabitacion().setOcupada(false); // Marcar la habitación como disponible
            return true;
        }
        return false; // No se pudo finalizar la reserva
    }

    // Método para cancelar una reserva
    public boolean cancelarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.CANCELADA);
            reserva.getHabitacion().setOcupada(false); // Marcar la habitación como disponible
            return true;
        }
        return false; // No se pudo cancelar la reserva
    }
}