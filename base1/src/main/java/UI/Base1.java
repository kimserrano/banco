/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package UI;

import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kim y Elmer
 */
public class Base1 {

    public static void main(String[] args) {

         IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost:3306/banco", "root", "megustaelch0c0late");
//        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost:3400/banco", "root", "twentyonepilots123");
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);

        new FrmLogin(clientesDAO).setVisible(true);
    }
}
