/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.HabitacionDAO;
import Entidades.Habitacion;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarHabitacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Habitacion> habitaciones = null;
        try {
            habitaciones = new HabitacionDAO().listarHabitacion();
        } catch (SQLException ex) {
            Logger.getLogger(ListarHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       for(Habitacion h : habitaciones) {
           System.out.println(h.getNumero());
           System.out.println(h.getTipo());
       }
    }
    
}
