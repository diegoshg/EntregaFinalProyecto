/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.Juegos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *Esta clase contiene los metodos para buscar los clientes que han comprado un juego en la base de datos
 * @author Diego Sanchez Gandara
 */
public class ControladorBuscarCliente {
    
    /**
     * Este metodo comprueba que el juego existe en la base de datos antes de buscar
     * @param nombre_juego este argumento almacena los datos de tipo string
     * @return objeto true o false
     */
    public static boolean comprobarJuegoExiste(String nombre_juego) {
    boolean existe = false;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      Transaction transacion = session.beginTransaction();
      String hqlJuego = "FROM Juegos WHERE nombre_juego = :nombre_juego";
      Query<Juegos> queryJuego = session.createQuery(hqlJuego, Juegos.class).setParameter("nombre_juego", nombre_juego);
       List<Juegos> listaJuegos = queryJuego.list();
        Juegos j = null;
        for (Juegos listaJ : listaJuegos) {
            j = listaJ;
            if (j.getNombreJuego().equals(nombre_juego)) {
                existe = true;
            }
        }
        
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return existe;
  }
    
    
    
    /**
     * este metodo obtiene el id del cliente por su nombre
     * @param nombre_cliente este argumento es un tipo String que almacena el nombre del cliente
     * @return el nombre del cliente
     */
     public static Clientes obtenerClienteporNombre(String nombre_cliente){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
          try {
                transaction = session.beginTransaction();
                String hqlCliente = "FROM Clientes WHERE nombreCliente = :nombre_cliente";
                Clientes queryCliente = session.createQuery(hqlCliente, Clientes.class).setParameter("nombre_cliente", nombre_cliente).getSingleResult();
                return queryCliente;
          } catch (Exception e) {
          }
          return null;
  }
    
    /**
     * este metodo recoge el nombre de un juego en la base de datos y devuelve el id y nombre del cliente que han comprado ese juego.
     * @param nombre_juego almacena el nombre del juego en un tipo String
     * @return un modelo para la tabla 
     */
    public DefaultTableModel mostrarClientes(String nombre_juego) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    DefaultTableModel model = new DefaultTableModel();
    try {
        transaction = session.beginTransaction();
        Query<Object[]> query = session.createQuery(
                "SELECT c.idCliente, c.nombreCliente " +
                        "FROM Juegos j " +
                        "JOIN Ventas v ON j.idJuego = v.juegos.idJuego " +
                        "JOIN Clientes c ON v.clientes.idCliente = c.idCliente " +
                        "WHERE j.nombreJuego = :nombre_juego", Object[].class);
        
        query.setParameter("nombre_juego", nombre_juego);
        List<Object[]> resultado = query.list();
        model.addColumn("ID Cliente");
        model.addColumn("Nombre Cliente");
        for (Object[] row : resultado) {
            //las añadimos como filas
            Integer idClienteInt = (Integer) row[0];
            String idCliente = String.valueOf(idClienteInt);
            String nombreCliente = (String) row[1];
            model.addRow(new Object[]{idCliente, nombreCliente});
        }

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close(); 
    }

    return model;
}
}
