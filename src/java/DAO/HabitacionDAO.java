package DAO;


import Entidades.Cliente;
import Entidades.Habitacion;
import conexion.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.internal.OracleTypes;

public class HabitacionDAO {

    private Connection conexion;

    public HabitacionDAO() {
    }

    public List<Habitacion> listarHabitacion() throws SQLException {

        List<Habitacion> Habitaciones = new ArrayList<>();
        try {
            this.conexion =  new conexion().obtenerConexion();

            String llamada = "{ call sp_listar_habitacion(?) }";
            CallableStatement cstmt = conexion.prepareCall(llamada);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            cstmt.execute();

            ResultSet rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setNumero(rs.getInt("numero_habitacion"));
                h.setTipo(rs.getString("tipo"));
                h.setPrecio(rs.getInt("precio"));
                Cliente c = new Cliente();
                c.setRut("rut_cliente");
                c.setNombre("nombre_cliente");
                c.setDireccion("direccion_cliente");
                c.setNumero('0');

                Habitaciones.add(h);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return Habitaciones;
    }

    public boolean agregarHabitacion(Habitacion habitacion) throws SQLException {

        boolean agregado = false;

        try {
            this.conexion =  new conexion().obtenerConexion();
            String llamada = "{ call sp_agregar_habitacion(?, ?, ?, ?, ?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);
            cstmt.setString(1, habitacion.getTipo());
            cstmt.setInt(2, habitacion.getPrecio());
            cstmt.setInt(3, habitacion.getNumero());
            
        

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

    public boolean modificarHabitacion(Habitacion habitacion) throws SQLException {

        boolean modificado = false;

        try {
            this.conexion =  new conexion().obtenerConexion();
            String llamada = "{ call sp_modificar_habitacion(?, ?, ?, ?, ?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);

            cstmt.setString(1, habitacion.getTipo());
            cstmt.setInt(2, habitacion.getPrecio());
            cstmt.setInt(3, habitacion.getNumero());
            

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

    public boolean eliminarHabitacion(Habitacion habitacion) throws SQLException {

        boolean eliminado = false;

        try {
           this.conexion =  new conexion().obtenerConexion();
            String llamada = "{ call sp_eliminar_habitacion(?) }";
            CallableStatement cstmt = this.conexion.prepareCall(llamada);

            cstmt.setInt(1, habitacion.getNumero());

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
