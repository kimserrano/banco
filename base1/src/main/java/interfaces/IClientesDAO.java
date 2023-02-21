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
 *
 * @author kim
 */
public interface IClientesDAO {

    Cliente consultar(Integer idCliente);

    Cliente consultar(String usuario, String clave) throws PersistenciaException;

    Cliente insertar(Cliente cliente, String usuario, String clave) throws PersistenciaException;

    Cliente eliminar(Integer idCliente);

    void actualizarNombre(Integer idCliente, String nombre);

    void actualizarApellidoMat(Integer idCliente, String apellidoMat);

    void actualizarApellidoPat(Integer idCliente, String apellidoPat);

    void actualizarCalle(Integer idCliente, String calle);

    void actualizarNumDomicilio(Integer idCliente, int numDomicilio);

    void actualizarCP(Integer idCliente, int CP);

    List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;

    IConexionBD getGENERADOR_CONEXIONES();
}
