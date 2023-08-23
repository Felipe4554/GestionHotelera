/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Habitacion;


import Empleado.*;
import Controller.Controller;
import Models.Table;
import Views.View;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Empleado.Empleado; 
import static Empleado.FrmEmpleado.txtIdentificacion;
import static Empleado.FrmEmpleado.txtNombre;
import static Empleado.FrmEmpleado.txtSalario;
import static Empleado.FrmEmpleado.txtTelefono;
import static Habitacion.FrmHabitacion.txtNumeroHabitacion;
import static Habitacion.FrmHabitacion.txtPrecio;
import static Habitacion.FrmHabitacion.txtTipo;
import static Habitacion.TipoHabitacion.Individual;
import static Habitacion.FrmHabitacion.txtOcupada;
import java.awt.event.MouseEvent;

/**
 *
 * @author jprod
 */
public class FrmBusc extends javax.swing.JInternalFrame implements View<Habitacion> {  

    static Object getTblEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
// Cambio del nombre de la clase
    private Controller controller;
    private Habitacion habitacionSeleccionada;
    private FrmHabitacion frmHabitacion;
    private Habitacion habitacion;
    
    
    
    public FrmBusc(FrmHabitacion frmHabitacion) {
        this.frmHabitacion = frmHabitacion;
        frmHabitacion.addObserver(this);
        // Resto de la inicialización...
    }
    public FrmBusc() {
        initComponents();
        this.habitacionSeleccionada = habitacionSeleccionada;
        this.loadPuestos();  // Cambio del método
        this.frmHabitacion = frmHabitacion;
        this.habitacion = habitacion;
        this.controller = new HabitacionController(this);  // Cambio del nombre de la clase
        this.controller.buscarTodo(); 
        
    }
         
     
    private void loadPuestos() {
   
    }
    
    @Override
    public void clear() {
        frmHabitacion.txtNumeroHabitacion.setText("");
        frmHabitacion.txtTipo.setSelectedItem("");
        frmHabitacion.txtOcupada.setText("No");
        frmHabitacion.txtPrecio.setText("0");

    }
    @Override 
    public void display(Habitacion habitacion) {  // Cambio del nombre de la clase

        frmHabitacion.txtNumeroHabitacion.setText(String.valueOf(habitacion.getNumeroHabitacion()));
        TipoHabitacion tipoSeleccionado = habitacion.getTipoHabitacion();
        txtTipo.setSelectedItem(tipoSeleccionado);
        txtOcupada.setText(habitacion.isOcupada() ? "Ocupada" : "Libre");
        frmHabitacion.txtPrecio.setText(String.valueOf(habitacion.getPrecio()));
        this.dispose();
    }

    @Override
    public void displayAll(Habitacion[] regs) {  // Cambio del nombre de la clase
        DefaultTableModel tableModel = (DefaultTableModel) tblHabitaciones.getModel();
    tableModel.setNumRows(0);
    for (Habitacion habitacion : regs) {
        Object[] hab = habitacion.toArrayObject();
        tableModel.addRow(hab);
    }
    tblHabitaciones.setModel(tableModel);
    }

    @Override
    public void displayMessaje(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Información Importante", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void displayErrorMessaje(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public boolean displayConfirmMessaje(String msj) {
        int option = JOptionPane.showConfirmDialog(this, msj, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabitaciones = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Habitacion");

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        tblHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Habitacion", "Tipo", "Estado", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHabitaciones.setColumnSelectionAllowed(true);
        tblHabitaciones.getTableHeader().setReorderingAllowed(false);
        tblHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabitacionesMouseClicked(evt);
            }
        });
        tblHabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblHabitacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblHabitaciones);
        tblHabitaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblHabitaciones.getColumnModel().getColumnCount() > 0) {
            tblHabitaciones.getColumnModel().getColumn(2).setHeaderValue("Estado");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        Views.Table.filter(this.tblHabitaciones, txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tblHabitacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblHabitacionesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int row = tblHabitaciones.getSelectedRow();
            if (row > -1) {
                Object numeroHabitacionObj = tblHabitaciones.getValueAt(row, 0);
                // Intenta convertir el número de habitación a entero
                try {
                    int numeroHabitacion = Integer.parseInt(numeroHabitacionObj.toString());
                    // Puedes mostrar un mensaje de confirmación antes de eliminar el registro
                    int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta habitación?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        controller.Eliminar(new Habitacion(numeroHabitacion));
                    }
                } catch (NumberFormatException e) {
                    // Maneja la excepción si el número de habitación no es un valor numérico
                    JOptionPane.showMessageDialog(this, "El número de habitación no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_tblHabitacionesKeyReleased

    private void tblHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHabitacionesMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblHabitaciones.getSelectedRow();
            Object identificacion = tblHabitaciones.getValueAt(row, 0);
            controller.Buscar(identificacion);
        }
    }//GEN-LAST:event_tblHabitacionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblHabitaciones;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

}
