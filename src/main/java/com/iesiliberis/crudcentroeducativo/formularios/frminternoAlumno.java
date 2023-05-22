/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.ControladorDAO.alumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.alumno;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raúl
 */
public class frminternoAlumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form frminternoAlumno
     */
    public frminternoAlumno() throws SQLException {
        initComponents();
        configtabla();
        cargatabla();
    }
    private void configtabla(){
        String col[]={"ID","DNI","NOMBRE","APELLIDOS","FECHA NACIMIENTO"};
        jtalumno.getModel();
        DefaultTableModel mode = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int row,int column){
                    return false;
                }
        };
        jtalumno.setModel(mode);
        
        
            
        
    }
    
    private void cargatabla() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel)jtalumno.getModel();
        modelo.setNumRows(0);
        
        alumnoDaoImp al=alumnoDaoImp.getInstance();
        List<alumno> alumnos=al.getAll();
        String [] fila =new String[5];
        for (alumno alum:alumnos){
            fila[0]=""+alum.getId();
            fila[1]=""+alum.getDni();
            fila[2]=""+alum.getNombre();
            fila[3]=""+alum.getApellido1()+" " + alum.getApellido2();
            fila[4]=""+alum.getfNacimiento();
            modelo.addRow(fila);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtalumno = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jtalumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtalumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtalumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtalumno);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 152, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtalumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtalumnoMouseClicked
        if (evt.getClickCount()==2){
            //JDialog frame=new JDialog(this,"Detalle Alumno",true);
            jpAlumnoDetalle panel=new jpAlumnoDetalle();
            int idseleccion=Integer.parseInt(jtalumno.getValueAt(jtalumno.getSelectedRow(), 0).toString());
            panel.CargaDetalle(idseleccion);
            //frame.getContentPane().add(panel);
            //frame.pack();
            //frame.setVisible(true);
        }
    }//GEN-LAST:event_jtalumnoMouseClicked

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel modelo = (DefaultTableModel) jtalumno.getModel();
            TableRowSorter<TableModel> trsorter= new TableRowSorter(modelo);
            jtalumno.setRowSorter(trsorter);
            if (txtbuscar.getText().length()==0){
                trsorter.setRowFilter(null);
            }else{
                trsorter.setRowFilter(RowFilter.regexFilter(txtbuscar.getText().trim()));
            }

        }
    }//GEN-LAST:event_txtbuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtalumno;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}