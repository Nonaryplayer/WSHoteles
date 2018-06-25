/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PUT;
import Entidades.Cliente;
import DAO.ClienteDAO;

/**
 *
 * @author Duoc
 */
@Path("/cliente")
public class ClienteWS {
   
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarMascotas() {
        
        ClienteDAO cDAO = new ClienteDAO();
        
        try {
            List<Cliente> Clientes = cDAO.listarClientes();
            return Clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NotFoundException();
    }
    
    @POST
    @Path("/agregar")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente agregarClientes(Cliente Clientes) {
       ClienteDAO cDAO = new ClienteDAO();
        
        try {
            if(cDAO.agregarClientes(Clientes)) {
                return Clientes;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new BadRequestException();
    }
    
    @DELETE
    @Path("/eliminar")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente eliminarClientes(Cliente Clientes) {
        ClienteDAO cDAO = new ClienteDAO();
        
        try {
            if(cDAO.eliminarClientes(Clientes)) {
                return Clientes;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new BadRequestException();
    }
    
    @PUT
    @Path("/modificar")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente ModificarClientes(Cliente Clientes) {
        ClienteDAO cDAO = new ClienteDAO();
        
        try {
            if(cDAO.modificarClientes(Clientes)) {
                return Clientes;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new BadRequestException();
    }
    
}
