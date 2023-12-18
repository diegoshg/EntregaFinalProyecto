/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import Vista.panelBuscar;
import Vista.panelIntroducir;
import Vista.panelListar;
import Vista.panelModificar;
import javax.swing.JPanel;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Introducir
     */
    public VentanaPrincipal() {
        initComponents();
        mensajeCambiante.putClientProperty("FlatLaf.style", "font: $h3.font");
        panelIntroducir pi = new panelIntroducir();
        pi.setSize(375,523);
        pi.setLocation(0, 0);
        mostrarPanel(pi);
        imagenPerfil.setSvgImage("src/main/resources/img/perfil.svg", 100, 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        botonIntroducir = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonListar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        panelCambiante = new javax.swing.JPanel();
        mensajeCambiante = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        imagenPerfil = new com.mycompany.flatlaffull.SVGImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        fondo.setBackground(new java.awt.Color(0, 0, 0));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInferior.setBackground(new java.awt.Color(255, 255, 255));

        botonIntroducir.setBackground(new java.awt.Color(255, 255, 255));
        botonIntroducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/introducir.png"))); // NOI18N
        botonIntroducir.setBorder(new javax.swing.border.MatteBorder(null));
        botonIntroducir.setBorderPainted(false);
        botonIntroducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIntroducirActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        botonBuscar.setBorder(new javax.swing.border.MatteBorder(null));
        botonBuscar.setBorderPainted(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonListar.setBackground(new java.awt.Color(255, 255, 255));
        botonListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lista (2).png"))); // NOI18N
        botonListar.setBorder(new javax.swing.border.MatteBorder(null));
        botonListar.setBorderPainted(false);
        botonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarActionPerformed(evt);
            }
        });

        botonModificar.setBackground(new java.awt.Color(255, 255, 255));
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cambio.png"))); // NOI18N
        botonModificar.setBorder(new javax.swing.border.MatteBorder(null));
        botonModificar.setBorderPainted(false);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addComponent(botonIntroducir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonIntroducir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        fondo.add(panelInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 613, -1, 54));

        panelCambiante.setBackground(new java.awt.Color(6, 2, 221));

        javax.swing.GroupLayout panelCambianteLayout = new javax.swing.GroupLayout(panelCambiante);
        panelCambiante.setLayout(panelCambianteLayout);
        panelCambianteLayout.setHorizontalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        panelCambianteLayout.setVerticalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        fondo.add(panelCambiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        mensajeCambiante.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        mensajeCambiante.setForeground(new java.awt.Color(255, 255, 255));
        mensajeCambiante.setText("INTRODUCIR");
        fondo.add(mensajeCambiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 38, 93, 21));

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setText("CERRAR SESION");
        jButton1.setToolTipText("boton para cerrar sesion");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 30, 132, 40));
        fondo.add(imagenPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 51, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonIntroducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIntroducirActionPerformed
        panelIntroducir pi = new panelIntroducir();
        pi.setSize(375,523);
        pi.setLocation(0, 0);
        mostrarPanel(pi);
        mensajeCambiante.setText("INTRODUCIR");
    }//GEN-LAST:event_botonIntroducirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        panelBuscar pb = new panelBuscar();
        pb.setSize(375,523);
        pb.setLocation(0, 0);
        mostrarPanel(pb);
        mensajeCambiante.setText("CONSULTAR");
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarActionPerformed
        panelListar pl = new panelListar();
        pl.setSize(375,523);
        pl.setLocation(0, 0);
        mostrarPanel(pl);
        mensajeCambiante.setText("LISTAR");
    }//GEN-LAST:event_botonListarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        panelModificar pm = new panelModificar();
        pm.setSize(375,523);
        pm.setLocation(0, 0);
        mostrarPanel(pm);
        mensajeCambiante.setText("MODIFICAR");
    }//GEN-LAST:event_botonModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatIntelliJLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    
    private void mostrarPanel(JPanel panel){
        panelCambiante.removeAll();
        panelCambiante.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonIntroducir;
    private javax.swing.JButton botonListar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JPanel fondo;
    private com.mycompany.flatlaffull.SVGImage imagenPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel mensajeCambiante;
    private javax.swing.JPanel panelCambiante;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
