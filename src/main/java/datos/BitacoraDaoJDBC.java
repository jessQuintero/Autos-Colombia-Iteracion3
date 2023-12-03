package datos;

import dominio.Bitacora;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BitacoraDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM bitacoras";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM bitacoras WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO bitacoras (placa, fecha, movimiento,hora) VALUES(?,NOW(),?,CURTIME())";
    private static final String SQL_INSERT2 = "INSERT INTO bitacoras (placa, fecha, movimiento,hora) VALUES((SELECT placa FROM vehiculos WHERE placa=?),NOW(),?,CURTIME())";

   // INSERT INTO bitacoras (placa, fecha, movimiento, hora) VALUES("aaaaaa",NOW(),"entro",CURTIME());

    
      //private Conexion conexion;

    public List<Bitacora> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Bitacora bitacora = null;
        List<Bitacora> bitacoras = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                Date fecha = rs.getDate("fecha");
               Time hora = rs.getTime("hora");
                String movimiento = rs.getString("movimiento");
          

                bitacora = new Bitacora(id, placa, fecha,movimiento,hora);
                bitacoras.add(bitacora);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bitacoras;
    }

    public Bitacora encontrar(Bitacora bitacora) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, bitacora.getId());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

             
                String placa = rs.getString("placa");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                String movimiento = rs.getString("movimiento");
          
                

            bitacora.setPlaca(placa);
            bitacora.setFecha(fecha);
         //   bitacora.setHora(hora);
            bitacora.setMovimiento(movimiento);
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bitacora;
    }

    public int insertar(Bitacora bitacora) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bitacora.getPlaca());
             stmt.setString(2, bitacora.getMovimiento());
        //    stmt.setDate(3, bitacora.getFecha());
            //stmt.setTime(3, bitacora.getHora());
           
       

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
