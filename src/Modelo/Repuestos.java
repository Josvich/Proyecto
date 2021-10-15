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
public class Repuestos {
    private String codigo;
    private String nombres;
    private String descripcion;
    private String precio;
    private String cantidad;
    private String imagenesa;

    public Repuestos(String codigo, String nombres, String descripcion, String precio, String cantidad, String imagenesa) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagenesa = imagenesa;
    }

    
     public Repuestos() {

    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagenesa() {
        return imagenesa;
    }

    public void setImagenesa(String imagenesa) {
        this.imagenesa = imagenesa;
    }
    
    
    //CONEXION A LA BASE DE DATOS 
    public boolean insertar() {
        PgConect conecta = new PgConect();

        String nsql = "INSERT INTO repuestos(\n"
                + "            codigo, nombres, descripcion, precio, cantidad, foto)\n"
                + "    VALUES ('" + getCodigo() + "','" + getNombres() + "','" + getDescripcion() + "','" + getPrecio() + "','" + getCantidad() + "','" + getImagenesa() + "');";

        if (conecta.noQuery(nsql) == null) {
            return true;
        } else {
            System.out.println("ERROR");
            return false;

        }

    }
//CONEXION A LA BASE DE DATOS  
     public List<Repuestos> mostrarDatos(){
         
         try{
             ArrayList<Repuestos> lista = new ArrayList<Repuestos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM repuestos";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                 Repuestos repuestos = new Repuestos();
                 repuestos.setCodigo(rs.getString("codigo"));
                 repuestos.setNombres(rs.getString("nombres"));
                 repuestos.setDescripcion(rs.getString("descripcion"));
                 repuestos.setPrecio(rs.getString("precio"));
                 repuestos.setCantidad(rs.getString("cantidad"));
                 repuestos.setImagenesa(rs.getString("foto"));
                 lista.add(repuestos);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Repuestos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
     }
     
      //MOFICAR CLIENTES EN LA BASE DE DATOS
    public boolean modificar(){
       PgConect conecta = new PgConect();
       
       String nsql = "UPDATE repuestos SET \n"+
               "  nombres = '"+getNombres()+"',descripcion ='"+ getDescripcion()+"',precio ='"+ getPrecio()+"',cantidad ='"+ getCantidad()+"',foto ='"+ getImagenesa()+"'\n"+
               "WHERE codigo ='" +getCodigo() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
//MOFICAR CLIENTES EN LA BASE DE DATOS
    
    public boolean eliminar(){
       PgConect conecta = new PgConect();
       
       String nsql = "Delete FROM repuestos \n"+
               "WHERE codigo ='" +getCodigo() +"';";
       
       if (conecta.noQuery(nsql) == null){
           return true;
       } else {
           System.out.println("Error");
           return false;
           
       }
   }
    
    public List<Repuestos> buscar(String criterio){
         
         try{
             ArrayList<Repuestos> lista = new ArrayList<Repuestos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM repuestos WHERE UPPER (codigo) like UPPER('%"+criterio+"%') or UPPER(nombres) like UPPER ('%"+criterio+"%')";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                 Repuestos repuestos = new Repuestos();
                 repuestos.setCodigo(rs.getString("codigo"));
                 repuestos.setNombres(rs.getString("nombres"));
                 repuestos.setDescripcion(rs.getString("descripcion"));
                 repuestos.setPrecio(rs.getString("precio"));
                 repuestos.setCantidad(rs.getString("cantidad"));
                 repuestos.setImagenesa(rs.getString("foto"));
                 lista.add(repuestos);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Repuestos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
     }
   
     public List<Repuestos> buscarCedula(String criterio){
         
         try{
             ArrayList<Repuestos> lista = new ArrayList<Repuestos>();
             PgConect conecta = new PgConect();
             String sql = "SELECT * FROM repuestos WHERE codigo ='"+criterio+"';";
             
             ResultSet rs = conecta.query(sql);
             while (rs.next()) {
                 //***************************************
                 Repuestos repuestos = new Repuestos();
                 repuestos.setCodigo(rs.getString("codigo"));
                 repuestos.setNombres(rs.getString("nombres"));
                 repuestos.setDescripcion(rs.getString("descripcion"));
                 repuestos.setPrecio(rs.getString("precio"));
                 repuestos.setCantidad(rs.getString("cantidad"));
                 repuestos.setImagenesa(rs.getString("foto"));
                 lista.add(repuestos);
                 //*******************************************
             }
             rs.close();
             return lista;
             
         }catch (SQLException ex){
             Logger.getLogger(Repuestos.class.getName()).log(Level.SEVERE,null,ex);
             return null;
         }
         
     }
   
}
