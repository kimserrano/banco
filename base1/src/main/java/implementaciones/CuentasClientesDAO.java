/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.CuentasClientesRecord;
import dominio.Historiales;
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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *Clase que lleva el control de CuentasClientes y sus acciones
 * @author Kim y Elmer
 */
public class CuentasClientesDAO implements ICuentasClientesDAO {
/**
     * Atributo de IConexionBD que genera la conexión
     */
    private final IConexionBD GENERADOR_CONEXIONES;
    /**
     * Atributo final para las excepciones del logger
     */
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());

    /**
     * Constructor que setea la generación de conexión con la base de datos
     * @param GENERADOR_CONEXIONES Atributo de IConexionBD que genera la conexión
     */
    public CuentasClientesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Getter para regresar la conexión con la base de datos
     * @return Atributo de IConexionBD que genera la conexión
     */
    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

    
    /**
     * Metodo que inserta una cuenta(bancaria) con un objeto de tipo CuentasClientesRecord y un Objeto Cliente
     * @param cuenta CuentaBancara a insertar
     * @param cliente Cliente al que pertenece la cuenta
     * @return Regresa la cuenta con sus datos
     * @throws PersistenciaException Excepción que se lanza si algo sale mal en el momento de insertar la cuenta
     */
    @Override
    public CuentasClientesRecord insetarCuenta(CuentasClientesRecord cuenta, Cliente cliente) throws PersistenciaException {
        String codigoSQL = "insert into cuentasClientes (nombre, saldo, idClientes) values(?,?,?)";

        try ( Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cuenta.nombre());
            comando.setFloat(2, cuenta.saldo());
            comando.setInt(3, cliente.getId());
            comando.executeUpdate();
            conexion.close();
            return cuenta;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar esta cuenta");

        }

    }

    /**
     * Metodo para añadir saldo a la cuenta de algún cliente mediante su idcuentasClientes
     * @param saldo Saldo a añadir
     * @param cuenta idCuentasClientes de la cuenta 
     * @return regresa la cuenta con los nuevos datos si salió bien, null en caso contrario
     * @throws PersistenciaException  Excepción que se lanza si algo sale mal en el momento de ejecutar el código
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

    /**
     * Metodo que ocnsulta una cuenta de un cliente mediante el id de la misma cuenta del cliente
     * @param idCuentaCliente Id de la cuenta del cliente
     * @return regresa un objeto CuentasClientesRecord que contiene los datos de la cuenta que se buscaba, null si no se pudo seleccionar la cuenta
     */
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
/**
 * Metodo que elimina alguna cuenta de el cliente mediante su id
 * @param idCuentasClientes id de la Cuenta del cliente
 * @return Regresa la cuenta eliminada, null si no se pudo eliminar
 */
     public CuentasClientesRecord eliminar(int idCuentasClientes){
         String codigoSQL = "DELETE  FROM cuentasClientes WHERE idCuentasClientes=?";
         try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
                CuentasClientesRecord cuentaEliminada= this.consultar(idCuentasClientes);
                 comando.setInt(1, idCuentasClientes);
                comando.executeUpdate();
                
                     conexion.close();
                     return cuentaEliminada;
                 
        } catch (SQLException ex) {
            Logger.getLogger(CuentasClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
     }
    
     /**
      * Metodo que consulta una cuenta mediante su nombre y el id del cliente
      * @param nombre nombre de la cuenta
      * @param idCliente id del cliente
      * @return  Regresa la cuenta consultada con sus datos cargados, null en caso contrario
      */
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

    /**
     * Metodo que regresa un ArrayList que contiene todas las cuentas del cliente 
     * @param idCliente id del cliente del cual vamos a sacar sus cuentas
     * @return regresa un arraylist de objetos CuentasClietnesRecord que contiene todas las cuentas del cliente, null si salió mal 
     */
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

    
    /**
     * Metodo que consulta el historial del cliente (transacciones y retiros completados)
     * @param configPaginado La configuración del paginado que se usará para paginar las páginas
     * @param idCuentaCliente id de la cuenta del cliente el cual vamos a obtener sus movimientos
     * @param order Orden en el que se mostrará el historial (Descendiente o ascendente)
     * @return Regresa un arraylist conteniendo todos los movimientos de la cuenta en objetos Historiales.
     * @throws PersistenciaException 
     */
    @Override
    public ArrayList<Historiales> consultarHistorial(ConfiguracionPaginado configPaginado, int idCuentaCliente, String order) throws PersistenciaException {
        String codigoSQL = "select fechaOperacion, operacion, idHistorial FROM historiales WHERE idCuentaCliente1=? OR idCuentaCliente2=? ORDER BY fechaOperacion "+order+"  limit ? offset ?";
        ArrayList<Historiales> listaHistoriales = new ArrayList<>();
        
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            
            comando.setInt(1, idCuentaCliente);
            comando.setInt(2, idCuentaCliente);
            comando.setInt(3, configPaginado.getConteoPorPagina());
            comando.setInt(4, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();

            Historiales movimiento = null;

            while (resultado.next()) {
                String operacion = resultado.getString("operacion");
                Date fechaOperacion = resultado.getDate("fechaOperacion");
                int idHistorial = resultado.getInt("idHistorial");
                movimiento = new Historiales(operacion, fechaOperacion, idHistorial);
                listaHistoriales.add(movimiento);
            }
            return listaHistoriales;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException ("No fue posible consultar la lista de historiales");   
        }
    }

}
