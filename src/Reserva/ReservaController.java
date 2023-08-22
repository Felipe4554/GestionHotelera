/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserva;

import Cliente.ClienteList;
import Habitacion.HabitacionList;
import Views.View;
import java.util.Date;

public class ReservaController {
    private GestorReservas gestorReservas;
    private View view;

    public ReservaController(View view, HabitacionList habitacionList, ClienteList clienteList) {
        this.view = view;
        gestorReservas = new GestorReservas(habitacionList, clienteList);
    }

    public void reservar(int numeroReserva, String identificacion, String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
        // Implementa aquí la lógica para realizar una reserva
        boolean reservaExitosa = gestorReservas.agregarReserva(numeroReserva, identificacion, tipoHabitacion, fechaEntrada, fechaSalida);

        if (reservaExitosa) {
            view.displayMessaje("Reserva realizada con éxito.");
        } else {
            view.displayErrorMessaje("No se pudo realizar la reserva.");
        }
    }

    public void buscarReserva(int numeroReserva) {
        Reserva reserva = gestorReservas.buscarReserva(numeroReserva);

        if (reserva != null) {
            view.display(reserva);
        } else {
            view.displayErrorMessaje("No se encontró la reserva con el número proporcionado.");
        }
    }

    public void activarReserva(int numeroReserva) {
        boolean activacionExitosa = gestorReservas.activarReserva(numeroReserva);

        if (activacionExitosa) {
            view.displayMessaje("Reserva activada con éxito.");
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
}
