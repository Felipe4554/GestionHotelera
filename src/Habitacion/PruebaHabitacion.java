/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Habitacion;
import Habitacion.*;
import Views.View;

import javax.swing.JOptionPane;

public class PruebaHabitacion {

    public static void main(String[] args) {
        // Crear una instancia de la vista (puedes implementar tu propia vista según tus necesidades)
        View<Habitacion> vista = new FrmHabitacion();

        // Crear una instancia del controlador
        HabitacionController controlador = new HabitacionController(vista);

        while (true) {
            // Mostrar un menú de opciones al usuario
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n" +
                    "1. Agregar habitación\n" +
                    "2. Actualizar tipo de habitación\n" +
                    "3. Eliminar habitación\n" +
                    "4. Buscar habitación\n" +
                    "5. Salir");

            if (opcion == null) {
                // El usuario cerró la ventana de diálogo o seleccionó Cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    // Agregar habitación
                    ingresarHabitacion(controlador);
                    break;
                case "2":
                    // Actualizar tipo de habitación
                    actualizarTipoHabitacion(controlador);
                    break;
                case "3":
                    // Eliminar habitación
                    eliminarHabitacion(controlador);
                    break;
                case "4":
                    // Buscar habitación
                    buscarHabitacion(controlador);
                    break;
                case "5":
                    // Salir
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void ingresarHabitacion(HabitacionController controlador) {
        try {
            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación:"));
            String tipoStr = JOptionPane.showInputDialog("Ingrese el tipo de habitación (Individual, Doble, Suite):");
            TipoHabitacion tipoHabitacion = TipoHabitacion.valueOf(tipoStr);
            boolean ocupada = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Está ocupada? (true/false):"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));

            Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion, ocupada, precio);
            controlador.Agregar(habitacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Asegúrese de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Tipo de habitación no válido. Use Individual, Doble o Suite.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void actualizarTipoHabitacion(HabitacionController controlador) {
        try {
            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación:"));
            String tipoStr = JOptionPane.showInputDialog("Ingrese el nuevo tipo de habitación (Individual, Doble, Suite):");
            TipoHabitacion nuevoTipoHabitacion = TipoHabitacion.valueOf(tipoStr);

            Habitacion habitacion = new Habitacion(numeroHabitacion, nuevoTipoHabitacion);
            controlador.Actualizar(habitacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Asegúrese de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Tipo de habitación no válido. Use Individual, Doble o Suite.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarHabitacion(HabitacionController controlador) {
        try {
            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a eliminar:"));

            Habitacion habitacion = new Habitacion(numeroHabitacion, null); // Solo necesitamos el número de habitación
            controlador.Eliminar(habitacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Asegúrese de ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarHabitacion(HabitacionController controlador) {
        try {
            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación a buscar:"));

            controlador.Buscar(numeroHabitacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Asegúrese de ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
