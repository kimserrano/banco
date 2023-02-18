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
public interface ICuentasClientesDAO {

    CuentasClientesRecord insetarCuenta(CuentasClientesRecord cuenta, Cliente cliente) throws PersistenciaException;

 //   List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;

    CuentasClientesRecord anadirSaldo(Float saldo, int idCuentasClientes) throws PersistenciaException;
    
    CuentasClientesRecord consultar(String nombre, int idCliente) throws PersistenciaException;
    
    CuentasClientesRecord consultar(int idCuentaCliente);
    
    ArrayList<CuentasClientesRecord> cargarCuentas(int idCliente) throws PersistenciaException;
    
    IConexionBD getGENERADOR_CONEXIONES();
}
