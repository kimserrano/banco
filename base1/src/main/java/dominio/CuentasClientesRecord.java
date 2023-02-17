/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author eruma
 */
public record CuentasClientesRecord(int idCuentasClientes, Date fechaHoraApertura, String nombre,float saldo, int numCuenta, int idClientes ) {

//public record CuentasClientesRecord(String nombre,float saldo, int numCuenta, int idClientes ) {
    
}
