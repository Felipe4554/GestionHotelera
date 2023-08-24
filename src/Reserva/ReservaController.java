/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import Cliente.Cliente;
import Cliente.ClienteList;
import Habitacion.Habitacion;
import Habitacion.HabitacionList;
import Views.View;
import java.util.Date;

public class ReservaController {
    private ReservaList gestorReservas;
    private View view;

    public ReservaController(View view, HabitacionList habitacionList, ClienteList clienteList) {
        this.view = view;
        this.gestorReservas = ReservaList.getInstance();
    }

    ReservaController(View view) {
        gestorReservas = ReservaList.getInstance();
        this.view = view;
    }

    public void realizarReserva(int numeroCedulaCliente, String tipoHabitacion, Date fechaEntrada, Date fechaSalida, String estado, String precio) {
        boolean reservaExitosa = gestorReservas.reservar(numeroCedulaCliente, tipoHabitacion, fechaEntrada, fechaSalida, estado, precio);

        if (reservaExitosa) {
            view.displayMessaje("Reserva realizada con éxito.");
        } else {
            view.displayErrorMessaje("No se pudo realizar la reserva.");
        }
    }

    public void buscarReserva(int numeroReserva) {
        Reserva reserva = gestorReservas.buscarReserva(numeroReserva);

        if (reserva != null) {
            view.displayMessaje("");
        } else {
            view.displayErrorMessaje("No se encontró la reserva con el número proporcionado.");
        }
    }

    public void activarReserva(int numeroReserva) {
        boolean activacionExitosa = gestorReservas.activarReserva(numeroReserva);

        if (activacionExitosa) {
            view.displayMessaje("Reserva activada con éxito.");
            gestorReservas.showAll();
        } else {
            view.displayErrorMessaje("No se pudo activar la reserva.");
        }
    }

    public void finalizarReserva(int numeroReserva) {
        boolean finalizacionExitosa = gestorReservas.finalizarReserva(numeroReserva);

        if (finalizacionExitosa) {
            view.displayMessaje("Reserva finalizada con éxito.");
        } else {
            view.displayErrorMessaje("No se pudo finalizar la reserva.");
        }
    }

    public void cancelarReserva(int numeroReserva) {
        boolean cancelacionExitosa = gestorReservas.cancelarReserva(numeroReserva);

        if (cancelacionExitosa) {
            view.displayMessaje("Reserva cancelada con éxito.");
        } else {
            view.displayErrorMessaje("No se pudo cancelar la reserva.");
        }
    }

    public void verificarDisponibilidadFechas(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        boolean disponibilidad = gestorReservas.verificarDisponibilidadFechas(habitacion, fechaEntrada, fechaSalida);

        if (disponibilidad) {
            view.displayMessaje("La habitación está disponible en esas fechas.");
        } else {
            view.displayErrorMessaje("La habitación no está disponible en esas fechas.");
        }
    }

    public Cliente obtenerClientePorCedula(String cedula) {
        return gestorReservas.obtenerClientePorCedula(cedula);
    }

    public Habitacion obtenerHabitacionDisponiblePorTipoYFechas(String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
        return gestorReservas.obtenerHabitacionDisponiblePorTipo(tipoHabitacion, fechaEntrada, fechaSalida);
    }

    void buscarTodo() {
        Reserva[] reservas = gestorReservas.toArray();
        if (reservas.length > 0) {
            view.displayAll(reservas);
        } else {
            view.displayMessaje("No hay reservas registradas.");
        }
    }

    Habitacion[] obtenerHabitacionDisponiblePorTipo(String tipoHabitacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}