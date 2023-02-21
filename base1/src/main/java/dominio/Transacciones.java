/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 * Clase de dominio que tiene los datos de la tabla transacciones
 *
 * @author Kim y Elmer
 */
public class Transacciones {

    /**
     * id de Transferencia
     */
    private int idTransferencia;
    /**
     * id de CuentaCliente1
     */
    private int idCuentaCliente1;
    /**
     * id de CuentaCliente2
     */
    private int idCuentaCliente2;
    /**
     * Monto de la transacción
     */
    private float monto;
    /**
     * Fecha de la transacción
     */
    private Date fechaHora;

    /**
     * Constructor que setea todos los atributos
     *
     * @param idTransferencia id de Transferencia
     * @param idCuentaCliente1 id de CuentaCliente1
     * @param idCuentaCliente2 id de CuentaCliente2
     * @param monto Monto de la transacción
     * @param fechaHora Fecha de la transacción
     */
    public Transacciones(int idTransferencia, int idCuentaCliente1, int idCuentaCliente2, float monto, Date fechaHora) {
        this.idTransferencia = idTransferencia;
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    /**
     * Constructor que setea los idCuentaCliente, monto y fecha
     *
     * @param idCuentaCliente1 id de CuentaCliente1
     * @param idCuentaCliente2 id de CuentaCliente2
     * @param monto Monto de la transacción
     * @param fechaHora Fecha de la transacción
     */
    public Transacciones(int idCuentaCliente1, int idCuentaCliente2, float monto, Date fechaHora) {
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    /**
     * Getter de idTransferencia
     *
     * @return idTransferencia
     */
    public int getIdTransferencia() {
        return idTransferencia;
    }

    /**
     * Getter de idCuentaCliente1
     *
     * @return idCuentaCliente1
     */
    public int getIdCuentaCliente1() {
        return idCuentaCliente1;
    }

    /**
     * Getter de idcuentaCliente2
     *
     * @return idcuentaCliente2
     */
    public int getIdCuentaCliente2() {
        return idCuentaCliente2;
    }

    /**
     * Getter del monto
     *
     * @return regresa el monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Getter de la fecha de la transacción
     *
     * @return fecha de transacción
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Setter de idTransferencia
     *
     * @param idTransferencia id de la transferencia
     */
    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    /**
     * Setter de idCuentaCliente 1
     *
     * @param idCuentaCliente1 id de la cuenta del cliente 1
     */
    public void setIdCuentaCliente1(int idCuentaCliente1) {
        this.idCuentaCliente1 = idCuentaCliente1;
    }

    /**
     * Stter del idCuentacliente2
     *
     * @param idCuentaCliente2 id de la cuenta del cliente 2
     */
    public void setIdCuentaCliente2(int idCuentaCliente2) {
        this.idCuentaCliente2 = idCuentaCliente2;
    }

    /**
     * Setter del monto de la transacción
     *
     * @param monto monto de la transacción
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Setter para la fecha de la transacción
     *
     * @param fechaHora fecha de la transacción
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

}
