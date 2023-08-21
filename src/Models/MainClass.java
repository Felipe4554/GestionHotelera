/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Models;
import Habitacion.Habitacion;
import Habitacion.HabitacionList;
import Habitacion.TipoHabitacion;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitacionList habitacionList = HabitacionList.getInstance();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar habitación");
            System.out.println("2. Listar habitaciones");
            System.out.println("3. Buscar habitación por número");
            System.out.println("4. Actualizar tipo de habitación");
            System.out.println("5. Eliminar habitación");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de habitación: ");
                    int numeroHabitacion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione el tipo de habitación:");
                    System.out.println("1. Individual");
                    System.out.println("2. Doble");
                    System.out.println("3. Suite");
                    int tipoSeleccionado = scanner.nextInt();
                    scanner.nextLine();

                    TipoHabitacion tipoHabitacion = null;
                    switch (tipoSeleccionado) {
                        case 1:
                            tipoHabitacion = TipoHabitacion.Individual;
                            break;
                        case 2:
                            tipoHabitacion = TipoHabitacion.Doble;
                            break;
                        case 3:
                            tipoHabitacion = TipoHabitacion.Suite;
                            break;
                        default:
                            System.out.println("Tipo de habitación inválido.");
                            continue; // Vuelve al menú principal
                    }

                    // Crea y agrega la habitación
                    Habitacion nuevaHabitacion = new Habitacion(numeroHabitacion, tipoHabitacion);
                    habitacionList.Agregar(nuevaHabitacion);
                    System.out.println("Habitación agregada con éxito.");
                    break;

                case 2:
                    // Lista todas las habitaciones
                    Habitacion[] habitaciones = habitacionList.toArray();
                    System.out.println("Lista de habitaciones:");
                    for (Habitacion habitacion : habitaciones) {
                        System.out.println("Número de habitación: " + habitacion.getNumeroHabitacion());
                        System.out.println("Tipo de habitación: " + habitacion.getTipoHabitacion());
                        System.out.println("Ocupada: " + (habitacion.isOcupada() ? "Sí" : "No"));
                        System.out.println("Precio: " + habitacion.getPrecio());
                        System.out.println("-----------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número de habitación a buscar: ");
                    int numeroBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Habitacion habitacionEncontrada = habitacionList.Buscar(numeroBuscar);
                    if (habitacionEncontrada != null) {
                        System.out.println("Habitación encontrada:");
                        System.out.println("Número de habitación: " + habitacionEncontrada.getNumeroHabitacion());
                        System.out.println("Tipo de habitación: " + habitacionEncontrada.getTipoHabitacion());
                        System.out.println("Ocupada: " + (habitacionEncontrada.isOcupada() ? "Sí" : "No"));
                        System.out.println("Precio: " + habitacionEncontrada.getPrecio());
                    } else {
                        System.out.println("Habitación no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número de habitación a actualizar: ");
                    int numeroActualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione el nuevo tipo de habitación:");
                    System.out.println("1. Individual");
                    System.out.println("2. Doble");
                    System.out.println("3. Suite");
                    int nuevoTipoSeleccionado = scanner.nextInt();
                    scanner.nextLine();

                    TipoHabitacion nuevoTipoHabitacion = null;
                    switch (nuevoTipoSeleccionado) {
                        case 1:
                            nuevoTipoHabitacion = TipoHabitacion.Individual;
                            break;
                        case 2:
                            nuevoTipoHabitacion = TipoHabitacion.Doble;
                            break;
                        case 3:
                            nuevoTipoHabitacion = TipoHabitacion.Suite;
                            break;
                        default:
                            System.out.println("Tipo de habitación inválido.");
                            continue; // Vuelve al menú principal
                    }

                    boolean actualizacionExitosa = habitacionList.actualizarTipoHabitacion(numeroActualizar, nuevoTipoHabitacion);
                    if (actualizacionExitosa) {
                        System.out.println("Tipo de habitación actualizado con éxito.");
                    } else {
                        System.out.println("No se pudo actualizar el tipo de habitación.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el número de habitación a eliminar: ");
                    int numeroEliminar = scanner.nextInt();
                    scanner.nextLine();

                    boolean eliminacionExitosa = habitacionList.Eliminar(new Habitacion(numeroEliminar, null, false, 0.0));
                    if (eliminacionExitosa) {
                        System.out.println("Habitación eliminada con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar la habitación.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
