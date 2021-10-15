package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
//MANEJAR LOS LOGS
import java.util.logging.Level;
import java.util.logging.Logger;

public class PgConect {

    Connection con;//CONEXION
    Statement st;//COMANDOS SQL
    ResultSet rs;//RESULTADOS DE CONSULTA

    String cadConexion = "jdbc:postgresql://localhost:5432/proyecto";
    String pgUser = "postgres";
    String pgContra = "123456";

    public PgConect() {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PgConect.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgContra);
            System.out.println("Se conecto DB.");
        } catch (SQLException ex) {
            Logger.getLogger(PgConect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SQLException noQuery(String nsql) {
        System.out.println(nsql);
        try {
            //SE EJECUTAN LOS DATOS
            st = con.createStatement();
            st.execute(nsql);
            st.close();
            return null;

        } catch (SQLException ex) {
            Logger.getLogger(PgConect.class.getName()).log(Level.SEVERE, null, ex);
            return ex;

        }
    }

    public ResultSet query(String sql) {
        System.out.println(sql);
        try {
            st = con.createStatement();
            //ESTABLECE LA CONEXION
            ResultSet rs = st.executeQuery(sql);
            //st.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PgConect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}


