/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 * Clase que maenja los atributos del historial de operaciones
 *
 * @author Elmer y Kim
 */
public class Historiales {

    /**
     * id que identifica al historial
     */
    private int idHistorial;
    /**
     * operacion realiada ya sea retiro sin cuenta o transferencia
     */
    private String operacion;
    /**
     * id que identifica una transferencia
     */
    private int idTransferencia;
    /**
     * id que identifica un retiro
     */
    private int idRetiros;
    /**
     * id que identifica a un cliente que participe
     */
    private int idCuentaCliente1;
    /**
     * id que identifica a otro cliente
     */
    private int idCuentaCliente2;
    /**
     * fecha en la que se hace la operacion
     */
    private Date fechaOperacion;

    /**
     * constructor que inicializa todos sus atributos con sus parametros
     *
     * @param idHistorial
     * @param operacion
     * @param idTransferencia
     * @param idRetiros
     * @param idCuentaCliente1
     * @param idCuentaCliente2
     * @param fechaOperacion
     */
    public Historiales(int idHistorial, String operacion, int idTransferencia, int idRetiros, int idCuentaCliente1, int idCuentaCliente2, Date fechaOperacion) {
        this.idHistorial = idHistorial;
        this.operacion = operacion;
        this.idTransferencia = idTransferencia;
        this.idRetiros = idRetiros;
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.fechaOperacion = fechaOperacion;
    }

    /**
     *
     * @param operacion
     * @param fechaOperacion
     * @param idHistorial
     */
    public Historiales(String operacion, Date fechaOperacion, int idHistorial) {
        this.operacion = operacion;
        this.idHistorial = idHistorial;
        this.fechaOperacion = fechaOperacion;
    }

    /**
     *
     * @return id que identifica al historial
     */
    public int getIdHistorial() {
        return idHistorial;
    }

    /**
     *
     * @return operacion realizada ya sea retiro sin cuenta o transferencia
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     *
     * @return id que identifica una transferencia
     */
    public int getIdTransferencia() {
        return idTransferencia;
    }

    /**
     *
     * @return id que identifica un retiro
     */
    public int getIdRetiros() {
        return idRetiros;
    }

    /**
     *
     * @return id que identifica a un cliente que participe
     */
    public int getIdCuentaCliente1() {
        return idCuentaCliente1;
    }

    /**
     *
     * @return id que identifica a otro cliente
     */
    public int getIdCuentaCliente2() {
        return idCuentaCliente2;
    }

    /**
     *
     * @return fecha en la que se hace la operacion
     */
    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    /**
     *
     * @param idHistorial setea id que identifica al historial
     */
    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    /**
     *
     * @param operacion setea la operacion realizada ya sea retiro sin cuenta o
     * transferencia
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     *
     * @param idTransferencia set de id que identifica una transferencia
     */
    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    /**
     *
     * @param idRetiros set de id que identifica un retiro
     */
    public void setIdRetiros(int idRetiros) {
        this.idRetiros = idRetiros;
    }

    /**
     *
     * @param idCuentaCliente1 set de id que identifica a un cliente que
     * participe
     */
    public void setIdCuentaCliente1(int idCuentaCliente1) {
        this.idCuentaCliente1 = idCuentaCliente1;
    }

    /**
     *
     * @param idCuentaCliente2 set de id que identifica a otro cliente
     */
    public void setIdCuentaCliente2(int idCuentaCliente2) {
        this.idCuentaCliente2 = idCuentaCliente2;
    }

    /**
     *
     * @param fechaOperacion set de fecha en la que se hace la operacion
     */
    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

}
