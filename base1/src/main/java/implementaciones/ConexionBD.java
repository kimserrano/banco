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
 *
 * @author lv1013
 */
public class ConexionBD implements IConexionBD{
    
    private String CADENA_CONEXION;
    private String USUARIO;
    private String PASSWORD;

    public ConexionBD(String cadena_conexion, String usuario, String password) {
        this.CADENA_CONEXION = cadena_conexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }
    
    @Override
    public Connection crearConexion() throws SQLException {
      Connection conexion =  DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
      return conexion;
    }
    
}
