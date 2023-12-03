package datos;

import dominio.Celda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CeldaDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM celdas";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM celdas WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO celdas (ubicacion, piso, tipo) VALUES(?,?,?)";

    private static final String SQL_UPDATE = "UPDATE celdas set ubicacion=?, piso=?, tipo=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM celdas WHERE id=?";
    //private Conexion conexion;

    public List<Celda> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Celda celda = null;
        List<Celda> celdas = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ubicacion = rs.getString("ubicacion");
                String piso = rs.getString("piso");
                String tipo = rs.getString("tipo");
               

                celda = new Celda(id, ubicacion, piso, tipo);
                celdas.add(celda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return celdas;
    }

    public Celda encontrar(Celda celda) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, celda.getId());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

             
                String ubicacion = rs.getString("ubicacion");
                String piso = rs.getString("piso");
                String tipo = rs.getString("tipo");
                
                
            celda.setUbicacion(ubicacion);
            celda.setPiso(piso);
            celda.setTipo(tipo);
          

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return celda;
    }

    public int insertar(Celda celda) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
             stmt.setString(1, celda.getUbicacion());
              stmt.setString(2, celda.getPiso());
               stmt.setString(3, celda.getTipo());
               
           

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Celda celda) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
                        
              stmt.setString(1, celda.getUbicacion());
              stmt.setString(2, celda.getPiso());
               stmt.setString(3, celda.getTipo());
            
            stmt.setInt(4, celda.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Celda celda) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, celda.getId());

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
