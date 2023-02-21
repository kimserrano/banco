/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.RetirosSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetiroSinCuentaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para el manejo de acciones/responsabilidades de los retiros sin cuenta
 *
 * @author Kim y Elmer
 */
public class RetirosSinCuentaDAO implements IRetiroSinCuentaDAO {

    /**
     * Atributo de IConexionBD que genera la conexión
     */
    private final IConexionBD GENERADOR_CONEXIONES;
    /**
     * Atributo final para las excepciones del logger
     */
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

    /**
     * Constructor que recibe un generador de conexiones para tener conexión con
     * la base de datos
     *
     * @param GENERADOR_CONEXIONES Atributo de IConexionBD que genera la
     * conexión
     */
    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Este metodo crea un retiro utilizando el idCuenta de la cuenta donde se
     * restará el monto una vez sea retirado
     *
     * @param idCuenta idCuenta de cuentasClientesDAO
     * @param monto Monto a retirar
     * @return Regresa el id del retiro que se creó, 0 si este falló
     * @throws PersistenciaException Excepción que se lanza si algo mal sucede
     * al realizar el retiro.
     */
    @Override
    public int crearRetiro(int idCuenta, float monto) throws PersistenciaException {
        String sqlLastKey = "select last_insert_id()";
        int clave=this.clave();
        String codigoSQL = "call crearRetiro(" + idCuenta + "," + monto + ","+ clave +")";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            PreparedStatement comando2 = conexion.prepareStatement(sqlLastKey);
            comando.execute();
            ResultSet ultimaKey = comando2.executeQuery();

            if (ultimaKey.next()) {
            //    System.out.println("ENTRA AL IFFFF");
                int posicionLlavePrimaria = 1;
                int id = ultimaKey.getInt(posicionLlavePrimaria);
                System.out.println(id);
                conexion.close();

                return id;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");
        }

        return 0;
    }

    /**
     * Metodo que realiza la acción de retirar dinero sin tarjeta mediante un
     * folio y una clave, este retiro debe tener máximo 10 mins. de antigüedad
     *
     * @param clave Clave del retiro dada al momento de crearlo
     * @param folio Folio del retiro al momento de crearlo
     * @throws PersistenciaException Excepción que se lanza si algo sale mal al
     * momento de crear el retiro
     */
    @Override
    public void retirar(int clave, int folio) throws PersistenciaException {
        String codigoSQL = "call retiro(" + clave + "," + folio + ")";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.execute();
            conexion.close();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");

        }

    }

    /**
     * Metodo que consulta los datos de un retiroSinCuenta mediante su id
     *
     * @param idRetiro id del RetiroSinCuenta a consultar
     * @return Regresa el objeto de RetiroSinCuenta con sus datos si sale bien,
     * null en caso contrario
     */
    @Override
    public RetirosSinCuenta consultar(Integer idRetiro) {
        String codigoSQL = "select idRetirosSinCuenta, idCuentaCliente, fechaHora, \n" +
"cast(aes_decrypt(clave, 'yorx') as char), folio, estado, monto from retirossincuenta where idRetirosSinCuenta=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idRetiro);
            ResultSet resultado = comando.executeQuery();

            RetirosSinCuenta retiro = null;

            if (resultado.next()) {
                int idCuenta = resultado.getInt("idCuentaCliente");
                Date fecha = resultado.getDate("fechaHora");
                int clave = resultado.getInt("cast(aes_decrypt(clave, 'yorx') as char)");
                int folio = resultado.getInt("folio");
                String estado = resultado.getString("estado");
                float monto = resultado.getFloat("monto");
                retiro = new RetirosSinCuenta(idRetiro, idCuenta, fecha, clave, folio, estado, monto);

            }
            conexion.close();
            return retiro;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Metodo que autogenera una clave para los retiros
     * @return 
     */
    @Override
    public int clave() {
        Random random= new Random();
        int min=10000000;
        int max=99999999;
        int rand=random.nextInt(min, max);
        return rand;
    }

}
