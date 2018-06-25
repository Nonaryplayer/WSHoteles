/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.HabitacionDAO;
import Entidades.Habitacion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duoc
 */
public class EliminarHabitacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Habitacion habitacion=new Habitacion();
        habitacion.setNumero(1);
        
        Habitacion h=new Habitacion();
        h.setNumero(1);
         HabitacionDAO hDAO =new HabitacionDAO();
          try {
            if (hDAO.eliminarHabitacion(h)) {
                System.out.println("Agregado correctamente");
            } else {
                System.out.println("Error agregando");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
