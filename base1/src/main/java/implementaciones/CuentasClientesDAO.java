/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasClientesDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author eruma
 */
public class CuentasClientesDAO implements ICuentasClientesDAO {

    private final IConexionBD GENERADOR_CONEXIONES;
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

    public CuentasClientesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

    @Override
    public CuentasClientesRecord insetarCuenta(CuentasClientesRecord cuenta, Cliente cliente) throws PersistenciaException {
        String codigoSQL = "insert into cuentasClientes (nombre, saldo, idClientes) values(?,?,?)";

        String codigoSQLCredenciales = "insert into ClientesCredenciales(idClientes,clave,username) VALUES(?,?,?)";
        try ( Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.nombre());
            comando.setFloat(2, cuenta.saldo());
            comando.setInt(3, cliente.getId());
            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();
            conexion.close();
            return cuenta;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar esta cuenta");

        }

    }

    /*
    @Override
    public List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     */
    @Override
    public CuentasClientesRecord anadirSaldo(Float saldo, int cuenta) throws PersistenciaException {
        String codigoSQL = "UPDATE cuentasClientes set saldo=saldo+"+saldo+" WHERE idCuentasClientes="+cuenta;
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  Statement comando = conexion.createStatement();) {
                 comando.executeUpdate(codigoSQL);
                 
                     CuentasClientesRecord cuentaAnadida = this.consultar(cuenta);
                     conexion.close();
                     return cuentaAnadida;
                 
        } catch (SQLException ex) {
            Logger.getLogger(CuentasClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
     public CuentasClientesRecord consultar(int idCuentaCliente){
        String codigoSQL = "SELECT * FROM cuentasClientes WHERE idCuentasClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
                 comando.setInt(1, idCuentaCliente);
                 ResultSet resultado=comando.executeQuery();
                 
                 if(resultado.next()){
                     int id=resultado.getInt("idCuentasClientes");
                     Date fecha=resultado.getDate("fechaHoraApertura");
                     String nom=resultado.getString("nombre");
                     float saldo=resultado.getFloat("saldo");
                     int numCuenta=resultado.getInt("numCuenta");
                     int idClien=resultado.getInt("idClientes");

                     CuentasClientesRecord cuenta=new CuentasClientesRecord(id,fecha,nom,saldo,String.valueOf(numCuenta),idClien);
                     conexion.close();
                     return cuenta;
                 }
        } catch (SQLException ex) {
            Logger.getLogger(CuentasClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public CuentasClientesRecord consultar(String nombre, int idCliente) {
        String codigoSQL = "SELECT * FROM cuentasClientes WHERE nombre LIKE ? AND idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
                 comando.setString(1, nombre);
                 comando.setInt(2, idCliente);
                 ResultSet resultado=comando.executeQuery();
                 
                 if(resultado.next()){
                     int idCuentasClientes=resultado.getInt("idCuentasClientes");
                     Date fecha=resultado.getDate("fechaHoraApertura");
                     String nom=resultado.getString("nombre");
                     float saldo=resultado.getFloat("saldo");
                     int numCuenta=resultado.getInt("numCuenta");
                     int idClien=resultado.getInt("idClientes");

                     CuentasClientesRecord cuenta=new CuentasClientesRecord(idCuentasClientes,fecha,nom,saldo,String.valueOf(numCuenta),idClien);
                     conexion.close();
                     return cuenta;
                 }
        } catch (SQLException ex) {
            Logger.getLogger(CuentasClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<CuentasClientesRecord> cargarCuentas(int idCliente) {
        String codigoSQL = "SELECT * FROM cuentasClientes WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idCliente);
            ResultSet resultado = comando.executeQuery();
            ArrayList<CuentasClientesRecord> listCuentas = new ArrayList();

            while (resultado.next()) {
                int idCuentasClientes = resultado.getInt("idCuentasClientes");
                String nombre = resultado.getString("nombre");
                float saldo = resultado.getFloat("saldo");
                int numCuenta = resultado.getInt("numCuenta");
                String numCuentaCadena = String.valueOf(numCuenta);
                CuentasClientesRecord cuenta = new CuentasClientesRecord(idCuentasClientes, null, nombre, saldo, numCuentaCadena, idCliente);
                listCuentas.add(cuenta);
            }
            conexion.close();
            return listCuentas;

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
