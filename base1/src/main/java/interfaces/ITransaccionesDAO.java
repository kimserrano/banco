/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Transacciones;
import excepciones.PersistenciaException;
import java.sql.Connection;

/**
 * Interfaz que declara el método de realizar transferencia
 *
 * @author Elmer y Kim
 */
public interface ITransaccionesDAO {

    /**
     * Declaración de método realizarTransferencia(int id1, int numCuenta, float
     * monto) cuya funfionalidad es crear una transferencia de una cuenta
     * bancaria a otra
     *
     * @param id1 pertenece al id de la cuenta que esta haciendo la transfrencia
     * @param numCuenta pertenece a la cuenta bancaria a la que llega el dinero
     * de la transferencia
     * @param monto la cantidad de dinero que se manda en la transferencia
     * @throws PersistenciaException Lanza esta excepción en caso de que la
     * transferencia no se realiza
     */
    void realizarTransferencia(int id1, int numCuenta, float monto) throws PersistenciaException;

    /**
     * Declacaración de método getGENERADOR_CONEXIONES() que es usado para
     * conectarte a la base
     *
     * @return regresa la conexión a la base de datos
     */
    IConexionBD getGENERADOR_CONEXIONES();

}
