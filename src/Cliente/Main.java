/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Crear un objeto Cliente para probar el cálculo de edad
        Cliente cliente = new Cliente(1, "John Doe", parseDate("1990-08-15"), 123456789, "john@example.com");

        // Obtener y mostrar la edad del cliente
        int edad = cliente.getEdad();
        System.out.println("La edad del cliente es: " + edad + " años");
    }

    // Método auxiliar para convertir una cadena de fecha en un objeto Date
    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
