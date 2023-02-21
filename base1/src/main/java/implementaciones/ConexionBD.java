/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que genera una conexión a la base de datos
 *
 * @author Elmer y Kim
 */
public class ConexionBD implements IConexionBD {

    /**
     * String que contiene la cadena de la conexión
     */
    private String CADENA_CONEXION;
    /**
     * String que contiene al usuario de la base
     */
    private String USUARIO;
    /**
     * String que contiene la contraseña de la base
     */
    private String PASSWORD;

    /**
     * Constructor que setea los atributos
     *
     * @param cadena_conexion String que contiene la cadena de la conexión
     * @param usuario String que contiene al usuario de la base
     * @param password String que contiene la contraseña de la base
     */
    public ConexionBD(String cadena_conexion, String usuario, String password) {
        this.CADENA_CONEXION = cadena_conexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }

    /**
     * Metodo que crea y regresa una conexión con la base de datos
     *
     * @return Regresa un objeto Connection que se conecta a la base de datos
     * @throws SQLException SQLException es tirada si algo sale mal
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }

}
