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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservaList {
    
    private static ReservaList instancia;

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
        this.habitacionList = new HabitacionList(); // Supongo que tienes una clase HabitacionList
        this.clienteList = new ClienteList(); // Supongo que tienes una clase ClienteList
        this.numeroReservaActual = 1; // Inicializar el número de reserva actual
    }

     // Método para realizar una reserva
    public boolean reservar(int numeroCedulaCliente, String tipoHabitacion, Date fechaEntrada, Date fechaSalida, String estado, String precio) {
        // Obtener el cliente
        Cliente cliente = clienteList.Buscar(numeroCedulaCliente);
        
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

        // Calcular el precio en formato double
        double precioDouble = calcularPrecio(precio);

        // Crear la reserva
        Reserva reserva = new Reserva(cliente, habitacionDisponible, fechaEntrada, fechaSalida, EstadoReserva.valueOf(estado), precioDouble);

        // Agregar la reserva al mapa
        reservas.put(reserva.getNumeroReserva(), reserva);

        // Marcar la habitación como no disponible
        habitacionDisponible.setOcupada(false);

        return true;
    }


    // Método para buscar una reserva por número de reserva
    public Reserva buscarReserva(int numeroReserva) {
        return reservas.get(numeroReserva);
    }

    // Método para activar una reserva
    public boolean activarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.EJECUCION);
            reserva.getHabitacion().setOcupada(false); // Marcar la habitación como no disponible
            return true;
        }
        
        return false; // No se pudo activar la reserva
    }

    // Método para finalizar una reserva
    public boolean finalizarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        
        if (reserva != null && reserva.getEstado() == EstadoReserva.EJECUCION) {
            reserva.setEstado(EstadoReserva.FINALIZADA);
            reserva.getHabitacion().setOcupada(true); // Marcar la habitación como disponible
            return true;
        }
        
        return false; // No se pudo finalizar la reserva
    }

    // Método para cancelar una reserva
    public boolean cancelarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        
        if (reserva != null && reserva.getEstado() == EstadoReserva.PENDIENTE) {
            reserva.setEstado(EstadoReserva.CANCELADA);
            reserva.getHabitacion().setOcupada(true); // Marcar la habitación como disponible
            return true;
        }
        
        return false; // No se pudo cancelar la reserva
    }

    public boolean verificarDisponibilidadFechas(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        // Verificar que la habitación esté disponible
        if (habitacion.isOcupada()) {
            return false;
        }

        // Recorrer todas las reservas existentes para esta habitación
        for (Reserva reserva : reservas.values()) {
            // Verificar si la reserva está dentro del rango de fechas especificado
            if (reserva.getHabitacion().getNumeroHabitacion() == habitacion.getNumeroHabitacion() &&
                (fechaEntrada.before(reserva.getFechaSalida()) && fechaSalida.after(reserva.getFechaEntrada()))) {
                // La habitación está ocupada durante ese período
                return false;
            }
        }

        // Si no se encontraron conflictos de fechas, la habitación está disponible
        return true;
    }

    public double  calcularPrecio(String precio) {
        // Aquí debes implementar la lógica para calcular el precio a partir del precio en formato String.
        // Parsea el precio String a double y realiza los cálculos necesarios según tus requerimientos.
        // Este es un ejemplo básico para fines de demostración, asegúrate de adaptarlo a tus necesidades.
        try {
            double precioDouble = Double.parseDouble(precio);
            // Supongamos que el precio ya incluye los impuestos.
            // Dividir el precio en Subtotal, Impuestos y Total.
            double subtotal = precioDouble / 1.13; // Suponiendo un impuesto del 12% (0.13).
            double impuestos = precioDouble - subtotal;
            double total = precioDouble;

            // Devolver el precio calculado
            return total;
        } catch (NumberFormatException e) {
            // Manejo de errores si el formato del precio no es válido
            System.out.println("Error al convertir el precio a double: " + e.getMessage());
            return 0.0;
        }
    }
    
        public Cliente obtenerClientePorCedula(String cedula) {
        return clienteList.BuscarPorCedula(cedula);
    }

    public Habitacion obtenerHabitacionDisponiblePorTipo(String tipoHabitacion, Date fechaEntrada, Date fechaSalida) {
        return habitacionList.obtenerHabitacionDisponiblePorTipo(tipoHabitacion, fechaEntrada, fechaSalida);
    }
    
    public Habitacion obtenerHabitacionDisponiblePorTipo(String tipoHabitacion) {
        return habitacionList.obtenerHabitacionDisponiblePorTipo(tipoHabitacion);
    }

    Reserva[] toArray() {
        return reservas.values().toArray(new Reserva[0]);
    }

}