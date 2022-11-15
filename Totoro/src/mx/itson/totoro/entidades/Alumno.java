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

/**
 *
 * @author enri0
 */
public class Alumno {
    
    private int id;
    private String nombre;
    private String apellido;
    private String idCia;
    private Date fechaNacimiento;
    private String apodo;
    
    public List<Alumno> obtenerTodos(){
        List<Alumno> alumnos = new ArrayList<>();
        try{
       Connection conexion = new Conexion().obtener();
       Statement statement = conexion.createStatement();
       ResultSet resulSet = statement.executeQuery("SELECT id, nombre, apellido, idCia, fechaNacimiento, apodo FROM alumno");
       
       while(resulSet.next()){
           Alumno alumno = new Alumno();
           alumno.setId(resulSet.getInt(1));
           alumno.setNombre(resulSet.getString(2));
           alumno.setApellido(resulSet.getString(3));
           alumno.setIdCia(resulSet.getString(4));
           alumno.setFechaNacimiento(resulSet.getDate(5));
           alumno.setApodo(resulSet.getString(6));
           
           alumnos.add(alumno);
       }
        }catch (Exception ex){
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return alumnos;
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
