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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANNY
 */
public class Mantenimientos {

    private String codigo, detalle, costo;
    private Date fecha;

    public Mantenimientos(String codigo, String detalle, String costo, Date fecha) {
        this.codigo = codigo;
        this.detalle = detalle;
        this.costo = costo;
        this.fecha = fecha;
    }
  
    public Mantenimientos(){
        
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
 public boolean modificar(){
       PgConect conecta = new PgConect();
       
       String nsql = "UPDATE mantenimientos SET \n"+
               "  detalle = '"+getDetalle()+"',costo ='"+ getCosto()+"',fecha ='"+ getFecha()+"'\n"+
               "WHERE cedula ='" +getCodigo() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
   
  public ResultSet mostrar(){
         PgConect conecta = new PgConect();
         String nsql ="SELECT * FROM mantenimientos";
                 return conecta.query(nsql);
       }





   
    
       public boolean insertar() {
        PgConect conecta = new PgConect();

        String nsql = "INSERT INTO mantenimientos(\n"
                + "            codigo, detalle, costo, fecha)\n"
                + "    VALUES ('" + getCodigo() + "','" + getDetalle() + "','" + getCosto() + "','" + getFecha() + "');";

        if (conecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR");
            return false;

        }

    }
      
     public List<Mantenimientos> mostrarDatos(){
         
         try{
             ArrayList<Mantenimientos> lista = new ArrayList<Mantenimientos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM mantenimientos";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                 Mantenimientos coca = new Mantenimientos();
                 coca.setCodigo(rs.getString("codigo"));
                 coca.setDetalle(rs.getString("detalle"));
                 coca.setCosto(rs.getString("costo"));
                 coca.setFecha(rs.getDate("fecha"));
                 
                 lista.add(coca);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Mantenimientos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
     }
     
     
   
   public boolean eliminar(){
       PgConect conecta = new PgConect();
       
       String nsql = "Delete FROM mantenimientos \n"+
               "WHERE codigo ='" +getCodigo() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
   
   public boolean buscar(){
       PgConect conecta = new PgConect();
       
       String nsql ="SELECT codigo FROM mantenimientos \n"+
               "WHERE codigo ='" +getCodigo() +"';";
        if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
   public List<Mantenimientos> buscar(String criterio){
         
         try{
             ArrayList<Mantenimientos> lista = new ArrayList<Mantenimientos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM mantenimientos WHERE UPPER (codigo) like UPPER('%"+criterio+"%') or UPPER(detalle) like UPPER ('%"+criterio+"%')";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                 Mantenimientos coca = new Mantenimientos();
                 coca.setCodigo(rs.getString("codigo"));
                 coca.setDetalle(rs.getString("detalle"));
                 coca.setCosto(rs.getString("costo"));
                 coca.setFecha(rs.getDate("fecha"));
                 
                 lista.add(coca);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Mantenimientos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
     }
   
     public List<Mantenimientos> buscarCedula(String criterio){
         
         try{
             ArrayList<Mantenimientos> lista = new ArrayList<Mantenimientos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM mantenimientos WHERE codigo ='"+criterio+"';";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                Mantenimientos coca = new Mantenimientos();
                 coca.setCodigo(rs.getString("codigo"));
                 coca.setDetalle(rs.getString("detalle"));
                 coca.setCosto(rs.getString("costo"));
                 coca.setFecha(rs.getDate("fecha"));
                 
                 lista.add(coca);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Mantenimientos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
         
     }
   
   }

    
 

  
    
    

        


