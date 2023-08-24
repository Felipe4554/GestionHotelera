/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reserva;

import Cliente.Cliente;
import Cliente.ClienteList;
import Habitacion.Habitacion;
import Habitacion.HabitacionList;
import Habitacion.TipoHabitacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PruebaGestorReservas {

    public static void main(String[] args) {
        // Crear instancias de HabitacionList y ClienteList
        HabitacionList habitacionList = HabitacionList.getInstance();
        ClienteList clienteList = ClienteList.getInstance();

        // Agregar algunas habitaciones
        Habitacion habitacion1 = new Habitacion(1, TipoHabitacion.Individual);
        Habitacion habitacion2 = new Habitacion(2, TipoHabitacion.Doble);
        Habitacion habitacion3 = new Habitacion(3, TipoHabitacion.Suite);

        habitacionList.Agregar(habitacion1);
        habitacionList.Agregar(habitacion2);
        habitacionList.Agregar(habitacion3);

        // Crear una instancia de SimpleDateFormat para analizar fechas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Agregar algunos clientes con fechas de nacimiento
            Date fechaNacimiento1 = sdf.parse("2000-01-01");
            Cliente cliente1 = new Cliente(12345, "Juan Perez", fechaNacimiento1, 888888, "correo1@gmail.com");

            Date fechaNacimiento2 = sdf.parse("2000-02-02");
            Cliente cliente2 = new Cliente(67890, "Maria Rodriguez", fechaNacimiento2, 777777, "correo2@gmail.com");

            clienteList.Agregar(cliente1);
            clienteList.Agregar(cliente2);

            // Crear una instancia de GestorReservas
            GestorReservas gestorReservas = new GestorReservas(habitacionList, clienteList);

            // Agregar una reserva
            Date fechaEntrada = sdf.parse("2023-08-20");
            Date fechaSalida = sdf.parse("2023-08-25");
            boolean reservaExitosa = gestorReservas.agregarReserva(1, "12345", "Individual", fechaEntrada, fechaSalida);

            if (reservaExitosa) {
                System.out.println("Reserva agregada con éxito.");
            } else {
                System.out.println("No se pudo agregar la reserva. Verifique la disponibilidad.");
            }

            // Activar la reserva
            boolean activarExitoso = gestorReservas.activarReserva(1);

            if (activarExitoso) {
                System.out.println("Reserva activada con éxito.");
            } else {
                System.out.println("No se pudo activar la reserva.");
            }

            // Finalizar la reserva
            boolean finalizarExitoso = gestorReservas.finalizarReserva(1);

            if (finalizarExitoso) {
                System.out.println("Reserva finalizada con éxito.");
            } else {
                System.out.println("No se pudo finalizar la reserva.");
            }

            // Cancelar la reserva
            boolean cancelarExitoso = gestorReservas.cancelarReserva(1);

            if (cancelarExitoso) {
                System.out.println("Reserva cancelada con éxito.");
            } else {
                System.out.println("No se pudo cancelar la reserva.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
