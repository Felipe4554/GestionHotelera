/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prueba;

import Reserva.EstadoReserva;
import Reserva.Reserva;
import Reserva.ReservaList;
import Habitacion.TipoHabitacion;
import Cliente.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaGestorReservas {
    public static void main(String[] args) {
        // Crear una instancia de ReservaList
        ReservaList reservaList = ReservaList.getInstance();

        // Crear un cliente de ejemplo
        Cliente cliente = new Cliente("1234567890", "John Doe", "johndoe@example.com");

        // Crear fechas de entrada y salida
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEntrada = null;
        Date fechaSalida = null;
        try {
            fechaEntrada = dateFormat.parse("2023-08-25");
            fechaSalida = dateFormat.parse("2023-08-30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear una reserva
        boolean reservaExitosa = reservaList.reservar(
                cliente.getIdentificacion(),
                TipoHabitacion.ESTANDAR.toString(), // Tipo de habitación
                fechaEntrada,
                fechaSalida,
                EstadoReserva.PENDIENTE.toString(), // Estado de reserva
                "500.0" // Precio en formato String
        );

        if (reservaExitosa) {
            System.out.println("Reserva exitosa.");
        } else {
            System.out.println("No se pudo realizar la reserva.");
        }

        // Obtener todas las reservas
        Reserva[] reservas = reservaList.toArray();

        // Imprimir las reservas
        for (Reserva reserva : reservas) {
            System.out.println("Número de Reserva: " + reserva.getNumeroReserva());
            System.out.println("Cliente: " + reserva.getCliente().getNombre());
            System.out.println("Habitación: " + reserva.getHabitacion().getNumeroHabitacion());
            System.out.println("Fecha de Entrada: " + dateFormat.format(reserva.getFechaEntrada()));
            System.out.println("Fecha de Salida: " + dateFormat.format(reserva.getFechaSalida()));
            System.out.println("Duración de Estadía: " + reserva.getDuracionEstadia() + " días");
            System.out.println("Precio Subtotal: $" + reserva.getPrecioSubtotal());
            System.out.println("Impuestos: $" + reserva.getImpuestos());
            System.out.println("Precio Total: $" + reserva.getPrecioTotal());
            System.out.println("Estado de Reserva: " + reserva.getEstado());
            System.out.println("-----------------------------------------");
        }
    }
}