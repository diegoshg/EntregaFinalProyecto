/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ControladorModificar;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class panelModificar extends javax.swing.JPanel {
    private ControladorModificar cm = new ControladorModificar();
    /**
     * Creates new form panelModificar
     */
    public panelModificar() {
        initComponents();
        //configuracion de flatlaf
        jLabel1.putClientProperty("FlatLaf.style", "font: $h2.font");
        jLabel2.putClientProperty("FlatLaf.style", "font: $h2.font");
        jLabel3.putClientProperty("FlatLaf.style", "font: $h2.font");
        botonModificar.putClientProperty( "JButton.buttonType" , "roundRect" );
        juegoNombre.setToolTipText("Introduzca el nombre del juego");
        precioNuevo.setToolTipText("Introduzca el nuevo precio");
        ISBNJuego.setToolTipText("Introduzca el ISBN del juego");
        botonModificar.setToolTipText("Boton para modificar los datos");
        juegoNombre.putClientProperty( "JTextField.placeholderText" , "ingrese el nombre del juego" );
        precioNuevo.putClientProperty( "JTextField.placeholderText" , "ingrese el nuevo precio" );
        ISBNJuego.putClientProperty( "JTextField.placeholderText" , "ingrese el ISBN del juego");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        juegoNombre = new javax.swing.JTextField();
        ISBNJuego = new javax.swing.JTextField();
        precioNuevo = new javax.swing.JTextField();
        botonModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 2, 221));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre Juego:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ISBN:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio:");

        botonModificar.setBackground(new java.awt.Color(0, 0, 0));
        botonModificar.setForeground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("MODIFICAR");
        botonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonModificarMouseExited(evt);
            }
        });
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/assc.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(juegoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(ISBNJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(precioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(juegoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ISBNJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(precioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (juegoNombre.getText().isEmpty()|| precioNuevo.getText().isEmpty()||ISBNJuego.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduzca todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String nombre = juegoNombre.getText();
            double prec = Double.parseDouble(precioNuevo.getText());
            String nomI = ISBNJuego.getText();
            boolean compJuego = cm.comprobarJuegoExiste(nombre);
            try {
                if (compJuego) {
                    cm.modificarJuegos(nomI, nombre, prec);
                    JOptionPane.showMessageDialog(null, "Datos modificados correctamente", "Bien", JOptionPane.INFORMATION_MESSAGE);
                    juegoNombre.setText("");
                    precioNuevo.setText("");
                    ISBNJuego.setText("");
                }   
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed
//metodos para los holder de los botones y el cursor, al entrar en el boton cambia el brillo del boton y el cursor se vuelve una mano y al salir vuelva a la normalidad 
    private void botonModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarMouseEntered
         botonModificar.setBackground(new Color(75, 72, 71));
    }//GEN-LAST:event_botonModificarMouseEntered

    private void botonModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarMouseExited
        botonModificar.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_botonModificarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ISBNJuego;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField juegoNombre;
    private javax.swing.JTextField precioNuevo;
    // End of variables declaration//GEN-END:variables
}
