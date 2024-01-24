/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;
import model.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *Esta clase contiene los metodos para crear un usuario 
 * @author Diego Sanchez Gandara
 */
public class ControladorCrearCuenta {
    
    /**
     * este metodo verifica las credenciales del usuario en la base de datos para saber si existen.
     * @param username recoge el nombre de usuario en un tipo String
     * @param email recoge el email de usuario en un tipo String
     * @param contrasena recoge la contraseña del usuario en un tipo String
     * @return true o false
     */
    public boolean verificarCredenciales(String username, String email, String contrasena) {
        boolean credencialesValidas = false;
        //iniciamos la sesion y la transacion
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
           
            String hql = "FROM Usuarios WHERE username = :username AND email = :email AND contrasena = :contrasena";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            
            query.setParameter("username", username);
            query.setParameter("email", email);
            query.setParameter("contrasena", contrasena);

            
            Usuarios usuario = query.uniqueResult();

            
            if (usuario != null) {
                credencialesValidas = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            tx.commit();
            sesion.close();
        }
        
        return credencialesValidas;
    }
    
    /**
     * este metodo comprueba que el email no exista ya en la base de datos para que no se repita
     * @param email recoge el email del usuario en un tipo String
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
     * este metodo introduce el usuario en la base de datos, despues de encriptar la contraseña.
     * @param username recoge el username en un tipo String
     * @param password recoge la contraseña encriptada en un tipo String
     * @param email recoge el mail en un tipo String
     */
    public void introducirUsuario(String username, String password, String email) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Usuarios user = new Usuarios();
            user.setUsername(username);
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setContrasena(hashedPassword);
            user.setEmail(email);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
