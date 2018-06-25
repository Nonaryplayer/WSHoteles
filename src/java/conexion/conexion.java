/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Duoc
 */
public class conexion {
     private static Connection conexion;
     
     private String usuario = " ricardov";
    private String pass = "vokracir3";
     private String url ="jdbc:oracle:thin:"+usuario+"/"+pass+"@159.89.86.128:4921:xe";
     
     public conexion() {
            
        try {
            
            //cargar la libreria jdbc para oracle
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            this.conexion = DriverManager.getConnection(url, usuario, pass);
            
        } catch(Exception ex) {
            System.out.println("Error de conexion");
        }
    }
    
    public Connection obtenerConexion() {
        return conexion;
    }
}
