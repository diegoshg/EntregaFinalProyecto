/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.Juegos;
import model.Ventas;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *Esta clase contiene los metodos para listar todos los datos de los juegos y los clientes,
 * mostramos el nombre del juego, su plataforma, el pecio y el cliente correspondiente.
 * Ademas de un metodo para eliminar un venta pasandole el nombre de un juego y un cliente
 * al seleccionar una fila de la tabla.
 * @author Diego Sanchez Gandara
 */
public class ControladorListar {
    private Render r = new Render();
    /**
     * Este metodo sirve para recoger los datos de las tablas de juegos y clientes y mostarlos en la 
     * tabla de la aplicacion. Llamamos a los datos con las consultas y almacenamos sus resultados en una variable
     * que es filaUnica, creamos un array de filas en los que vamos almacenando las filas que se van guardando 
     * al recoger los datos y luego comprobamos el array para que comprobar las filas que contiene.
     * Si ya contiene una fila con unos datos no lo introduce y asi hasta que termina de recoger datos de las tablas.
     * @return un modelo para la tabla
     */
    public DefaultTableModel recogerDatos(JTable tabla){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Object[]> query = session.createQuery("SELECT j.ISBN, j.nombreJuego, j.plataforma, j.precio, c.nombreCliente " +
                        "FROM Juegos j, Clientes c " +
                        "JOIN Ventas v ON j.idJuego = v.juegos.idJuego " +
                        "JOIN Clientes c ON v.clientes.idCliente = c.idCliente ", Object[].class);
            
            List<Object[]> resultado = query.list();
            tabla.setDefaultRenderer(Object.class, new Render());
            JButton boton; 
           
            DefaultTableModel model = new DefaultTableModel();
           
            model.addColumn("ISBN");
            model.addColumn("Juego");
            model.addColumn("Plataforma");
            model.addColumn("Precio");
            model.addColumn("Cliente");
            model.addColumn("");
            
            
           
            Set<String> filasUnicas = new HashSet<>();
          for (Object[] row : resultado) {
                boton = new JButton();
                boton.putClientProperty("JButton.trailingIcon", new FlatSVGIcon("img/papelera.svg",26,26));
                String ISBN = (String) row[0];
                String nombreJuego = (String) row[1];
                String plataforma = (String) row[2];
                Double precio = (Double) row[3];
                String nombreCliente = (String) row[4];
                boton =  (JButton) r.getTableCellRendererComponent(tabla, boton, true, true, tabla.getRowCount(), 5);
                boton.setToolTipText("Boton para eliminar un registro");
                
                boton.setEnabled(true);
                
                
                
                
           

                String filaUnica = ISBN + nombreJuego + plataforma + precio + nombreCliente;

                if (!filasUnicas.contains(filaUnica)) {
                   
                    model.addRow(new Object[]{ISBN, nombreJuego, plataforma, precio, nombreCliente, boton});
                    filasUnicas.add(filaUnica);
                    
                    /**
                     * Esta accion es del boton de la tabla, busca el id del juego y el cliente de la fila de la
                     * tabla seleccionada y luego busca el id de venta en base a los dos anteriores.
                     * Despues, borra esa venta.
                     */
                    boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("--------------------");
                        int idJ = obtenerIdJuego(ISBN);
                        int idC = obtenerIdCliente(nombreCliente);
                        int idV = comprobarVenta(idJ, idC);
                        eliminarVenta(idV);
                        JOptionPane.showMessageDialog(null, "Venta eliminada con exito", "Bien", JOptionPane.INFORMATION_MESSAGE);

                    }
                  });
    
            }
                
            
                
            
          }
          
            
            transaction.commit();
            return model;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        

        return null;
    }
    
    /**
     * metodo para evitar que la tabla sea editable
     * @param row fila de tabla
     * @param column columna de la tabla
     * @return true or false
     */
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
    
    
    /**
     * Comprueba si existe una venta con los datos seleccionados en la tabla
     * @param idJ se le pasa el id del juego
     * @param idC se le pasa el id del cliente
     * @return variable int
     */
    public int comprobarVenta(int idJ, int idC){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        int idV = -1;
        try {
           String sql = "from Ventas v where v.juegos.idJuego = :idJuego and v.clientes.idCliente = :idCliente";
            Query q = sesion.createQuery(sql);
            q.setParameter("idJuego", idJ);
            q.setParameter("idCliente", idC);
            List<Ventas> lista = q.getResultList();
            for (Ventas ventas : lista) {
                if (ventas != null) {
                    idV = ventas.getIdVenta();
                }
            }
            
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return idV;
    }
    
    
    /**
     * Metodo para obtener el id del juego de la tabla.
     * @param isbn se le pasa el isbn del juego.
     * @return variable int
     */
   public int obtenerIdJuego(String isbn){
         SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        int id = -1;
        try {
            String sql = "from Juegos where isbn = :isbn";
            Query q = sesion.createQuery(sql);
            q.setParameter("isbn", isbn);
            List<Juegos> lista = q.getResultList();

            if (!lista.isEmpty()) {
                id = lista.get(0).getIdJuego();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sesion.close();
        }
        return id;
   }
   
   /**
    * metodo para obtener el id del cliente de la tabla
    * @param nombre_cliente se le pasa el nombre del cliente
    * @return variable int
    */
   public int obtenerIdCliente(String nombre_cliente){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        int id = -1;
          try {
                  String sql = "from Clientes where nombreCliente = :nombreCliente";
                  Query q = session.createQuery(sql);
                  q.setParameter("nombreCliente", nombre_cliente);
                  List<Clientes> lista = q.getResultList();
                  for (Clientes clientes : lista) {
                          if (clientes != null) {
                                  id = clientes.getIdCliente();
                          }
                  }
          } catch (ObjectNotFoundException e) {
                  // TODO: handle exception
                  e.printStackTrace();
          }
      return id;
   }
    
    /**
     * Este metodo elimina un registro de la tabla ventas tomando como referencia el nombre del juego y del cliente
     * que se obtiene al marcar una fila de la tabla de la aplicacion.
     * @param fila recoge la fila de la tabla correspondiente a eliminar en un tipo String
     */
    public void eliminarVenta(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        String sql="delete Ventas where idVenta = :idVenta";
        Query q = sesion.createQuery(sql);
        q.setParameter("idVenta", id);
        q.executeUpdate();
        tx.commit();
        sesion.close();
    }
}
