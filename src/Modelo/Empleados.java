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
public class Empleados {

    private String cedula, nombres, apellidos, usuario, contraseña, repita_contraseña, correo, telefono, rol;

    public Empleados(String cedula, String nombres, String apellidos, String usuario, String contraseña, String repita_contraseña, String correo, String telefono, String rol) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.repita_contraseña = repita_contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Empleados() {

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRepita_contraseña() {
        return repita_contraseña;
    }

    public void setRepita_contraseña(String repita_contraseña) {
        this.repita_contraseña = repita_contraseña;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    //INSERTAT DATOS A LA BASE DE DATOS
    public boolean insertar() {
        PgConect conecta = new PgConect();

        String nsql = "INSERT INTO empleados(\n"
                + "            cedula, nombres, apellidos, usuario, contraseña, repitacontraseña, correo, telefono, rol)\n"
                + "    VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getUsuario() + "','" + getContraseña() + "','" + getRepita_contraseña() + "','" + getCorreo() + "','" + getTelefono() + "','" + getRol() + "');";

        if (conecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR");
            return false;

        }
    }
    //INSERTAR DATOS A LA BASE DE DATOS

    //BUSCAR EMPLEADOS EN LA BASE DE DATOS CONCRETO
    public List<Empleados> buscar(String criterio) {

        try {
            ArrayList<Empleados> lista = new ArrayList<Empleados>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM empleados WHERE UPPER (cedula) like UPPER('%" + criterio + "%') or UPPER(nombres) like UPPER ('%" + criterio + "%')";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
                Empleados empleados = new Empleados();
                empleados.setCedula(rs.getString("cedula"));
                empleados.setNombres(rs.getString("nombres"));
                empleados.setApellidos(rs.getString("apellidos"));
                empleados.setUsuario(rs.getString("usuario"));
                empleados.setContraseña(rs.getString("contraseña"));
                empleados.setRepita_contraseña(rs.getString("repitacontraseña"));
                empleados.setCorreo(rs.getString("correo"));
                empleados.setTelefono(rs.getString("telefono"));
                empleados.setRol(rs.getString("rol"));

                lista.add(empleados);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//BUSCAR EMPLEADOS EN LA BASE DE DATOS CONCRETO

    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTRAR DATOS TABLA
    public List<Empleados> mostrarDatos() {

        try {
            ArrayList<Empleados> lista = new ArrayList<Empleados>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM empleados";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
                Empleados empleados = new Empleados();
                empleados.setCedula(rs.getString("cedula"));
                empleados.setNombres(rs.getString("nombres"));
                empleados.setApellidos(rs.getString("apellidos"));
                empleados.setUsuario(rs.getString("usuario"));
                empleados.setContraseña(rs.getString("contraseña"));
                empleados.setRepita_contraseña(rs.getString("repitacontraseña"));
                empleados.setCorreo(rs.getString("correo"));
                empleados.setTelefono(rs.getString("telefono"));
                empleados.setRol(rs.getString("rol"));

                lista.add(empleados);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTAR DATOS TABLA
    
     //MOFICAR CLIENTES EN LA BASE DE DATOS
    
    public boolean modificar(){
       PgConect conecta = new PgConect();
       
       String nsql = "UPDATE empleados SET \n"+
               "  nombres = '"+getNombres()+"',apellidos ='"+ getApellidos()+"',usuario ='"+ getUsuario()+"',contraseña ='"+ getContraseña()+"',correo ='"+ getCorreo()+"',telefono ='"+ getTelefono()+"',rol ='"+ getRol()+"'\n"+
               "WHERE cedula ='" +getCedula() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
//MOFICAR CLIENTES EN LA BASE DE DATOS
    
    
     
   // ELIMINAR EN LA BASE DE DATOS
  public boolean eliminar(){
       PgConect conecta = new PgConect();
       
       String nsql = "Delete FROM empleados \n"+
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
         String nsql ="SELECT * FROM empleados";
                 return conecta.query(nsql);
       }
   //ELIMINAR EN LA BASE DE DATOS
      
      
}


