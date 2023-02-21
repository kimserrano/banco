/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 * Clase que representa la entidad para los datos necesarios de un retiro sin
 * cuenta
 *
 * @author kim y elmer
 */
public class RetirosSinCuenta {

    /**
     * es la clave unica de identicaci[on del retiro sin cuenta
     */
    private Integer idRetiroSinCuenta;
    /**
     * es el id del cliente al que pertenece el retiro sin cuenta
     */
    private Integer idCuentaCliente;
    /**
     * es la fecha en la que se genero la solicitud de un retiro sin cuenta
     */
    private Date fechaHora;
    /**
     * es la clave con la cual se puede cobrar el retiro sin cuenta
     */
    private int clave;
    /**
     * es el folio con el cuel se puede cobrar el retiro sin cuenta
     */
    private int folio;
    /**
     * es el estado del retiro, si ya fue cobrado o no
     */
    private String estado;
    /**
     * es la cantida de dinero que se desea retirar
     */
    private float motos;

    /**
     * constructosr que recibe la clave y el folio y los setea a los atributos
     *
     * @param clave es la clave con la cual puede retirar el dinero
     * @param folio es el folio que necesita para retirar el dinero
     */
    public RetirosSinCuenta(int clave, int folio) {
        this.clave = clave;
        this.folio = folio;
    }

    /**
     * constructor encargado de setear sus atributos con los parametros
     *
     * @param idRetiroSinCuenta
     * @param idCuentaCliente
     * @param fechaHora
     * @param clave
     * @param folio
     * @param estado
     * @param motos
     */
    public RetirosSinCuenta(Integer idRetiroSinCuenta, Integer idCuentaCliente, Date fechaHora, int clave, int folio, String estado, float motos) {
        this.idRetiroSinCuenta = idRetiroSinCuenta;
        this.idCuentaCliente = idCuentaCliente;
        this.fechaHora = fechaHora;
        this.clave = clave;
        this.folio = folio;
        this.estado = estado;
        this.motos = motos;
    }

    /**
     *
     * @return regresa la clave unica de identicaci[on del retiro sin cuenta
     */
    public Integer getIdRetiroSinCuenta() {
        return idRetiroSinCuenta;
    }

    /**
     *
     * @param idRetiroSinCuenta setea la clave unica de identicaci[on del retiro
     * sin cuenta
     */
    public void setIdRetiroSinCuenta(Integer idRetiroSinCuenta) {
        this.idRetiroSinCuenta = idRetiroSinCuenta;
    }

    /**
     *
     * @return regresa el id del cliente al que pertenece el retiro sin cuenta
     */
    public Integer getIdCuentaCliente() {
        return idCuentaCliente;
    }

    /**
     *
     * @param idCuentaCliente setea el id del cliente al que pertenece el retiro
     * sin cuenta
     */
    public void setIdCuentaCliente(Integer idCuentaCliente) {
        this.idCuentaCliente = idCuentaCliente;
    }

    /**
     *
     * @return regresa la fecha en la que se genero la solicitud de un retiro
     * sin cuenta
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     *
     * @param fechaHora setea la fecha en la que se genero la solicitud de un
     * retiro sin cuenta
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     *
     * @return regresa la clave con la cual se puede cobrar el retiro sin cuenta
     */
    public int getClave() {
        return clave;
    }

    /**
     *
     * @param clave setea la clave con la cual se puede cobrar el retiro sin
     * cuenta
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
     *
     * @return regresa el folio con el cuel se puede cobrar el retiro sin cuenta
     */
    public int getFolio() {
        return folio;
    }

    /**
     *
     * @param folio setea el folio con el cuel se puede cobrar el retiro sin
     * cuenta
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     *
     * @return regresa el estado del retiro, si ya fue cobrado o no
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado setea el estado del retiro, si ya fue cobrado o no
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return regresa la cantida de dinero que se desea retirar
     */
    public float getMotos() {
        return motos;
    }

    /**
     *
     * @param motos setea la cantida de dinero que se desea retirar
     */
    public void setMotos(int motos) {
        this.motos = motos;
    }

}
