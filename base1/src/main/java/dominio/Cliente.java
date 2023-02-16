/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author lv1013
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer numDomicilio;
    private Integer cp;
    private String calle;
    private Date fechaNacimiento;

    public Cliente(Date fechaNacimiento, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {
    }

    public Cliente(Date fechaNacimiento,String nombre, String apellidoPaterno, String apellidoMaterno, Integer cp, String calle, Integer numDomicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numDomicilio=numDomicilio;
        this.cp=cp;
        this.calle=calle;
        this.fechaNacimiento=fechaNacimiento;
    }

    public void setNumDomicilio(Integer numDomicilio) {
        this.numDomicilio = numDomicilio;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumDomicilio() {
        return numDomicilio;
    }

    public Integer getCp() {
        return cp;
    }

    public String getCalle() {
        return calle;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /*
    public Cliente(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", numDomicilio=" + numDomicilio + ", cp=" + cp + ", calle=" + calle + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

   
}
