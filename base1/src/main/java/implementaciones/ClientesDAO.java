/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.google.protobuf.Internal;
import dominio.Cliente;
import dominio.CuentasClientesRecord;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 * Clase que lleva el control de los metodos de Clientes
 *
 * @author Elmer y Kim
 */
public class ClientesDAO implements IClientesDAO {

    /**
     * Atributo final para las excepciones del logger
     */
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    /**
     * Atributo de IConexionBD que genera la conexión
     */
    private final IConexionBD GENERADOR_CONEXIONES;

    /**
     * Constructor que implementa el generador de conexiones
     *
     * @param generadorConexiones Atributo de IConexionBD que genera la conexión
     */
    public ClientesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    /**
     * Metodo que consulta los datos de un cliente mediante s us credenciales de
     * inicio de seisión
     *
     * @param usuario Usuario para iniciar sesión del cliente
     * @param clave Clave para inciar sesión con un cliente
     * @return Regresa un objeto cliente con su Id
     * @throws PersistenciaException Lanza una persistencia exception si algo
     * sale mal
     */
    @Override
    public Cliente consultar(String usuario, String clave) throws PersistenciaException {
        Cliente cliente = null;
        String codigoSQL = "SELECT idClientes FROM clientesCredenciales WHERE username LIKE (?) AND clave = (aes_encrypt('" + clave + "','yorx'));";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            //Se pasan los datos al statement
            comando.setString(1, usuario);

            ResultSet resultado = comando.executeQuery(); //Se ejecuta la Query
            if (resultado.next()) {
                int idCliente = resultado.getInt("idClientes");
                cliente = this.consultar(idCliente);
                cliente.setId(idCliente);
            }
            conexion.close();
            return cliente;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Metodo que consulta un cliente mediante su id
     *
     * @param idCliente id del cliente a consultar
     * @return cliente con sus atributos, null si una excepción es lanzada
     */
    @Override
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "select * from clientes where idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, idCliente);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;

            if (resultado.next()) {
                String nombre = resultado.getString("nombres");
                String apellidoP = resultado.getString("apellidoPat");
                String apellidoM = resultado.getString("apellidoMat");
                int cp = resultado.getInt("cp");
                int numDomicilio = resultado.getInt("numDomicilio");
                String calle = resultado.getString("calle");
                Date fechaNacimiento = resultado.getDate("fechaNacimiento");
                cliente = new Cliente(fechaNacimiento, nombre, apellidoP, apellidoM, cp, calle, numDomicilio);
            }
            conexion.close();
            return cliente;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Metodo que registra a un cliente y sus credenciales para iniciar sesión
     * una vez se comprueba que es mayor de edad
     *
     * @param cliente Cliente a ingresar
     * @param usuario Usuario del cliente
     * @param clave Clave del cliente
     * @return Regresa el cliente ingresado
     * @throws PersistenciaException Excepción lanzada si algo sale mal
     */
    @Override
    public Cliente insertar(Cliente cliente, String usuario, String clave) throws PersistenciaException {

        String codigoSQL = "call edadNecesaria(?,?,?,?,?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            int ano = cliente.getFechaNacimiento().getYear() + 1900;
            int mes = cliente.getFechaNacimiento().getMonth();

            Period edad = Period.between(LocalDate.of(ano, mes, cliente.getFechaNacimiento().getDate()), LocalDate.now());

            if (edad.getYears() >= 18) {
                comando.setString(1, cliente.getNombre());
                comando.setString(2, cliente.getApellidoPaterno());
                comando.setString(3, cliente.getApellidoMaterno());
                comando.setDate(4, cliente.getFechaNacimiento());
                comando.setString(5, cliente.getCalle());
                comando.setInt(6, cliente.getNumDomicilio());
                comando.setInt(7, cliente.getCp());
                comando.setString(8, usuario);
                comando.setString(9, clave);
                comando.executeUpdate();
                conexion.close();

                return cliente;
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
        return null;
    }

    /**
     * Getter del generador de conexiones
     *
     * @return Conexion con la base de datos
     */
    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

    /**
     * Metodo que actualiza el nombre de un cliente mediante su id
     *
     * @param idCliente id del cliente a ingresar
     * @param nombre nuevo nombre del cliente a ingresar
     */
    @Override
    public void actualizarNombre(Integer idCliente, String nombre) {
        String codigoSQL = "UPDATE clientes SET nombres=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, nombre);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Metodo que actualiza el apellido materno de un cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param apellidoMat nuevo apellido materno a actualizar
     */
    @Override
    public void actualizarApellidoMat(Integer idCliente, String apellidoMat) {
        String codigoSQL = "UPDATE clientes SET apellidoMat=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, apellidoMat);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * metodo que actualiza el apellido paterno de un cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param apellidoPat apellido paterno de un cliente a actualizar
     */
    @Override
    public void actualizarApellidoPat(Integer idCliente, String apellidoPat) {
        String codigoSQL = "UPDATE clientes SET apellidoPat=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, apellidoPat);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Metodo que actualizar la calle de un cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param calle calle nueva a actualizar
     */
    @Override
    public void actualizarCalle(Integer idCliente, String calle) {
        String codigoSQL = "UPDATE clientes SET calle=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, calle);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * ¨Metodo que actualiza el número de domiciio de un cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param numDomicilio nuevo numDeDomicilio a actualizar
     */
    @Override
    public void actualizarNumDomicilio(Integer idCliente, int numDomicilio) {
        String codigoSQL = "UPDATE clientes SET numDomicilio=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, numDomicilio);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * Metodo que actualiza el cp de un cliente
     *
     * @param idCliente id del cliente a actualizar
     * @param CP Cp nuevo a actualizar
     */
    @Override
    public void actualizarCP(Integer idCliente, int CP) {
        String codigoSQL = "UPDATE clientes SET cp=? WHERE idClientes=?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, CP);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

}
