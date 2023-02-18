/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author eruma
 */
public class Transacciones {
    
    private int idTransferencia;
    private int idCuentaCliente1;
    private int idCuentaCliente2;
    private float monto;
    private Date fechaHora;

    public Transacciones(int idTransferencia, int idCuentaCliente1, int idCuentaCliente2, float monto,  Date fechaHora) {
        this.idTransferencia = idTransferencia;
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public Transacciones(int idCuentaCliente1, int idCuentaCliente2, float monto,  Date fechaHora) {
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public int getIdCuentaCliente1() {
        return idCuentaCliente1;
    }

    public int getIdCuentaCliente2() {
        return idCuentaCliente2;
    }

    public float getMonto() {
        return monto;
    }



    public Date getFechaHora() {
        return fechaHora;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public void setIdCuentaCliente1(int idCuentaCliente1) {
        this.idCuentaCliente1 = idCuentaCliente1;
    }

    public void setIdCuentaCliente2(int idCuentaCliente2) {
        this.idCuentaCliente2 = idCuentaCliente2;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }



    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}
