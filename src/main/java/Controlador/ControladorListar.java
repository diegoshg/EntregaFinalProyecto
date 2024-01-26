/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Juegos;
import model.Ventas;
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
            JButton boton = new JButton("Borrar");
            DefaultTableModel model = new DefaultTableModel();
            isCellEditable(tabla);
            model.addColumn("ISBN");
            model.addColumn("Juego");
            model.addColumn("Plataforma");
            model.addColumn("Precio");
            model.addColumn("Cliente");
            model.addColumn("");
            
            
           
            Set<String> filasUnicas = new HashSet<>();
          for (Object[] row : resultado) {
              String ISBN = (String) row[0];
                String nombreJuego = (String) row[1];
                String plataforma = (String) row[2];
                Double precio = (Double) row[3];
                String nombreCliente = (String) row[4];
                

                String filaUnica = ISBN + nombreJuego + plataforma + precio + nombreCliente;

                if (!filasUnicas.contains(filaUnica)) {
                    model.addRow(new Object[]{ISBN, nombreJuego, plataforma, precio, nombreCliente, boton});
                    filasUnicas.add(filaUnica);
    
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
    
    public boolean isCellEditable(JTable table){
        return false;
    }
    
   public static Ventas obtenerVenta(int idVenta){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
      try {
            transaction = session.beginTransaction();
            String hqlJuego = "Select from Ventas where idVenta = :idventa";
            Ventas queryJuego = session.createQuery(hqlJuego, Ventas.class).setParameter("idVenta", idVenta).getSingleResult();
            return queryJuego;
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
  }
    
    /**
     * Este metodo elimina un registro de la tabla ventas tomando como referencia el nombre del juego y del cliente
     * que se obtiene al marcar una fila de la tabla de la aplicacion.
     * @param fila recoge la fila de la tabla correspondiente a eliminar en un tipo String
     */
    public void eliminarVenta(Ventas v){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
        Session sesion = sessionFactory.openSession();
        sesion.beginTransaction();
        String sql="from Ventas where idVenta = :idVenta";
        Ventas venta = sesion.createQuery(sql,Ventas.class).setParameter("idVenta", v.getIdVenta()).uniqueResult();
        sesion.delete(venta);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
