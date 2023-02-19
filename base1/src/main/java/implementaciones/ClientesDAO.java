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
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

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

    @Override
    public Cliente insertar(Cliente cliente, String usuario, String clave) throws PersistenciaException {
       

//  String codigoSQL = "call edadNecesaria(?,?,?,?,?,?,?)";
        String codigoSQL = "insert into Clientes (nombres, apellidoPat, apellidoMat, fechaNacimiento,calle,numDomicilio,cp) values(?,?,?,?,?,?,?)";

        String codigoSQLCredenciales = "insert into ClientesCredenciales(idClientes,clave,username) VALUES(?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setDate(4, cliente.getFechaNacimiento());
            comando.setString(5, cliente.getCalle());
            comando.setInt(6, cliente.getNumDomicilio());
            comando.setInt(7, cliente.getCp());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();
        
            if (generatedKeys.next()) {
                int posicionLlavePrimaria = 1;
                cliente.setId(generatedKeys.getInt(posicionLlavePrimaria));
                PreparedStatement comandoCredenciales = conexion.prepareStatement(codigoSQLCredenciales, Statement.RETURN_GENERATED_KEYS);
                {
                    comandoCredenciales.setInt(1, cliente.getId());
                    comandoCredenciales.setString(2, clave);
                    comandoCredenciales.setString(3, usuario);

                    comandoCredenciales.executeUpdate();
                }
                conexion.close();
                return cliente;
            }
            LOG.log(Level.WARNING, "Cliente registrado, pero id no generado ");
            throw new PersistenciaException("Cliente registrado, pero id no generado ");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");

        }

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
    @Override
    public List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   


    public IConexionBD getGENERADOR_CONEXIONES() {
        return GENERADOR_CONEXIONES;
    }

}
