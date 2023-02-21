/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Interfaz que declar los métodos para trabajar con los clientes del banco
 *
 * @author Elmer y Kim
 */
public interface IClientesDAO {

    /**
     * Declaración del método consultar consulta un cliente a partir de su id
     *
     * @param idCliente del cliente que se quiere consultar
     * @return el cliente consultado
     */
    Cliente consultar(Integer idCliente);

    /**
     * Declaración del método consultar consulta un cliente a partir de su
     * usuario y clave
     *
     * @param usuario username del cliente que se desea consultar
     * @param clave del cliente que se desea consultar
     * @return el cliente cuyas credenciales de los párametros coincida
     * @throws PersistenciaException si las credenciales no coinciden
     */
    Cliente consultar(String usuario, String clave) throws PersistenciaException;

    /**
     * Declaración del método insertar un cliente con una cuenta para loggearse
     *
     * @param cliente el cliente que se desea agregar
     * @param usuario el usuario que se pondrá el cliente
     * @param clave la clave que eligirá el cliente para iniciar sesión en el
     * futuro
     * @return el cliente insertado
     * @throws PersistenciaException si hubo un error al insertar el cliente o
     * la cuenta
     */
    Cliente insertar(Cliente cliente, String usuario, String clave) throws PersistenciaException;

    /**
     * Declaración del método eliminar que elimina un cliente
     *
     * @param idCliente id del cliente que se desea eliminar
     * @return e cliente que se elimino
     */
    Cliente eliminar(Integer idCliente);

    /**
     * Declaración del método actualizar nombre que actualiza el nombre del
     * usuario
     *
     * @param idCliente cliente que quiere editarse
     * @param nombre por el que se desea cabiar
     */
    void actualizarNombre(Integer idCliente, String nombre);

    /**
     * actualiza el apellido materno del cliente
     *
     * @param idCliente cliente que se edita
     * @param apellidoMat nuevo apellido materno
     */
    void actualizarApellidoMat(Integer idCliente, String apellidoMat);

    /**
     * actualiza el apellido paterno del cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param apellidoPat nuevo apellido paterno
     */
    void actualizarApellidoPat(Integer idCliente, String apellidoPat);

    /**
     * actualiza la calle de la dirección de un cliente
     *
     * @param idCliente cliente a actualizar
     * @param calle nueva calle
     */
    void actualizarCalle(Integer idCliente, String calle);

    /**
     * actualiza el número de domicilio de un cliente
     *
     * @param idCliente cliente a editar
     * @param numDomicilio nuevo número
     */
    void actualizarNumDomicilio(Integer idCliente, int numDomicilio);

    /**
     * actualiza el código postal de la dirección del cliente
     *
     * @param idCliente cliente a editar
     * @param CP nuevo código postal
     */
    void actualizarCP(Integer idCliente, int CP);

    /**
     * genera una conexión con la base de datos
     *
     * @return conexón con la base de datos
     */
    IConexionBD getGENERADOR_CONEXIONES();
}
