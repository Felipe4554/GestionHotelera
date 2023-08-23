/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Habitacion;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;

public class MainApp {

    public static void main(String[] args) {
        // Crear una ventana principal
        JFrame mainFrame = new JFrame("Gestión de Habitaciones");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        // Crear un panel de escritorio para las ventanas internas
        JDesktopPane desktopPane = new JDesktopPane();
        mainFrame.add(desktopPane);

        // Crear y mostrar FrmHabitacion
        FrmHabitacion frmHabitacion = new FrmHabitacion();
        frmHabitacion.setVisible(true);
        desktopPane.add(frmHabitacion);

        // Crear y mostrar FrmTabla
        FrmTabla frmTabla = new FrmTabla();
        frmTabla.setVisible(false); // Inicialmente oculto
        desktopPane.add(frmTabla);

        // Hacer que FrmTabla sea visible cuando se active el evento en FrmHabitacion
        frmTabla.setVisible(true);

        // Mostrar la ventana principal
        mainFrame.setVisible(true);
    }
}

