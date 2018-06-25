/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ClienteDAO;
import Entidades.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListarCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Cliente> clientes = null;
        try {
            clientes = new ClienteDAO().listarClientes();
        } catch (SQLException ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       for(Cliente c: clientes) {
           System.out.println(c.getNombre());
           System.out.println(c.getRut());
       }
    }
    
}
