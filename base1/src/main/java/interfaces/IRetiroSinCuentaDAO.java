/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetirosSinCuenta;
import excepciones.PersistenciaException;

/**
 * Interfaz que declara los métodos para trabajar con los retiros sin cuenta
 * bancaria
 *
 * @author Elmer y Kim
 */
public interface IRetiroSinCuentaDAO {

    /**
     * Declaración del método crear retiro que se encarga de crear un retiro sin
     * cuenta una vez el usuario este loggeado con una de sus cuntas bancarias
     *
     * @param id pertenece al id de la cuenta bancaria del cliente que crea el
     * retiro
     * @param monto es la cantidad de dinero que se desea retirar
     * @return regresa un entero que es la llave primaria del retiro creado
     * @throws PersistenciaException lanza esta excepción si el retiro no es
     * generado
     */
    int crearRetiro(int id, float monto) throws PersistenciaException;

    /**
     * Declaración del método retirar que se encarga de retirar el dinero
     * asignado por el retiro sin cuenta, este método va dirigido a los clientes
     * que no están registrados
     *
     * @param clave es la clave que se generó al momento de crear el retiro
     * @param folio es el folio que se generó al momento de crear el retiro y
     * tanto el folio como la clave son necesarios para retirar el dinero
     * @throws PersistenciaException lanza una excepción en caso de que el
     * dinero no pueda ser retirado
     */
    void retirar(int clave, int folio) throws PersistenciaException;

    /**
     * Declaración del método consultar que sirve para consultar el retiro
     * generado con el fin de mostrar el traerlo y asi poder mostrar el folio y
     * la clave al cliente para que este pueda retirarlo
     *
     * @param idRetiro id del retiro generado
     * @return regrasa el retiro sin cuenta que fue generado o null en caso
     * contrario
     */
    RetirosSinCuenta consultar(Integer idRetiro);

}
