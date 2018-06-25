/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;
import Entidades.Cliente;
import Entidades.Habitacion;
import conexion.conexion;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Duoc
 */
public class ClienteDAO {
     private Connection conexion;

    public ClienteDAO() {
        
    }

    public List<Cliente> listarClientes() throws SQLException {

        List<Cliente> Clientes = new ArrayList<>();
        try {
            this.conexion = new conexion().obtenerConexion();

            String llamada = "{ call sp_listar_clientes(?) }";
            CallableStatement cstmt = conexion.prepareCall(llamada);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            cstmt.execute();

            ResultSet rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                Cliente c = new Cliente();
               c.setRut("rut_cliente");
                c.setNombre("nombre_cliente");
                c.setDireccion("direccion_cliente");
                c.setNumero('0');
                Clientes.add(c);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return Clientes;
    }

    public boolean agregarClientes(Cliente clientes) throws SQLException {

        boolean agregado = false;

        try {
            this.conexion = new conexion().obtenerConexion();
            String llamada = "{ call sp_agregar_cliente(?, ?, ?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);

            cstmt.setString(1, clientes.getRut);
            cstmt.setString(2, clientes.getNombre);
            cstmt.setString(3, clientes.getDireccion);
            cstmt.setInt(4, clientes.getNumero);
            
            if (cstmt.executeUpdate() > 0) {
                agregado = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.conexion.close();
        }

        return agregado;
    }

    public boolean modificarClientes(Cliente clientes) throws SQLException {

        boolean modificado = false;

        try {
            this.conexion = new conexion().obtenerConexion();
            String llamada = "{ call sp_modificar_raza(?, ?, ?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);

            cstmt.setString(1, clientes.getRut());
            cstmt.setString(2, clientes.getNombre);
            cstmt.setString(3, clientes.getDireccion);
            cstmt.setInt(4, clientes.getNumero);

            if (cstmt.executeUpdate() > 0) {
                modificado = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.conexion.close();
        }

        return modificado;
    }

    public boolean eliminarClientes(Cliente clientes) throws SQLException {

        boolean eliminado = false;

        try {
            this.conexion = new conexion().obtenerConexion();
            String llamada = "{ call sp_eliminar_raza(?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);

            cstmt.setString(1, clientes.getRut());

            if (cstmt.executeUpdate() > 0) {
                eliminado = true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.conexion.close();
        }

        return eliminado;
    }

}
