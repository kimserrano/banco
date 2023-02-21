/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author Elmer y Kim
 */
public class Historiales {
    private int idHistorial;
    private String operacion;
    private int idTransferencia;
    private int idRetiros;
    private int idCuentaCliente1;
    private int idCuentaCliente2;
    private Date fechaOperacion;

    public Historiales(int idHistorial, String operacion, int idTransferencia, int idRetiros, int idCuentaCliente1, int idCuentaCliente2, Date fechaOperacion) {
        this.idHistorial = idHistorial;
        this.operacion = operacion;
        this.idTransferencia = idTransferencia;
        this.idRetiros = idRetiros;
        this.idCuentaCliente1 = idCuentaCliente1;
        this.idCuentaCliente2 = idCuentaCliente2;
        this.fechaOperacion = fechaOperacion;
    }

    public Historiales(String operacion, Date fechaOperacion, int idHistorial) {
        this.operacion = operacion;
        this.idHistorial=idHistorial;
        this.fechaOperacion = fechaOperacion;
    }
    
    

    public int getIdHistorial() {
        return idHistorial;
    }

    public String getOperacion() {
        return operacion;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public int getIdRetiros() {
        return idRetiros;
    }

    public int getIdCuentaCliente1() {
        return idCuentaCliente1;
    }

    public int getIdCuentaCliente2() {
        return idCuentaCliente2;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public void setIdRetiros(int idRetiros) {
        this.idRetiros = idRetiros;
    }

    public void setIdCuentaCliente1(int idCuentaCliente1) {
        this.idCuentaCliente1 = idCuentaCliente1;
    }

    public void setIdCuentaCliente2(int idCuentaCliente2) {
        this.idCuentaCliente2 = idCuentaCliente2;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
    
}
