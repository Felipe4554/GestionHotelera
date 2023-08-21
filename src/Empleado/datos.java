/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Empleado;


import Controller.Controller;
import Models.Table;
import Views.View;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Empleado.Empleado; 


/**
 *
 * @author rsand
 */
public class datos extends javax.swing.JInternalFrame implements View<Empleado> {  
  
    private FrmEmpleado frmEmpleado;
    private Controller controller;
    private Empleado empleado;
    
    public datos(FrmEmpleado frmEmpleado) {
        this.frmEmpleado = frmEmpleado;
        frmEmpleado.addObserver(this);
        // Resto de la inicialización...
    }
    
    public datos() {
        initComponents();
        this.empleado = empleado;
        this.loadPuestos();  // Cambio del método
        this.controller = new EmpleadoControler(this); 
        this.controller.buscarTodo(); 
        
    }
         
     
    private void loadPuestos() {
   
    }
    
    @Override
    public void clear() {
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtPuesto.setText("");
        txtSalario.setText("");
    }

    @Override
    public void display(Empleado empleado) {  // Cambio del nombre de la clase

    frmEmpleado.txtIdentificacion.setText(empleado.getIdentificacion());
    frmEmpleado.txtNombre.setText(empleado.getNombre());
    frmEmpleado.txtTelefono.setText(empleado.getTelefono());
    frmEmpleado.txtPuesto.setSelectedItem(empleado.getPuesto());
    frmEmpleado.txtSalario.setText(String.valueOf(empleado.getSalario()));
    
    }
    
    @Override
    public void displayAll(Empleado[] regs) {  // Cambio del nombre de la clase
        DefaultTableModel tableModel = (DefaultTableModel) tblEmpleados.getModel();
        tableModel.setNumRows(0);
        for (Empleado empleado : regs) {
            Object[] datos = empleado.toArrayObject();
            tableModel.addRow(datos);
        }
        tblEmpleados.setModel(tableModel);
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
        tblEmpleados = new javax.swing.JTable();

        setClosable(true);

        txtFiltro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Teléfono", "Puesto", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setColumnSelectionAllowed(true);
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        tblEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEmpleadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);
        tblEmpleados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
        Table.filter(this.tblEmpleados, txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tblEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEmpleadosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int row = tblEmpleados.getSelectedRow();
            if (row > -1) {
                Object identificacion = tblEmpleados.getValueAt(row, 0);
                controller.Eliminar(new Empleado(identificacion.toString()));  // Cambio del nombre de la clase
            }
        }
    }//GEN-LAST:event_tblEmpleadosKeyReleased

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblEmpleados.getSelectedRow();
            Object identificacion = tblEmpleados.getValueAt(row, 0);
            controller.Buscar(identificacion);
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

}
