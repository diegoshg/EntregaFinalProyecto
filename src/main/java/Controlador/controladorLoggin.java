/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import model.Usuarios;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *Esta clase contiene los metodos para realizar el loggin y comprobar credenciales.
 * @author Diego Sanchez Gandara
 */
public class controladorLoggin {
    
    /**
     * Este metodo sirve para comprobar que el email introducido existe en la base de datos.
     * @param email recoge el email en un tipo String
     * @return true o false
     */
    public boolean comprobarMail(String email){
    boolean existe = false;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session sesion = sessionFactory.openSession();
    Transaction tx = sesion.beginTransaction();
    try {
      String hqlUsuario = "FROM Usuarios WHERE email = :email";
      Query<Usuarios> queryUsuario= sesion.createQuery(hqlUsuario, Usuarios.class).setParameter("email", email);
      List<Usuarios> listaUsuario = queryUsuario.list();
        for (Usuarios listaU : listaUsuario) {
            if (listaU.getEmail().equals(email)) {
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
     * Este metodo obtiene la contraseña del usuario buscandola a partir de su email
     * para comprobarla en el loggin.
     * @param email recoge el email en un tipo String
     * @return un tipo String
     */
    public String obtenerContrasenaDeUsuario(String email) {
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        try {
           
            String hql = "SELECT u.contrasena FROM Usuarios u WHERE u.email = :email";
            Query<String> query = sesion.createQuery(hql, String.class);
            query.setParameter("email", email);
           
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            
            sesion.close();
        }
    }
    
   
    
    
    /**
     * Este metodo sirve para desencriptar la contraseña obtenida y comprobar su existe en la base de datos.
     * @param contrasenaInput recoge la variable contraseña que introducimos en un tipo String
     * @param contrasenaAlmacenada recoge la contraseña almacenada en la base de datos en un tipo String
     * @return true o false
     */
    public boolean verificarContrasena(String contrasenaInput, String contrasenaAlmacenada) {
        return BCrypt.checkpw(contrasenaInput, contrasenaAlmacenada);
    }
}
