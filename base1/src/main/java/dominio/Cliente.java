/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 * clase que contiene los atributos de los clientes y sus respectivos get y set
 * para interactuar con ellos
 *
 * @author Kim y Elmer
 */
public class Cliente {

    /**
     * id que identifica al cliente
     */
    private Integer id;
    /**
     * nomnre del cliente
     */
    private String nombre;
    /**
     * apellido paterno del cliente
     */
    private String apellidoPaterno;
    /**
     * apellido materno del cliente
     */
    private String apellidoMaterno;
    /**
     * número de domicilio del cliente
     */
    private Integer numDomicilio;
    /**
     * código postal del cliente
     */
    private Integer cp;
    /**
     * calle de donde vive el cliente
     */
    private String calle;
    /**
     * fecha en la que nacio el cliente
     */
    private Date fechaNacimiento;

    /**
     * constructor que inicializa sus atributos con sus paracmetros
     *
     * @param fechaNacimiento
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     */
    public Cliente(Date fechaNacimiento, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * constructor vacio
     */
    public Cliente() {
    }

    /**
     * constructor que inicializa sus atributos con sus paracmetros
     *
     * @param fechaNacimiento
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param cp
     * @param calle
     * @param numDomicilio
     */
    public Cliente(Date fechaNacimiento, String nombre, String apellidoPaterno, String apellidoMaterno, Integer cp, String calle, Integer numDomicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numDomicilio = numDomicilio;
        this.cp = cp;
        this.calle = calle;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @param numDomicilio set el número de domicilio del cliente
     */
    public void setNumDomicilio(Integer numDomicilio) {
        this.numDomicilio = numDomicilio;
    }

    /**
     *
     * @param cp set el código postal del cliente
     */
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    /**
     *
     * @param calle set calle de donde vive el cliente
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     *
     * @param fechaNacimiento fecha en la que nacio el cliente
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return número de domicilio del cliente
     */
    public Integer getNumDomicilio() {
        return numDomicilio;
    }

    /**
     *
     * @return código postal del cliente
     */
    public Integer getCp() {
        return cp;
    }

    /**
     *
     * @return la calle de donde vive el cliente
     */
    public String getCalle() {
        return calle;
    }

    /**
     *
     * @return la fecha en la que nacio el cliente
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @return id que identifica al cliente
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id set de id que identifica al cliente
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return nomnbre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre set del nomnbre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return apellido paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * @param apellidoPaterno set el apellido paterno del cliente
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * @return apellido materno del cliente
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * @param apellidoMaterno set el apellido materno del cliente
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
