/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.ControladorDAO.CursoAcademicoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raúl
 */
public class frmCursoAcademico extends javax.swing.JFrame {

    /**
     * Creates new form CursoAcademico
     */
    public frmCursoAcademico() throws SQLException {
        initComponents();
        configtabla();
        cargatabla();
    }
    private void configtabla(){
        String col[]={"ID","AÑO INICIO","AÑO FIN","DESCRIPCION"};
        jtCursoAcademico.getModel();
        DefaultTableModel mode = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int row,int column){
                    return false;
                }
        };
        jtCursoAcademico.setModel(mode);
    }
    private void cargatabla() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel)jtCursoAcademico.getModel();
        modelo.setNumRows(0);
        
        CursoAcademicoDaoImp al=CursoAcademicoDaoImp .getInstance();
        List<cursoacademico> cursos=al.getAll();
        String [] fila =new String[4];
        for (cursoacademico curs:cursos){
            fila[0]=""+curs.getId();
            fila[1]=""+curs.getYearinicio();
            fila[2]=""+curs.getYearfin();
            fila[3]=""+curs.getDescripcion();
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
        jtCursoAcademico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtañoinicio = new javax.swing.JTextField();
        txtañofin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtCursoAcademico.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCursoAcademico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCursoAcademicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCursoAcademico);

        jLabel1.setText("AñoInicio");

        jLabel2.setText("AñoFin");

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(106, 106, 106))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtañoinicio)
                        .addGap(55, 55, 55)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtañofin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtañoinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtañofin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CursoAcademicoDaoImp curs=CursoAcademicoDaoImp.getInstance();
        String Descripcion = "Curso " + txtañoinicio.getText().substring(2,4) +"-"+ txtañofin.getText().substring(2,4);
        cursoacademico cur= new cursoacademico(Integer.parseInt(txtañoinicio.getText()),Integer.parseInt(txtañofin.getText()),Descripcion);
        
        try {
            if (txtañoinicio.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Falta el año de inicio");
            }
            else if (txtañofin.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Falta el año de fin");
            }
            else {
            curs.add(cur);
            cargatabla();
            txtañoinicio.setText("");
            txtañofin.setText("");
            }
            
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = jtCursoAcademico.getSelectedRow();
        String id=String.valueOf(jtCursoAcademico.getValueAt(fila, 0));
        CursoAcademicoDaoImp curs=CursoAcademicoDaoImp.getInstance();
        String Descripcion = "Curso " + txtañoinicio.getText().substring(2,4) + "-" + txtañofin.getText().substring(2,4);
        
        cursoacademico cur= new cursoacademico(Integer.parseInt(id),Integer.parseInt(txtañoinicio.getText()),Integer.parseInt(txtañofin.getText()),Descripcion);
        
        try {
            if (txtañoinicio.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Falta el año de inicio");
            }
            else if (txtañofin.getText().equals("")){
                
                

                
                JOptionPane.showMessageDialog(this,"Falta el año de fin");
            }
            else {
            curs.update(cur);
            cargatabla();
            txtañoinicio.setText("");
            txtañofin.setText("");
            }
            
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = jtCursoAcademico.getSelectedRow();
        String id = String.valueOf(jtCursoAcademico.getValueAt(fila, 0));
        CursoAcademicoDaoImp curs=CursoAcademicoDaoImp.getInstance();
        try {
            curs.delete(Integer.parseInt(id));
            cargatabla();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtCursoAcademicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCursoAcademicoMouseClicked
        int fila = jtCursoAcademico.getSelectedRow();
        txtañoinicio.setText(String.valueOf(jtCursoAcademico.getValueAt(fila, 1)));
        txtañofin.setText(String.valueOf(jtCursoAcademico.getValueAt(fila, 2)));
    }//GEN-LAST:event_jtCursoAcademicoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCursoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCursoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCursoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCursoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmCursoAcademico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmCursoAcademico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCursoAcademico;
    private javax.swing.JTextField txtañofin;
    private javax.swing.JTextField txtañoinicio;
    // End of variables declaration//GEN-END:variables
}
