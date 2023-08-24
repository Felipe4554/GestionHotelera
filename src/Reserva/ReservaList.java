/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Habitacion.TipoHabitacion;
import Cliente.ClienteList;
import Habitacion.HabitacionList;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservaList {

    private static ReservaList instancia;
    private static int idReservaGenerado = 1;

    public static ReservaList getInstance() {
        if (instancia == null) {
            instancia = new ReservaList();
        }
        return instancia;
    }

    private Map<Integer, Reserva> reservas;
    private HabitacionList habitacionList;
    private ClienteList clienteList;
    private int numeroReservaActual;

    private ReservaList() {
        this.reservas = new HashMap<>();
        this.habitacionList = HabitacionList.getInstance();
        this.clienteList = ClienteList.getInstance();
        this.numeroReservaActual = 1; // Inicializar el número de reserva actual
    }

    public boolean reservar(int numeroCedulaCliente, TipoHabitacion tipoHabitacion, Date fechaEntrada, Date fechaSalida, EstadoReserva estado, double precio) {
        // Obtener el cliente
        Cliente cliente = clienteList.obtenerClientePorCedula(numeroCedulaCliente);

        if (cliente == null) {
            // El cliente no está registrado, debes manejar esta situación
            return false;
        }

        // Obtener la habitación disponible del tipo especificado
        Habitacion habitacionDisponible = habitacionList.obtenerHabitacionDisponiblePorTipo(tipoHabitacion, fechaEntrada, fechaSalida);

        if (habitacionDisponible == null) {
            // No hay habitaciones disponibles del tipo especificado o todas están ocupadas
            return false;
        }

        // Calcular la duración de la estadía en días
        long diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
        int duracionEstadia = (int) (diferenciaEnMilisegundos / (1000 * 60 * 60 * 24));

        // Crear la reserva
        Reserva reserva = new Reserva(numeroReservaActual, cliente, habitacionDisponible, fechaEntrada, fechaSalida, duracionEstadia, precio, precio * 0.13, precio + (precio * 0.13), estado);

        // Agregar la reserva al mapa
        reservas.put(numeroReservaActual, reserva);

        // Marcar la habitación como no disponible
        habitacionDisponible.setOcupada(true);

        // Incrementar el número de reserva actual para la próxima reserva
        numeroReservaActual++;

        return true;
    }

    public Reserva buscarReserva(int numeroReserva) {
        return reservas.get(numeroReserva);
    }

    public boolean activarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);

        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.EJECUCION);
            reserva.getHabitacion().setOcupada(true); // Marcar la habitación como no disponible
            return true;
        }

        return false; // No se pudo activar la reserva
    }

    public boolean finalizarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);

        if (reserva != null && reserva.getEstado() == EstadoReserva.EJECUCION) {
            reserva.setEstado(EstadoReserva.FINALIZADA);
            reserva.getHabitacion().setOcupada(false); // Marcar la habitación como disponible
            return true;
        }

        return false; // No se pudo finalizar la reserva
    }

    public boolean cancelarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);

        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.CANCELADA);
            reserva.getHabitacion().setOcupada(false); // Marcar la habitación como disponible
            return true;
        }

        return false; // No se pudo cancelar la reserva
    }
    
    public boolean verificarDisponibilidadFechas(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        for (Reserva reserva : reservas.values()) {
            // Verificar si la habitación de la reserva coincide con la habitación especificada
            if (reserva.getHabitacion() == habitacion) {
                // Verificar si las fechas de la reserva se superponen con las fechas especificadas
                if (reserva.getFechaEntrada().before(fechaSalida) && reserva.getFechaSalida().after(fechaEntrada)) {
                    return false; // Las fechas se superponen, la habitación no está disponible
                }
            }
        }
        return true; // No hay reservas que se superpongan con las fechas, la habitación está disponible
    }

    public Reserva[] toArray() {
        return reservas.values().toArray(new Reserva[0]);
    }

    public void mostrarTodasLasReservas() {
        for (Reserva reserva : reservas.values()) {
            System.out.println(reserva);
        }
    }

    public  int generarCodigoReserva() {
        int maxCodigo = 0;
        for (Reserva reserva : reservas.values()) {
            if (reserva.getNumeroReserva() > maxCodigo) {
                maxCodigo = reserva.getNumeroReserva();
            }
        }
        return maxCodigo + 1;
    }

}
