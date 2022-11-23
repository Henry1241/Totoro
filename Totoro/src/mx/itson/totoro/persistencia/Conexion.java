/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.totoro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * La clase conecta la base de datos que se quiere utilizar a NetBeans y le
 * permite leer sus datos.
 *
 * @author enri0
 */
public class Conexion {

    /**
     * Obtiene una Conexion hacia la base de datos utilizando los parametros
     * proporcionados
     * @return La conexion inicializada hacia la base de datos.
     */
    public Connection obtener() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/totorodb?user=root&password=Ninten22");
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getLocalizedMessage());
        }
        return conexion;
    }
}
