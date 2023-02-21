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
 *
 * @author lv1013
 */
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public ClientesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cliente consultar(String usuario, String clave) throws PersistenciaException {
        Cliente cliente = null;
        String codigoSQL = "SELECT idClientes FROM clientesCredenciales WHERE username LIKE (?) AND clave LIKE (?);";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            //Se pasan los datos al statement
            comando.setString(1, usuario);
            comando.setString(2, clave);

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

    @Override
    public Cliente consultar(Integer idCliente) {
        String codigoSQL = "select * from clientes where idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
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

    @Override
    public Cliente insertar(Cliente cliente, String usuario, String clave) throws PersistenciaException {

        String codigoSQL = "call edadNecesaria(?,?,?,?,?,?,?,?,?)";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
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

    @Override
    public Cliente eliminar(Integer id) {
//        Cliente cliente = consultar(id);
////        String codigoSQLProblema= 
//        try {
//            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
//            PreparedStatement problema = conexion.prepareStatement("delete from problemas where id_cliente=?");
//            problema.setInt(1, id);
//            problema.execute();
//            PreparedStatement telefono = conexion.prepareStatement("delete from telefonos where id_cliente=?");
//            telefono.setInt(1, id);
//            telefono.execute();
//            PreparedStatement comando = conexion.prepareStatement("delete from clientes where id=?");
//            comando.setInt(1, id);
//            comando.execute();
//            conexion.close();
//            return cliente;
//
//        } catch (SQLException e) {
//            LOG.log(Level.SEVERE, e.getMessage());
        return null;
//        }
    }

    /*
    @Override
    public List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        String codigoSQL = "select id, nombre, apellido_paterno, apellido_materno, id_Direccion from clientes limit ? offset ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            
            comando.setInt(1, configPaginado.getConteoPorPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidoP = resultado.getString("apellido_paterno");
                String apellidoM = resultado.getString("apellido_materno");
                int idDireccion = resultado.getInt("id_Direccion");
                cliente = new Cliente(id, nombre, apellidoP, apellidoM, idDireccion);
                listaClientes.add(cliente);
            }
            return listaClientes;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException ("No fue posible consultar la lista de clientes");   
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */

    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

    @Override
    public void actualizarNombre(Integer idCliente, String nombre) {
        String codigoSQL = "UPDATE clientes SET nombres=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, nombre);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void actualizarApellidoMat(Integer idCliente, String apellidoMat) {
        String codigoSQL = "UPDATE clientes SET apellidoMat=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, apellidoMat);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void actualizarApellidoPat(Integer idCliente, String apellidoPat) {
        String codigoSQL = "UPDATE clientes SET apellidoPat=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, apellidoPat);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void actualizarCalle(Integer idCliente, String calle) {
        String codigoSQL = "UPDATE clientes SET calle=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, calle);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void actualizarNumDomicilio(Integer idCliente, int numDomicilio) {
        String codigoSQL = "UPDATE clientes SET numDomicilio=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, numDomicilio);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void actualizarCP(Integer idCliente, int CP) {
        String codigoSQL = "UPDATE clientes SET cp=? WHERE idClientes=?";
        try (
                 Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, CP);
            comando.setInt(2, idCliente);
            int cambio = comando.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

}