/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.ControladorDAO.CursoAcademicoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.cursoacademico;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Raúl
 */
public class frmMain extends javax.swing.JFrame {
    
    public int idcursaca;

    /**
     * Creates new form frmMain
     */
    public frmMain() throws SQLException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel status = new JPanel();
        JLabel statusLabel = new JLabel("");
        status.add( statusLabel );
        this.getContentPane().add(status, BorderLayout.SOUTH);
        generaMenuCursosAcademicos();
    }
    private void generaMenuCursosAcademicos() throws SQLException{
        ButtonGroup bgrCursosAcademicos=new ButtonGroup();
        CursoAcademicoDaoImp curs=CursoAcademicoDaoImp.getInstance();
        JRadioButtonMenuItem jrb;
        for (cursoacademico cur:curs.getAll()){
            String año=cur.getDescripcion();
            jrb= new JRadioButtonMenuItem(año,true);
            bgrCursosAcademicos.add(jrb);
            jrb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JRadioButtonMenuItem jrbselected=(JRadioButtonMenuItem)e.getItem();
                    jrbselected.setName(""+cur.getId());
                    System.out.println(jrbselected.getName());
                                    
                    
                }
            
            });
            
            
        
        
            
            
            
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

        pnldEscritorio = new javax.swing.JDesktopPane();
        btncursos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        optmAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btncursos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btncursos.setText("MATRICULACIONES");
        btncursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncursosActionPerformed(evt);
            }
        });
        pnldEscritorio.add(btncursos);
        btncursos.setBounds(750, 390, 260, 80);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("PERSONAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnldEscritorio.add(jButton1);
        jButton1.setBounds(1050, 390, 260, 80);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("ALUMNOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnldEscritorio.add(jButton2);
        jButton2.setBounds(490, 390, 230, 80);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Parametrizacion");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        optmAcercade.setMnemonic('a');
        optmAcercade.setText("Acerca de");
        optmAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optmAcercadeActionPerformed(evt);
            }
        });
        helpMenu.add(optmAcercade);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnldEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnldEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void optmAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optmAcercadeActionPerformed
        //frmAcercade frmacerca= new frmAcercade();
        //frmacerca.setVisible(true);
        frmAcercadeDialogo frmacerca= new frmAcercadeDialogo(this,rootPaneCheckingEnabled);
        frmacerca.setVisible(true);
    }//GEN-LAST:event_optmAcercadeActionPerformed

    private void btncursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncursosActionPerformed
        FrmCursos fmain;
        try {
            fmain = new FrmCursos();
            fmain.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btncursosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmPersonal fmain;
        try {
            fmain = new frmPersonal();
            fmain.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMain().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncursos;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem optmAcercade;
    private javax.swing.JDesktopPane pnldEscritorio;
    // End of variables declaration//GEN-END:variables

}
