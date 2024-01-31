/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorEmail;
import Controlador.EmailUtil;
import Controlador.controladorLoggin;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;

/**
 *Esta pantalla sirve para recuperar la contraseña del usuario. Manda un email a el usuario correspondiente con
 * la nueva contraseña, la guarda en la base de datos y la encripta.
 * @author Diego Sanchez Gandara
 */
public class RecuperarContrasena extends javax.swing.JFrame {
    private Loggin log;
    private ControladorEmail ce = new ControladorEmail();
    
    public RecuperarContrasena() {
        initComponents();
        //diseños flat laf
        botonRecuperar.putClientProperty( "JButton.buttonType" , "roundRect" );
        emailRec.putClientProperty("JTextField.placeholderText", "ingrese el email de usuario");
        emailRec.setToolTipText("Ingrese aqui su email");
        botonRecuperar.setToolTipText("Boton para enviar email al usuario");
    }

    /**
     * Este boton cierra esta ventana y vuelve a la ventana del loggin.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailRec = new javax.swing.JTextField();
        botonRecuperar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INTRODUZCA SU EMAIL ");

        emailRec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailRec.setToolTipText("");

        botonRecuperar.setBackground(new java.awt.Color(0, 0, 0));
        botonRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        botonRecuperar.setText("Recuperar");
        botonRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonRecuperarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonRecuperarMouseExited(evt);
            }
        });
        botonRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecuperarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fantasma.png"))); // NOI18N

        botonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/volver.png"))); // NOI18N
        botonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addGap(21, 21, 21))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailRec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(botonRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(botonRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

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
   
    private void botonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVolverMouseClicked
        if (log == null) {
            log = new Loggin();
            log.setVisible(true);
        }
        
        dispose();
    }//GEN-LAST:event_botonVolverMouseClicked
    
   /**
    * Este boton comprueba si los datos del email estan vacion, si lo estan muestra un mensaje, sino lo 
    * recupera de la base de datos tras comprobar que existe y manda el correo.
    * @param evt 
    */
    private void botonRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecuperarActionPerformed
        if (emailRec.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Introduzca todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String mail = emailRec.getText();
        boolean existe = ce.verificarEmail(mail);
        //comprobamos si existe el mail
        if (existe) {
            String nueva = ce.generarContrasena(5, 10);
            final String fromemail = "diego.sangan@educa.jcyl.es";
            final String password = "diego0612";
            final String toemail = mail;
            System.out.println("SSLEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Authenticator auth = new Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromemail, password);
              }
            };

            Session session = Session.getDefaultInstance(props, auth);
            System.out.println("Session created");
            try {
                EmailUtil.sendEmail(session, toemail, "SSLEmail Testing Subject", nueva);
            } catch (MessagingException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            //informamos de que se ha modificado la contraseña
            JOptionPane.showMessageDialog(rootPane, "La contraseña se ha actualizado correctamente", "Envio", JOptionPane.INFORMATION_MESSAGE);
            ce.actualizarContrasena(mail, nueva);
            //cerramos la ventana
            dispose();
            if (log == null) {
                log = new Loggin();
                log.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No existe el correo en la base de datos");
        }
        }
        
        
        
        
    }//GEN-LAST:event_botonRecuperarActionPerformed

    /**
     * Estos eventos sirven para cambiar el hover del boton tras introducir y sacar el raton.
     * @param evt 
     */
    private void botonRecuperarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRecuperarMouseEntered
        setCursor(HAND_CURSOR);
        botonRecuperar.setBackground(new Color(75, 72, 71));
    }//GEN-LAST:event_botonRecuperarMouseEntered

    private void botonRecuperarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRecuperarMouseExited
        setCursor(Cursor.getDefaultCursor());
         botonRecuperar.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_botonRecuperarMouseExited

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
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarContrasena().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRecuperar;
    private javax.swing.JLabel botonVolver;
    private javax.swing.JTextField emailRec;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
