/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteTest {

    public static void main(String[] args) {
        // Crear un cliente de ejemplo
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento;
        try {
            fechaNacimiento = dateFormat.parse("1990-01-15");
            Cliente cliente1 = new Cliente(1, "Ejemplo Cliente", fechaNacimiento, 123456789, "cliente@example.com");

            // Crear una instancia de ClienteController
            ClienteController controller = new ClienteController(null);

            // Agregar el cliente
            controller.Agregar(cliente1);

            // Buscar el cliente por identificación
            System.out.println("Buscando cliente por identificación 1:");
            controller.Buscar(1);

            // Intentar eliminar el cliente
            System.out.println("Intentando eliminar cliente con identificación 2:");
            Cliente cliente2 = new Cliente(2, "Otro Cliente", fechaNacimiento, 987654321, "otrocliente@example.com");
            controller.Eliminar(cliente2);

            // Listar todos los clientes
            System.out.println("Listando todos los clientes:");
            controller.buscarTodo();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

