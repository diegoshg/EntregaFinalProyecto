/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import model.Clientes;
import model.Juegos;
import model.Usuarios;
import model.Ventas;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * Esta clase controla todo lo relacionado con introducir juegos, clientes y ventas en la base de datos.
 * @author Diego Sanchez Gandara
 */
public class ControladorIncluirVenta {

    /**
     * este metodo comprueba que el nombre del juego, la plataforma, el precio y el cliente
     * no hayan sido ya introducidos iguales en la base de datos para evitar que se dupliquen
     * ventas con distinto ISBN
     * @param nombre_juego recoge el nombre del juego en un tipo String
     * @param plataforma recoge la plataforma en un tipo String
     * @param precio recoge el precio en un tipo double
     * @param nombre_cliente recoge el nombre del cliente en un tipo String
     * @return true o false
     */
  public boolean comprobarRepetidos(String nombre_juego, String plataforma, double precio, String nombre_cliente) {
    boolean repetido = false;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session sesion = sessionFactory.openSession();
    Transaction tx = sesion.beginTransaction();

    try {
      
      String hqlUsuario = "FROM Clientes WHERE nombre_cliente = :nombre_cliente";
      Query<Clientes> queryUsuario = sesion.createQuery(hqlUsuario, Clientes.class);
      queryUsuario.setParameter("nombre_cliente", nombre_cliente);

      Clientes clienteExistente = queryUsuario.uniqueResult();
      
      if (clienteExistente != null) {
      
        String hqlJuegos = "FROM Juegos WHERE nombre_juego = :nombre_juego AND plataforma = :plataforma AND precio = :precio";
        Query<Juegos> queryJuegos = sesion.createQuery(hqlJuegos, Juegos.class);
        queryJuegos.setParameter("nombre_juego", nombre_juego);
        queryJuegos.setParameter("plataforma", plataforma);
        queryJuegos.setParameter("precio", precio);

        Juegos juegoExistente = queryJuegos.uniqueResult();

        
        if (juegoExistente != null) {
          repetido = true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
        
      tx.commit();
      sesion.close();
    }
    
    return repetido;
  }

  /**
   * este metodo introduce los datos del juego en la base de datos
   * @param isbn recoge el isbn en un tipo String
   * @param nombre_juego recoge el nombre del juego en un tipo String
   * @param plataforma recoge la plataforma en un tipo String
   * @param precio recoge el precio en un tipo double
   */
  public void introducirJuego(String isbn, String nombre_juego, String plataforma, double precio) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      Juegos j = new Juegos();
      j.setISBN(isbn);
      j.setNombreJuego(nombre_juego);
      j.setPlataforma(plataforma);
      j.setPrecio(precio);
      session.save(j);
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  
  /**
   * este metodo introduce los datos de los clientes en la base de datos
   * @param nombre_cliente recoge el nombre del cliente en un tipo String
   */
  public void introducirCliente(String nombre_cliente) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      Clientes c = new Clientes();
      c.setNombreCliente(nombre_cliente);
      session.save(c);
      transaction.commit();
    } catch (Exception e) {
      e.printStackTrace(); 
    } finally { 
      session.close();
    }
  }

  
  /**
   * este metodo obtiene el id del cliente a traves de su nombre.
   * @param nombre_juego recoge el nombre del cliente en un tipo String
   * @return un tipo Juegos
   */
   public int obtenerIdCliente(String nombreCliente) {
      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
      Session session = sessionFactory.openSession();
      int id = -1;
        try {
                String sql = "from Clientes where nombreCliente = :nombreCliente";
                Query q = session.createQuery(sql);
                q.setParameter("nombreCliente", nombreCliente);
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
   * este metodo comprueba que el ISBN introducido no exista ya en la base de datos para
   * evitar que se duplique un juego con mismo isbn.
   * @param iSBN recoge el isbn del juego en un tipo String
   * @return true o false
   */
  public boolean comprobarISBN(String iSBN){
     boolean existe = false;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session sesion = sessionFactory.openSession();
    Transaction tx = sesion.beginTransaction();
    try {
      String hqlJuego = "FROM Juegos WHERE ISBN = :ISBN";
      Query<Juegos> queryJuego= sesion.createQuery(hqlJuego, Juegos.class).setParameter("ISBN", iSBN);
      List<Juegos> listaJuego = queryJuego.list();
        for (Juegos listaJ : listaJuego) {
            if (listaJ.getISBN().equals(iSBN)) {
                existe = true;
            }
        }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tx.commit();
      sesion.close();
    }

    return existe;
  }
  
  /**
   * Este metodo comprueba si el cliente introducido existe en la base de datos.
   * @param nombreCliente recoge el nombre del cliente en un tipo String. 
   * @return true o false
   */
  public boolean comprobarCliente(String nombreCliente){
     boolean existe = false;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session sesion = sessionFactory.openSession();
    Transaction tx = sesion.beginTransaction();
    try {
      String hqlCliente = "FROM Clientes where nombreCliente = :nombreCliente";
      Query<Clientes> queryCliente= sesion.createQuery(hqlCliente, Clientes.class).setParameter("nombreCliente", nombreCliente);
      List<Clientes> listaCliente = queryCliente.list();
        for (Clientes listaC : listaCliente) {
            if (listaC.getNombreCliente().equals(nombreCliente)) {
                existe = true;
            }
        }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tx.commit();
      sesion.close();
    }

    return existe;
  }

  /**
   * este metodo introduce los datos de una venta. Recoge el id del juego y del cliente a traves 
   * de sus nombres para guardarlos en su tabla. Luego guarda el precio y la fecha en la que se realiza.
   * @param nombreJuego recoge el nombre del juego en un tipo String
   * @param nombreCliente recoge el nombre del cliente en un tipo String
   * @param precioVenta recoge el precio de la venta en un tipo double
   * @param fechaVenta recoge la fecha de la venta que es la actual del dia en la que se introduce en un tipo Datetime
   */
  public static void registrarVenta(String nombreJuego, String nombreCliente, double precioVenta, Date fechaVenta) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      Query<Juegos> consultaJuegos = session.createQuery("FROM Juegos j WHERE j.nombreJuego = :nombreJuego", Juegos.class);
      consultaJuegos.setParameter("nombreJuego", nombreJuego);
      List<Juegos> listaJuegos = consultaJuegos.list();
      Juegos j = null;
        for (Juegos listaJ : listaJuegos) {
            j = listaJ;
        }
      Query<Clientes> consultaClientes = session.createQuery("FROM Clientes c WHERE c.nombreCliente = :nombreCliente", Clientes.class);
      consultaClientes.setParameter("nombreCliente", nombreCliente);
      List<Clientes> listaClientes = consultaClientes.list();
      Clientes c = null;
        for (Clientes listaC : listaClientes) {
            c = listaC;
        }
                 
      Ventas venta = new Ventas();
      venta.setJuegos(j);
      venta.setClientes(c);
      venta.setPrecioVenta(precioVenta);
      venta.setFechaVenta(Date.valueOf(LocalDate.now()));
      session.save(venta);
      transaction.commit();
    } catch (Exception e) { 
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
  
    
    /**
     * Este metodo sirve para introducir una venta nueva en caso de que ya exista el cliente.Primero se obtiene el id de
     * ese cliente y se guarda para evitar que se dupliquen datos.
     * @param nombreJuego recoge el nombre del juego en un tipo String
     * @param idCliente recoge el id del cliente en un tipo int
     * @param precioVenta recoge el precio de la venta
     * @param fechaVenta recoge la fecha de la venta
     */
    public static void registrarVenta2(String nombreJuego, int idCliente, double precioVenta, Date fechaVenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
         try {
              Clientes cliente = session.get(Clientes.class, idCliente);
                if (cliente != null) {
                   Query<Juegos> consultaJuegos = session.createQuery("FROM Juegos j WHERE j.nombreJuego = :nombreJuego", Juegos.class);
                   consultaJuegos.setParameter("nombreJuego", nombreJuego);
                   List<Juegos> listaJuegos = consultaJuegos.list();
                   Juegos j = null;
                     for (Juegos listaJ : listaJuegos) {
                         j = listaJ;
                     }

                   Ventas v = new Ventas();
                   v.setJuegos(j);
                   v.setClientes(cliente);
                   v.setPrecioVenta(precioVenta);
                   v.setFechaVenta(Date.valueOf(LocalDate.now()));
                   session.save(v);
                   transaction.commit();
                  }
         } catch (HibernateException e) {
             e.printStackTrace();
         }
    }
}
