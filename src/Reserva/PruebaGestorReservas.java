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
        Habitacion habitacion1 = new Habitacion(1, TipoHabitacion.Individual, 100.0);
        Habitacion habitacion2 = new Habitacion(2, TipoHabitacion.Doble, 150.0);
        Habitacion habitacion3 = new Habitacion(3, TipoHabitacion.Suite, 200.0);

        habitacionList.Agregar(habitacion1);
        habitacionList.Agregar(habitacion2);
        habitacionList.Agregar(habitacion3);

        // Crear una instancia de SimpleDateFormat para analizar fechas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Agregar algunos clientes con fechas de nacimiento
            Date fechaNacimiento1 = sdf.parse("2004-01-01");
            Cliente cliente1 = new Cliente(12345, "Juan Perez", fechaNacimiento1, 888888, "correoo");

            Date fechaNacimiento2 = sdf.parse("2004-01-01");
            Cliente cliente2 = new Cliente(67890, "Maria Rodriguez", fechaNacimiento2, 88888, "correoo");

            clienteList.Agregar(cliente1);
            clienteList.Agregar(cliente2);

            // Obtener el año, mes y día de la fecha de nacimiento de un cliente
            Calendar cal = Calendar.getInstance();
            cal.setTime(cliente1.getFechaNacimiento());

            int añoNacimiento = cal.get(Calendar.YEAR);
            int mesNacimiento = cal.get(Calendar.MONTH) + 1; // Los meses comienzan en 0, por lo que sumamos 1
            int diaNacimiento = cal.get(Calendar.DAY_OF_MONTH);

            System.out.println("Cliente 1 - Fecha de Nacimiento:");
            System.out.println("Año: " + añoNacimiento);
            System.out.println("Mes: " + mesNacimiento);
            System.out.println("Día: " + diaNacimiento);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}