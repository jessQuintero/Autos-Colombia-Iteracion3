package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM usuario WHERE id=?";
    private static final String SQL_SELECT_BY_CEDULA = "SELECT * FROM usuario WHERE cedula=? AND clave=?";
    private static final String SQL_INSERT = "INSERT INTO usuario (cedula, nombre, apellido, correo,clave) VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE usuario set cedula=?, nombre=?, apellido=?, correo=?, clave=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id=?";
    //private Conexion conexion;

    public List<Usuario> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String clave = rs.getString("clave");

                usuario = new Usuario(id, cedula, nombre, apellido, correo,clave );
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }
    
    
    public Usuario iniciarSesion(int cedula, String clave) throws ClassNotFoundException {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_CEDULA);
            stmt.setInt(1, cedula);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();
           // rs.next();//nos posicionamos en el primer registro devuelto

            
            while (rs.next()) {
				usuario = new Usuario();
				usuario.setCedula(rs.getInt("cedula"));
				usuario.setClave(rs.getString("clave"));
			}
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }
    
    
    
    
    
    

    public Usuario encontrar(Usuario usuario) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

            int cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String clave = rs.getString("clave");

            usuario.setCedula(cedula);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
             usuario.setClave(clave);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }

    public int insertar(Usuario usuario) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, usuario.getCedula());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getClave());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Usuario usuario) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
              stmt.setInt(1, usuario.getCedula());
           stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getClave());
            
            stmt.setInt(6, usuario.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Usuario usuario) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId());

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
