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
    
    void realizarTransferencia(int id1, int id2, float monto) throws PersistenciaException;
    
}
