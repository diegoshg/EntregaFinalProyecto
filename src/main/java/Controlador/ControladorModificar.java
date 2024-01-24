/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.mysql.cj.xdevapi.Client;
import java.util.List;
import model.Clientes;
import model.Juegos;
import model.Ventas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *Esta clase contiene los metodos para modificar el precio de un juego en la tabla juegos, pasandole el nombre del juego
 * y su isbn para modificar un juego especifico.
 * @author Diego Sanchez Gandara
 */
public class ControladorModificar {
    
   
    /**
     * Este metodo recibe el nombre del juego y su isbn y modifica su precio en la tabla.
     * Se pide el isbn para modificar solo uno especifico ya que puede haber juegos con el mismo nombre.
     * @param ISBN recoge el isbn en un tipo String
     * @param nombre_juego recoge el nombre del juego en un tipo String
     * @param precio recoge el precio en un tipo double
     */
    public void modificarJuegos(String ISBN, String nombre_juego, double precio){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();			
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        String sql ="update Juegos set precio = :precio where nombreJuego = :nombreJuego and ISBN = :ISBN";
        Query q = sesion.createQuery(sql);
        q.setParameter("ISBN", ISBN);
        q.setParameter("nombreJuego", nombre_juego);
        q.setParameter("precio", precio);
        q.executeUpdate();
        tx.commit();
    }
    
    /**
     * Este metodo comprueba que el juego existe en la base de datos para poder modificarlo.
     * @param nombre_juego recoge el nombre del juego en un tipo String
     * @return true o false
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
     
}
