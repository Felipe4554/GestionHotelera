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
import Habitacion.TipoHabitacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaController {
    private ReservaList gestorReservas;
    private ClienteList clienteList;
    private HabitacionList habitacionList;
    private View view;

    public ReservaController(View view, HabitacionList habitacionList, ClienteList clienteList) {
        this.view = view;
        this.gestorReservas = ReservaList.getInstance();
        this.clienteList = ClienteList.getInstance(); 
        this.habitacionList = HabitacionList.getInstance(); 
    }

    ReservaController(View view) {
        gestorReservas = ReservaList.getInstance();
        this.gestorReservas = ReservaList.getInstance();
        this.clienteList = ClienteList.getInstance(); 
        this.habitacionList = HabitacionList.getInstance(); 
        this.view = view;
    }

    public void realizarReserva(int numeroCedulaCliente, String tipoHabitacion, Date fechaEntrada, Date fechaSalida, String estado, String precio) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            double precioDouble = Double.parseDouble(precio);

            TipoHabitacion tipo = TipoHabitacion.valueOf(tipoHabitacion.toUpperCase());

            boolean resultado = gestorReservas.reservar(numeroCedulaCliente, tipo, fechaEntrada, fechaSalida, EstadoReserva.valueOf(estado.toUpperCase()), precioDouble);

            if (resultado) {
                view.displayMessaje("Reserva realizada con éxito.");
            } else {
                view.displayMessaje("No se pudo realizar la reserva. Verifique los datos y la disponibilidad de la habitación.");
            }
        } catch (NumberFormatException e) {
            view.displayMessaje("Error al ingresar el precio.");
        }
    }

    public void buscarReserva(int numeroReserva) {
        Reserva reserva = gestorReservas.buscarReserva(numeroReserva);
        if (reserva != null) {
            displayReserva(reserva);
        } else {
            view.displayMessaje("Reserva no encontrada.");
        }
    }

    public void activarReserva(int numeroReserva) {
        boolean resultado = gestorReservas.activarReserva(numeroReserva);
        if (resultado) {
            view.displayMessaje("Reserva activada con éxito.");
        } else {
            view.displayMessaje("No se pudo activar la reserva. Verifique el estado de la reserva.");
        }
    }

    public void finalizarReserva(int numeroReserva) {
        boolean resultado = gestorReservas.finalizarReserva(numeroReserva);
        if (resultado) {
            view.displayMessaje("Reserva finalizada con éxito.");
        } else {
            view.displayMessaje("No se pudo finalizar la reserva. Verifique el estado de la reserva.");
        }
    }

    public void cancelarReserva(int numeroReserva) {
        boolean resultado = gestorReservas.cancelarReserva(numeroReserva);
        if (resultado) {
            view.displayMessaje("Reserva cancelada con éxito.");
        } else {
            view.displayMessaje("No se pudo cancelar la reserva. Verifique el estado de la reserva.");
        }
    }

    public void verificarDisponibilidadFechas(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        boolean disponible = gestorReservas.verificarDisponibilidadFechas(habitacion, fechaEntrada, fechaSalida);
        if (disponible) {
            view.displayMessaje("La habitación está disponible en las fechas especificadas.");
        } else {
            view.displayMessaje("La habitación no está disponible en las fechas especificadas.");
        }
    }

    public void buscarTodo() {
        Reserva[] reservas = gestorReservas.toArray();
        if (reservas.length > 0) {
            view.displayAll(reservas);
        } else {
            view.displayMessaje("No hay reservas registradas.");
        }
    }
    
    public void buscarClientePorId(int identificacion) {
        Cliente cliente = clienteList.obtenerClientePorCedula(identificacion);
        if (cliente != null) {
            // Realiza alguna acción con el cliente encontrado, como mostrar sus detalles
            displayCliente(cliente);
        } else {
            view.displayMessaje("Cliente no encontrado.");
        }
    }
    
    private void displayCliente(Cliente cliente){
        
    }

    private void displayReserva(Reserva reserva) {
        System.out.println("Detalles de la Reserva:");
        System.out.println("Número de Reserva: " + reserva.getNumeroReserva());
        System.out.println("Cliente: " + reserva.getCliente().getNombre()); // Asumiendo que tienes un método "getNombre" en la clase Cliente
        System.out.println("Habitación: " + reserva.getHabitacion().getNumeroHabitacion()); // Asumiendo que tienes un método "getNumeroHabitacion" en la clase Habitacion
        System.out.println("Fecha de Entrada: " + reserva.getFechaEntrada());
        System.out.println("Fecha de Salida: " + reserva.getFechaSalida());
        System.out.println("Duración de Estadía (en días): " + reserva.getDuracionEstadia());
        System.out.println("Precio Total: " + reserva.getPrecioTotal());
        System.out.println("Estado: " + reserva.getEstado());
    }

    void tblReservas(Object identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
