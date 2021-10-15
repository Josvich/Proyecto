/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DANNY
 */
public class validaciones {

    //validaciones clientes
    public boolean validacedula(String cedula) {
        if (cedula.matches("[0-9]{10}")) {
            return true;
        } else {
            return false;
        }
    }

    //INICIO DE LA VALIDACION DE NOMBRES Y APELLIDOS
    public boolean Validarnombres(String nombres) {
        boolean validar = true;
        for (int i = 0; i < nombres.length(); i++) {
            char cadena = nombres.charAt(i);
            if (!((cadena >= 'a' && cadena <= 'z') || (cadena >= 'A' && cadena <= 'Z') || (cadena == ' '))) {
                validar = false;
            }
        }
        return validar;
    }
    //FIN DE LA VALIDACION DE NOMBRES Y APELLIDOS

    public boolean validatelefono(String telefono) {
        if (telefono.matches("[0-9]{10}")) {
            return true;
        } else {
            return false;
        }
    }

//validaciones clientes 
    //VALIDACIONES DE LOS EMPLEADOS
    public static boolean validaContrasena(String contraseña) {
        return (contraseña.matches("[A-Za-z0-9]+"));
    }

    public static boolean validaRepiteClave(String contraseña, String repitacontraseña ) {
        return contraseña.equals(repitacontraseña);
    }
    //VALIDACIONES DE LOS EMPLEADOS
    
    //VALIDACION DEL CORREO ELECTRONICO
    //valida que ingrese una @ un y un .com valido
          public static boolean ValidarMail(String email) {

        // Patron para validar el email(String email) {


        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

 

        Matcher mather = pattern.matcher(email);

        return mather.find();

    }
   
    //VALIDACION DEL CORREO ELECTRONICO
          
          //VALIDACION DE NOMBREUSUARIO
           public static boolean validaNombreusuario(String usuario) {
           return (usuario.matches("[A-Za-z0-9]+"));
    }
          //VALIDACION NOMBREUSUSARIO

}
