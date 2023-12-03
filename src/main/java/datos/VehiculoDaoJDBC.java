package datos;

import dominio.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM vehiculos";
    private static final String SQL_SELECT2 ="SELECT  V.id,placa, color, marca, modelo, T.nombre as nombre, idCedula FROM vehiculos V JOIN tipos T ON V.idTipo=T.id";
    
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM vehiculos WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO vehiculos (placa, color, marca, modelo,idTipo,idCedula) VALUES(?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE vehiculos set placa=?, color=?, marca=?, modelo=?, idTipo=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM vehiculos WHERE id=?";
    //private Conexion conexion;

    public List<Vehiculo> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Vehiculo vehiculo = null;
        List<Vehiculo> vehiculos = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String nombre= rs.getString("nombre");
                int cedula = rs.getInt("idCedula");

                vehiculo = new Vehiculo(id, placa, color, marca, modelo,nombre, cedula);
                vehiculos.add(vehiculo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculos;
    }

    public Vehiculo encontrar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, vehiculo.getId());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

            String placa = rs.getString("placa");
            String color = rs.getString("color");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String tipo = rs.getString("idTipo");
            int cedula = rs.getInt("idCedula");
            vehiculo.setPlaca(placa);
            vehiculo.setColor(color);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
             vehiculo.setIdTipo(tipo);
  vehiculo.setCedulaCliente(cedula);
  
  
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vehiculo;
    }

    public int insertar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getMarca());
            stmt.setString(4, vehiculo.getModelo());
            stmt.setString(5, vehiculo.getIdTipo());
              stmt.setInt(6, vehiculo.getCedulaCliente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getColor());
            stmt.setString(3, vehiculo.getMarca());
            stmt.setString(4, vehiculo.getModelo());
               stmt.setString(5, vehiculo.getIdTipo());
  //  stmt.setInt(6, vehiculo.getCedulaCliente());
            stmt.setInt(6, vehiculo.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Vehiculo vehiculo) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vehiculo.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
