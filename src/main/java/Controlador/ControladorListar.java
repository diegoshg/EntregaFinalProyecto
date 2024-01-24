/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
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
    public DefaultTableModel recogerDatos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Object[]> query = session.createQuery("SELECT j.ISBN, j.nombreJuego, j.plataforma, j.precio, c.nombreCliente " +
                        "FROM Juegos j, Clientes c " +
                        "JOIN Ventas v ON j.idJuego = v.juegos.idJuego " +
                        "JOIN Clientes c ON v.clientes.idCliente = c.idCliente ", Object[].class);
            
            List<Object[]> resultado = query.list();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ISBN");
            model.addColumn("Juego");
            model.addColumn("Plataforma");
            model.addColumn("Precio");
            model.addColumn("Cliente");
           
            Set<String> filasUnicas = new HashSet<>();
          for (Object[] row : resultado) {
              String ISBN = (String) row[0];
                String nombreJuego = (String) row[1];
                String plataforma = (String) row[2];
                Double precio = (Double) row[3];
                String nombreCliente = (String) row[4];

                String filaUnica = ISBN + nombreJuego + plataforma + precio + nombreCliente;

                if (!filasUnicas.contains(filaUnica)) {
                    model.addRow(new Object[]{ISBN, nombreJuego, plataforma, precio, nombreCliente});
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
    
    /**
     * Este metodo elimina un registro de la tabla ventas tomando como referencia el nombre del juego y del cliente
     * que se obtiene al marcar una fila de la tabla de la aplicacion.
     * @param fila recoge la fila de la tabla correspondiente a eliminar en un tipo String
     */
    public void eliminarVenta(String fila){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        String sql="delete Ventas v " +
                        "JOIN Ventas v, Juegos j, Clientes c ON j.idJuego = v.juegos.idJuego and c.idCliente = v.clientes..idClientes";
        Query qd=sesion.createQuery(sql);
        int fafecd=qd.executeUpdate();
        tx.commit();
    }
}
