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
public class Vehiculos {
    private String placa,modelo, color, marca, tipo, foto;

    public Vehiculos(String placa, String modelo, String color, String marca, String tipo, String foto) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.tipo = tipo;
        this.foto = foto;
    }
    
    
     public Vehiculos() {
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
     public boolean insertar() {
        PgConect conecta = new PgConect();

        String nsql = "INSERT INTO vehiculos(\n"
                + "            placa, modelo, color, marca, tipo, foto)\n"
                + "    VALUES ('" + getPlaca() + "','" + getModelo() + "','" + getColor() + "','" + getMarca() + "','" + getTipo() + "','" + getFoto() + "');";

        if (conecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR");
            return false;

        }

    }
      //BUSCAR CLIENTES EN LA BASE DE DATOS CONCRETO
    public List<Vehiculos> buscar(String criterio) {

        try {
            ArrayList<Vehiculos> lista = new ArrayList<Vehiculos>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM vehiculos WHERE UPPER (placa) like UPPER('%" + criterio + "%')or UPPER(modelo) like UPPER ('%" + criterio + "%')";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
               Vehiculos vehiculos = new Vehiculos();
                vehiculos.setPlaca(rs.getString("placa"));
                vehiculos.setModelo(rs.getString("modelo"));
                vehiculos.setColor(rs.getString("color"));
                vehiculos.setMarca(rs.getString("marca"));
                vehiculos.setTipo(rs.getString("tipo"));
                vehiculos.setFoto(rs.getString("foto"));
             

                lista.add(vehiculos);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//BUSCAR CLIENTES EN LA BASE DE DATOS CONCRETO
    
    
    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTRAR DATOS TABLA
    public List<Vehiculos> mostrarDatos() {

        try {
            ArrayList<Vehiculos> lista = new ArrayList<Vehiculos>();
            PgConect conecta = new PgConect();
            String sql = "SELECT * FROM vehiculos";

            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                //***************************************
                Vehiculos vehiculos = new Vehiculos();
                vehiculos.setPlaca(rs.getString("placa"));
                vehiculos.setModelo(rs.getString("modelo"));
                vehiculos.setColor(rs.getString("color"));
                vehiculos.setMarca(rs.getString("marca"));
                vehiculos.setTipo(rs.getString("tipo"));
                vehiculos.setFoto(rs.getString("foto"));
               

                lista.add(vehiculos);
                //*******************************************
            }
            rs.close();
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(Vehiculos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //BUSCAR CLIENTES EN LA BASE DE DATOS MOSTAR DATOS TABLA
    
     
     
    //MOFICAR CLIENTES EN LA BASE DE DATOS
    public boolean modificar(){
       PgConect conecta = new PgConect();
       
       String nsql = "UPDATE vehiculos SET \n"+
               "  modelo = '"+getModelo()+"',color ='"+ getColor()+"',marca ='"+ getMarca()+"',tipo ='"+ getTipo()+"',foto ='"+ getFoto()+"'\n"+
               "WHERE placa ='" +getPlaca() +"';";
       
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
       
       String nsql = "Delete FROM vehiculos \n"+
               "WHERE placa ='" +getPlaca() +"';";
       
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
         String nsql ="SELECT * FROM vehiculos";
                 return conecta.query(nsql);
       }
   //ELIMINAR EN LA BASE DE DATOS
}
    
    

