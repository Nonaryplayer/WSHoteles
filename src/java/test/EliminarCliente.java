/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entidades.Cliente;
import Entidades.Habitacion;
import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EliminarCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Habitacion habitacion=new Habitacion();
        habitacion.setNumero(1);
        
         Cliente c=new Cliente();
         c.setRut("12345678-0");
         
         ClienteDAO cDAO= new ClienteDAO();
          try {
            if (cDAO.eliminarClientes(c)) {
                System.out.println("eliminado correctamente");
            } else {
                System.out.println("Error eliminando");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
