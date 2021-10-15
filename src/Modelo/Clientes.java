/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.PgConect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANNY
 */
public class Clientes {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;

    public Clientes(String cedula, String nombres, String apellidos, String correo, String telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Clientes() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//CONEXION A LA BASE DE DATOS 
    public boolean insertar() {
        PgConect conecta = new PgConect();

        String nsql = "INSERT INTO clientes(\n"
                + "            cedula, nombres, apellidos, correo, telefono)\n"
                + "    VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getCorreo() + "','" + getTelefono() + "');";

        if (conecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR");
            return false;

        }

    }
//CONEXION A LA BASE DE DATOS   

    //BUSCAR CLIENTES EN LA BASE DE DATOS CONCRETO
    public List<Clientes> buscar(String criterio) {

        try {
            ArrayList<Clientes> lista = new ArrayList<Clientes>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM clientes WHERE UPPER (cedula) like UPPER('%" + criterio + "%')or UPPER(nombres) like UPPER ('%"+criterio+"%')";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
                Clientes clientes = new Clientes();
                clientes.setCedula(rs.getString("cedula"));
                clientes.setNombres(rs.getString("nombres"));
                clientes.setApellidos(rs.getString("apellidos"));
                clientes.setCorreo(rs.getString("correo"));
                clientes.setTelefono(rs.getString("telefono"));

                lista.add(clientes);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//BUSCAR CLIENTES EN LA BASE DE DATOS CONCRETO
    
    
    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTRAR DATOS TABLA
    public List<Clientes> mostrarDatos() {

        try {
            ArrayList<Clientes> lista = new ArrayList<Clientes>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM clientes";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
                Clientes clientes = new Clientes();
                clientes.setCedula(rs.getString("cedula"));
                clientes.setNombres(rs.getString("nombres"));
                clientes.setApellidos(rs.getString("apellidos"));
                clientes.setCorreo(rs.getString("correo"));
                clientes.setTelefono(rs.getString("telefono"));

                lista.add(clientes);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTAR DATOS TABLA
    
    //MOFICAR CLIENTES EN LA BASE DE DATOS
    public boolean modificar(){
       PgConect conecta = new PgConect();
       
       String nsql = "UPDATE clientes SET \n"+
               "  nombres = '"+getNombres()+"',apellidos ='"+ getApellidos()+"',correo ='"+ getCorreo()+"',telefono ='"+ getTelefono()+"'\n"+
               "WHERE cedula ='" +getCedula() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
//MOFICAR CLIENTES EN LA BASE DE DATOS
    
    
//ELIMINAR EN LA BASE DE DATOS
  public boolean eliminar(){
       PgConect conecta = new PgConect();
       
       String nsql = "Delete FROM clientes \n"+
               "WHERE cedula ='" +getCedula() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
       //ELIMINAR EN LA BASE DE DATOS
  
  
     //ELIMINAR EN LA BASE DE DATOS
      public ResultSet mostrar(){
         PgConect conecta = new PgConect();
         String nsql ="SELECT * FROM clientes";
                 return conecta.query(nsql);
       }
   //ELIMINAR EN LA BASE DE DATOS
}
