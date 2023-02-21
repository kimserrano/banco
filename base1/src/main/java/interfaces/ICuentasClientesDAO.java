/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import dominio.Historiales;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Interfaz encargada de declarar todos los métodos para trabajar con las
 * cuentas bancarias de los clientes
 *
 * @author Elmer y Kim
 */
public interface ICuentasClientesDAO {

    /**
     * Declaración del método insertar cuenta que sirve para crear una cuenta
     * bancaria con el cliente que esta iniciando sesión
     *
     * @param cuenta recive una cuenta clientes para obtener los datos de esta
     * @param cliente cliente al que se le va a genrar la cuenta bancaria
     * @return la cuenta bancaria creada
     * @throws PersistenciaException si la cuenta no pudo ser creada
     */
    CuentasClientesRecord insetarCuenta(CuentasClientesRecord cuenta, Cliente cliente) throws PersistenciaException;

    /**
     * Declaración del método anadirSaldo que añade saldo a la cuenta bancaria
     * del cliente loggeado
     *
     * @param saldo el dinero que se quiere depositar a su cuenta
     * @param idCuentasClientes id de la cuenta a la que se le quiere agregar
     * ese saldo
     * @return regresa la cuenta con el saldo agregado
     * @throws PersistenciaException si hubo un error al agregar saldo a la
     * cuenta bancaria
     */
    CuentasClientesRecord anadirSaldo(Float saldo, int idCuentasClientes) throws PersistenciaException;

    /**
     * Declaración del método consultar que se encarga de consultar una cunta
     * bancaria
     *
     * @param nombre nombre de la cuenta bancaria que se desea consultar
     * @param idCliente id del cliente al que pertenece esa cuenta
     * @return regresa la cuenta del cliente consultada
     * @throws PersistenciaException si la cuenta no puede consultarse
     */
    CuentasClientesRecord consultar(String nombre, int idCliente) throws PersistenciaException;

    /**
     * Declaración del método consultar que consulta una cuenta a partir de su
     * id
     *
     * @param idCuentaCliente id de la cuenta bancaria a consultar
     * @return regresa la cuenta bancaria cuyo id es el recibido por el
     * párametro
     */
    CuentasClientesRecord consultar(int idCuentaCliente);

    /**
     * Declaración del método que carga en un arraylist las cuentas bancarias de
     * un cliente
     *
     * @param idCliente id del cliente del cual se quiere conocer las cuentas
     * bancarias que tiene
     * @return arrayList de las cuentas bancarias del un cliente
     * @throws PersistenciaException si se pueden cargar las cuentas bancarias
     * de ese cliente
     */
    ArrayList<CuentasClientesRecord> cargarCuentas(int idCliente) throws PersistenciaException;

    /**
     * Declaración del método eliminar que se encarga de eliminar una cuenta
     * bancaria
     *
     * @param idCuentasClientes de la cuenta que desea eliminarse
     * @return regresa la cuenta eliminada
     */
    CuentasClientesRecord eliminar(int idCuentasClientes);

    /**
     * Declaración del método consultar historial que muestra el historial de
     * operaciones de una cuenta especifica
     *
     * @param configPaginado la forma en la que se va a presentar el histrial,
     * las páginas y su conteo
     * @param idCuentaCliente para saber de que cuenta bancaria es el historial
     * @param order para que se pueda elegir el orden de presentación del
     * historial
     * @return regresa una lista de las operaciones hechas por una cuenta
     * bancaria especifica
     * @throws PersistenciaException si el historial no puede ser consultado
     */
    ArrayList<Historiales> consultarHistorial(ConfiguracionPaginado configPaginado, int idCuentaCliente, String order) throws PersistenciaException;

    /**
     * Declaración del método getGENERADOR_CONEXIONES para generar la conexión
     * con la base
     *
     * @return la conexión con la base
     */
    IConexionBD getGENERADOR_CONEXIONES();
}
