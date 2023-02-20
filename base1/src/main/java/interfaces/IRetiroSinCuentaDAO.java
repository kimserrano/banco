/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetirosSinCuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author kim
 */
public interface IRetiroSinCuentaDAO {

    int crearRetiro(int id, float monto) throws PersistenciaException;

    void retirar(int clave, int folio) throws PersistenciaException;
    
    RetirosSinCuenta consultar(Integer idRetiro);

}
