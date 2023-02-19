/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Transacciones;
import excepciones.PersistenciaException;

/**
 *
 * @author eruma
 */
public interface ITransaccionesDAO {
    // id1 es el de la cuenta actual 
    // numCuenta es l cuenta a la que se desea transferir 
    void realizarTransferencia(int id1, int numCuenta, float monto) throws PersistenciaException;

    
}
