/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Transacciones;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITransaccionesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eruma
 */
public class TransaccionesDAO implements ITransaccionesDAO{
    
          private final IConexionBD GENERADOR_CONEXIONES;
          private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

            public TransaccionesDAO(IConexionBD GENERADOR_CONEXIONES){
                this.GENERADOR_CONEXIONES=GENERADOR_CONEXIONES;
            }

            @Override
           public  void realizarTransferencia(int id1, int id2, float monto) throws PersistenciaException{
               String codigoSQL = "call transferir("+id1+","+id2+","+monto+",'transferencia')";
        try ( Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.execute();
            
            //Este metodo deber[a regresar un objeto transaccion, y el id se sacara cuando el usuario ingrese tanto su tarjeta como el numero de cuenta
            //de la tarjeta a la que pasar dinero
            
           //  Transacciones trans=new Transacciones();
            conexion.close();
         //   return cuenta;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible realizar la transaccion");

        }
           }
            
}
