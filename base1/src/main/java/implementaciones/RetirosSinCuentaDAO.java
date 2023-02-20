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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kim
 */
public class RetirosSinCuentaDAO implements IRetiroSinCuentaDAO {

    private final IConexionBD GENERADOR_CONEXIONES;
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public int crearRetiro(int idCuenta, float monto) throws PersistenciaException {
        String sqlLastKey ="select last_insert_id()";
        String codigoSQL = "call crearRetiro(" + idCuenta + "," + monto + ")";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            PreparedStatement comando2 = conexion.prepareStatement(sqlLastKey);
            comando.execute();
            ResultSet ultimaKey = comando2.executeQuery();
            
                if(ultimaKey.next()){
                System.out.println("ENTRA AL IFFFF");
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

    @Override
    public void retirar(int clave, int folio) throws PersistenciaException {
        String codigoSQL = "call retiro(" + clave + "," + folio + ")";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL)) {
            comando.execute();
            conexion.close();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible realizar la transaccion");

        }

    }

    @Override
    public RetirosSinCuenta consultar(Integer idRetiro) {
        String codigoSQL = "select * from retirossincuenta where idRetirosSinCuenta=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idRetiro);
            ResultSet resultado = comando.executeQuery();

            RetirosSinCuenta retiro = null;

            if (resultado.next()) {
                int idCuenta = resultado.getInt("idCuentaCliente");
                Date fecha = resultado.getDate("fechaHora");
                int clave = resultado.getInt("clave");
                int folio = resultado.getInt("folio");
                String estado = resultado.getString("estado");
                float monto = resultado.getFloat("monto");
                //Integer idRetiroSinCuenta, Integer idCuentaCliente, Date fechaHora, int clave, int folio, String estado, int motos
                retiro = new  RetirosSinCuenta(idRetiro, idCuenta, fecha, clave, folio, estado, monto);
               
            }
            conexion.close();
            return retiro;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

}
