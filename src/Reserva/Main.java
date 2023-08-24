/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reserva;

import Habitacion.Habitacion;
import Habitacion.TipoHabitacion;
import Habitacion.HabitacionList;
import Cliente.Cliente;
import Cliente.ClienteList;
import Reserva.ReservaController;
import Reserva.EstadoReserva;
import Views.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        HabitacionList habitacionList = HabitacionList.getInstance();
        ClienteList clienteList = ClienteList.getInstance();
        View view = new View() {
            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void display(Object regs) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void displayAll(Object[] regs) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void displayMessaje(String msj) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean displayConfirmMessaje(String msj) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void displayErrorMessaje(String msj) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        // Agregar algunas habitaciones
        habitacionList.Agregar(new Habitacion(101, TipoHabitacion.Individual));
        habitacionList.Agregar(new Habitacion(102, TipoHabitacion.Doble));
        habitacionList.Agregar(new Habitacion(103, TipoHabitacion.Suite));

        // Agregar algunos clientes con fecha de nacimiento
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento1 = dateFormat.parse("15/05/1980");
            Date fechaNacimiento2 = dateFormat.parse("20/10/1995");

            clienteList.Agregar(new Cliente(1, "John Doe", fechaNacimiento1));
            clienteList.Agregar(new Cliente(2, "Jane Smith", fechaNacimiento2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ReservaController reservaController = new ReservaController(view, habitacionList, clienteList);

        // Realizar una reserva
        try {
            Date fechaEntrada = dateFormat.parse("01/09/2023");
            Date fechaSalida = dateFormat.parse("05/09/2023");

            reservaController.realizarReserva(1, "Individual", fechaEntrada, fechaSalida, "PENDIENTE", "250.0");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mostrar todas las reservas
        reservaController.buscarTodo();

        // Buscar una reserva por número
        reservaController.buscarReserva(1);

        // Activar una reserva
        reservaController.activarReserva(1);

        // Finalizar una reserva
        reservaController.finalizarReserva(1);

        // Cancelar una reserva
        reservaController.cancelarReserva(1);

        // Verificar disponibilidad de fechas para una habitación
        try {
            Date fechaEntrada = dateFormat.parse("10/09/2023");
            Date fechaSalida = dateFormat.parse("15/09/2023");

            Habitacion habitacion = habitacionList.obtenerHabitacionPorNumero(101);
            reservaController.verificarDisponibilidadFechas(habitacion, fechaEntrada, fechaSalida);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}