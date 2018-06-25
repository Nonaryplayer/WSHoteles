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

public class AgregarCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Habitacion habitacion=new Habitacion();
        habitacion.setNumero(1);
        
        Cliente c=new Cliente();
        c.setDireccion("calle revuelta 1245");
        c.setNumero(14545454);
        c.setRut("12345678-0");
        c.setNombre("alfonso");
        
        ClienteDAO cDAO=new ClienteDAO();
        
          try {
            if (cDAO.agregarClientes(c)) {
                System.out.println("Agregado correctamente");
            } else {
                System.out.println("Error agregando");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
