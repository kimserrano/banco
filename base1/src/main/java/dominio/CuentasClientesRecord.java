/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 * Claase que tiene los atributos para crear y obtener las cuentas bancarias de
 * los clientes registrados
 *
 * @author Elmer y Kim
 */
public record CuentasClientesRecord(int idCuentasClientes, Date fechaHoraApertura, String nombre, float saldo, String numCuenta, int idClientes) {

}
