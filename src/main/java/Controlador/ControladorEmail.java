/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import model.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *Esta clase envia un email a un correo de la base de datos para recuperar la contraseña
 * generando una aleatoria y modificando la base de datos para cambiar la antigua contraseña
 * por la nueva
 * @author Diego Sanchez Gandara
 */
public class ControladorEmail {
    
    /**
     * este metodo verifica que el email exista en la base de datos antes de mandar el correo.
     * @param email recoge el email en un tipo String
     * @return true o false
     */
   public boolean verificarEmail(String email) {
        boolean emailExiste = false;
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

        try {
            
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = sesion.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            
            Usuarios usuario = query.uniqueResult();

            
            if (usuario != null) {
                emailExiste = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            tx.commit();
            sesion.close();
        }

        return emailExiste;
    }
   
   /**
    * este metodo genera una contraseña nueva aleatoria a partir de la lista de caracteres que 
    * se le pasa.
    * @param longitudMin recoge la longuitud minima de la nueva contraseña en un tipo int
    * @param longitudMax recoge la longuitud maxima de la nueva contraseña en un tipo int
    * @return la contraseña generada
    */
   public String generarContrasena(int longitudMin, int longitudMax){
      
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        
        longitudMin = Math.max(1, longitudMin);
        int longitud = longitudMin + new SecureRandom().nextInt(longitudMax - longitudMin + 1);

        StringBuilder contraseñaGenerada = new StringBuilder();
        SecureRandom aleatorio = new SecureRandom();
        
        for (int i = 0; i < longitud; i++) {
            int indice = aleatorio.nextInt(CARACTERES.length());
            contraseñaGenerada.append(CARACTERES.charAt(indice));
        }
        
        return contraseñaGenerada.toString();
   }
   
   /**
    * este metodo actualiza la contraseña en la base de datos, primero busca el email, 
    * despues encripta la  nueva contraseña 
    * y luego la guarda.
    * @param email recoge el email en un tipo String
    * @param contrasena recoge la nueva contraseña en un tipo String
    */
   public void actualizarContrasena(String email, String contrasena){
       Session session = HibernateUtil.getSessionFactory().openSession();
      
        Transaction transaction = null;

        try {
            
            transaction = session.beginTransaction();

            
            String hql = "FROM Usuarios WHERE email = :email";
            Query<Usuarios> query = session.createQuery(hql, Usuarios.class);
            query.setParameter("email", email);

            
            Usuarios usuario = query.uniqueResult();
            if (usuario != null) {
               
                String hashedPassword = BCrypt.hashpw(contrasena, BCrypt.gensalt());
                usuario.setContrasena(hashedPassword);

                
                session.update(usuario);

               
                transaction.commit();
            } else {
                System.out.println("Usuario no encontrado.");
            }
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
