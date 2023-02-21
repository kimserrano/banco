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
 * Clase para las transferencias bancarias
 *
 * @author Elmer y Kim
 */
public class TransaccionesDAO implements ITransaccionesDAO {

    /**
     * Atributo de IConexionBD que genera la conexión
     */
    private final IConexionBD GENERADOR_CONEXIONES;
    /**
     * Atributo final para las excepciones del logger
     */
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

    /**
     * Constructor que setea el generador de conexiones con el atributo que
     * recibe
     *
     * @param GENERADOR_CONEXIONES Atributo de IConexionBD que genera la
     * conexión
     */
    public TransaccionesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Realiza una transferencia desde la cuenta id1 al numero de cuenta
     * numCuenta con el monto monto
     *
     * @param id1 id de cuentasclientes que va a mandar el monto
     * @param numCuenta num de cuenta que la tarjeta que va a recibir el monto
     * @param monto monto a transferir
     * @throws PersistenciaException Excepción que se lanza si algo mal sucede
     * al realizar la transferencia.
     */
    @Override
    public void realizarTransferencia(int id1, int numCuenta, float monto) throws PersistenciaException {
        String codigoSQL = "call transferir(" + id1 + "," + numCuenta + "," + monto + ",'transferencia')";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.execute();

            //Este metodo deber[a regresar un objeto transaccion, y el id se sacara cuando el usuario ingrese tanto su tarjeta como el numero de cuenta
            //de la tarjeta a la que pasar dinero
            //  Transacciones trans=new Transacciones();
            conexion.close();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible realizar la transaccion");

        }
    }

    /**
     * Getter para nuestra conexión con la base de datos
     *
     * @return Conexión con la base de datos de tipo IConexionBD
     */
    @Override
    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

}
