/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author kim
 */ 
public interface IClientesDAO {
    Cliente consultar(Integer idCliente);
    Cliente insertar(Cliente cliente, String usuario, String clave) throws  PersistenciaException ;
    Cliente eliminar(Integer idCliente);
    List <Cliente> consultar (ConfiguracionPaginado configPaginado) throws  PersistenciaException;
}
