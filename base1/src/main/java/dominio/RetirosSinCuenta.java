/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author kim
 */
public class RetirosSinCuenta {

    private Integer idRetiroSinCuenta;
    private Integer idCuentaCliente;
    private Date fechaHora;
    private int clave;
    private int folio;
    private String estado;
    private float motos;

    public RetirosSinCuenta(int clave, int folio) {
        this.clave = clave;
        this.folio = folio;
    }

    public RetirosSinCuenta(Integer idRetiroSinCuenta, Integer idCuentaCliente, Date fechaHora, int clave, int folio, String estado, float motos) {
        this.idRetiroSinCuenta = idRetiroSinCuenta;
        this.idCuentaCliente = idCuentaCliente;
        this.fechaHora = fechaHora;
        this.clave = clave;
        this.folio = folio;
        this.estado = estado;
        this.motos = motos;
    }
   

    public Integer getIdRetiroSinCuenta() {
        return idRetiroSinCuenta;
    }

    public void setIdRetiroSinCuenta(Integer idRetiroSinCuenta) {
        this.idRetiroSinCuenta = idRetiroSinCuenta;
    }

    public Integer getIdCuentaCliente() {
        return idCuentaCliente;
    }

    public void setIdCuentaCliente(Integer idCuentaCliente) {
        this.idCuentaCliente = idCuentaCliente;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getMotos() {
        return motos;
    }

    public void setMotos(int motos) {
        this.motos = motos;
    }
    
    

}
