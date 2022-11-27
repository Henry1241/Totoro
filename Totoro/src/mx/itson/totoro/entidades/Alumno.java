/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.totoro.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itson.totoro.persistencia.Conexion;
import java.sql.PreparedStatement;

/**
 * La clase contiene los datos de la base de datos para que NetBeans pueda
 * identificarlos de manera correcta.
 * @author enri0
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellido;
    private String idCia;
    private Date fechaNacimiento;
    private String apodo;

    /**
     * En este metodo se idenfica la conexion con la base de datos y busca los
     * datos existentes en la base de datos para obtenerlos.
     * @return Regresa los datos de la tabla alumno encontrados en la base de datos.
     */
    public List<Alumno> obtenerTodos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection conexion = new Conexion().obtener();
            Statement statement = conexion.createStatement();
            ResultSet resulSet = statement.executeQuery("SELECT id, nombre, apellido, idCia, fechaNacimiento, apodo FROM alumno");

            while (resulSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(resulSet.getInt(1));
                alumno.setNombre(resulSet.getString(2));
                alumno.setApellido(resulSet.getString(3));
                alumno.setIdCia(resulSet.getString(4));
                alumno.setFechaNacimiento(resulSet.getDate(5));
                alumno.setApodo(resulSet.getString(6));

                alumnos.add(alumno);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return alumnos;
    }

   public static boolean guardar(String nombre, String apellido, String idCia, Date fechaNacimiento, String apodo){
       boolean resultado = false;
       try {
           Connection conexion = new Conexion().obtener();
           String consulta = "INSERT INTO (nombre, apellido, idCia, apodo) VALUES (?, ?, ?, ?)";
           PreparedStatement statement = conexion.prepareStatement(consulta);
           statement.setString(1, nombre);
           statement.setString(2, apellido);
           statement.setString(3, idCia);
           statement.setString(4, apodo);
           statement.execute();
           
           resultado = statement.getUpdateCount() == 1;
           conexion.close();
           
       } catch (Exception ex) {
           System.err.println("Ocurrio un error: " + ex.getMessage());
       }
       return resultado;
   }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the idCia
     */
    public String getIdCia() {
        return idCia;
    }

    /**
     * @param idCia the idCia to set
     */
    public void setIdCia(String idCia) {
        this.idCia = idCia;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the apodo
     */
    public String getApodo() {
        return apodo;
    }

    /**
     * @param apodo the apodo to set
     */
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

}
