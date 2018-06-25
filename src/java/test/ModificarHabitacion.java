/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entidades.Cliente;
import Entidades.Habitacion;
import DAO.ClienteDAO;
import DAO.HabitacionDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModificarHabitacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        Habitacion habitacion=new Habitacion();
        habitacion.setNumero(1);
        
        Habitacion h=new Habitacion();
        h.setNumero(1);
        h.setPrecio(5000);
        h.getTipo("corriente");
        HabitacionDAO hDAO =new HabitacionDAO();
          try {
            if (hDAO.modificarHabitacion(h)) {
               System.out.println("Modificado correctamente");
            } else {
                System.out.println("Error agregando");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
