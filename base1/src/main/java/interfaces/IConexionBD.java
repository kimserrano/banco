/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.*;

/**
 * Interfaz que declara método para podr conectarse a la base de datos
 *
 * @author Elmer y Kim
 */
public interface IConexionBD {

    /**
     * Declaración del método crearConexion() para crear una conexión del código
     * con la base de datos mysql
     *
     * @return la conexión con la base de datos
     * @throws SQLException si algo sale mal al momento de conectar
     */
    Connection crearConexion() throws SQLException;
}
