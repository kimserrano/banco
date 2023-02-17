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

    CuentasClientesRecord insetarCuenta(CuentasClientesRecord cuenta, Cliente cliente) throws PersistenciaException;

    List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;

    ArrayList<CuentasClientesRecord> cargarCuentas(int idCliente) throws PersistenciaException;
}
