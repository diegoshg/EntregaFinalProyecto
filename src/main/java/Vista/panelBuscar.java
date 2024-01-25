/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ControladorBuscarCliente;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Sanchez Gandara
 */
public class panelBuscar extends javax.swing.JPanel {
    private ControladorBuscarCliente cbc = new ControladorBuscarCliente();
    DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form panelBuscar
     */
    public panelBuscar() {
        initComponents();
        //configuracion de flatlaf
        introducirNombreJuego.putClientProperty( "JComponent.roundRect", true );
        introducirNombreJuego.putClientProperty( "JTextField.placeholderText" , "ingrese el nombre del juego" );
        introducirNombreJuego.setToolTipText("Introduzca el nombre del juego");
        botonBuscar.setToolTipText("Boton para buscar");
        botonLimpiar.setToolTipText("Boton para limpiar la tabla");
        botonBuscar.putClientProperty( "JButton.buttonType" , "roundRect" );
        botonLimpiar.putClientProperty( "JButton.buttonType" , "roundRect" );
        tablaResultados.setToolTipText("Tabla de resultados");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introducirNombreJuego = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 2, 221));

        botonBuscar.setBackground(new java.awt.Color(0, 0, 0));
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        botonBuscar.setBorder(new javax.swing.border.MatteBorder(null));
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonBuscarMouseExited(evt);
            }
        });
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        botonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setToolTipText("");
        botonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonLimpiarMouseExited(evt);
            }
        });
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        tablaResultados.setBackground(new java.awt.Color(255, 255, 255));
        tablaResultados.setForeground(new java.awt.Color(0, 0, 0));
        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id cliente", "Nombre Cliente"
            }
        ));
        jScrollPane1.setViewportView(tablaResultados);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/espadas.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(introducirNombreJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(introducirNombreJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)))
        );
    }// </editor-fold>//GEN-END:initComponents
    //boton para buscar
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (introducirNombreJuego.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduzca un nombre de juego", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            //recogemos el nombre del juego
            String nombre = introducirNombreJuego.getText();
            //comprobamos si existe
            boolean comprobar = cbc.comprobarJuegoExiste(nombre);
            if (comprobar) {
                //mostramos el modelo en la tabla
                modelo = cbc.mostrarClientes(nombre);
                tablaResultados.setModel(modelo);
                introducirNombreJuego.putClientProperty( "JTextField.placeholderText" , "ingrese el nombre del juego" );
            }
            
        } catch (Exception e) {
        }
        }
        
    }//GEN-LAST:event_botonBuscarActionPerformed
    //boton para limpiar la tabla
    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        int numero = modelo.getRowCount();
        for (int i = numero - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }//GEN-LAST:event_botonLimpiarActionPerformed

    //metodos para los holder de los botones y el cursor, al entrar en el boton cambia el brillo del boton y el cursor se vuelve una mano y al salir vuelva a la normalidad 
    private void botonLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLimpiarMouseEntered
        botonLimpiar.setBackground(new Color(75, 72, 71));
    }//GEN-LAST:event_botonLimpiarMouseEntered

    private void botonLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLimpiarMouseExited
        botonLimpiar.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_botonLimpiarMouseExited

    private void botonBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseEntered
        botonBuscar.setBackground(new Color(75, 72, 71));
    }//GEN-LAST:event_botonBuscarMouseEntered

    private void botonBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseExited
        botonBuscar.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_botonBuscarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JTextField introducirNombreJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}