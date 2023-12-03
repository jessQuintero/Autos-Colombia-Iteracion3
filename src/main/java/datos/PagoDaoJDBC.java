package datos;

import static datos.Conexion.getConnection;
import dominio.Pago;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PagoDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM pagos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM pagos WHERE id=?";
   private static final String SQL_SELECT2 = "SELECT C.nombre, C.apellido, placa,T.nombre as tipo FROM vehiculos V, clientes C, tipos T WHERE (V.idTipo=T.id AND V.idCedula=C.cedula)";
  
   private static final String SQL_SELECT_BY_PLACA = "SELECT C.nombre, C.apellido, placa,T.nombre as tipo FROM vehiculos V, clientes C, tipos T WHERE (V.idTipo=T.id AND V.idCedula=C.cedula) AND V.placa=?";

    
    //private static final String SQL_SELECT_BY_PLACA = "SELECT V.id, placa, marca, modelo, T.nombre as \"Tipo de Vehiculo\", CONCAT(C.nombre,' ',C.apellido) AS \"Cliente\" FROM vehiculos V, clientes C, tipos T WHERE (V.idTipo=T.id AND V.idCedula=C.cedula) AND V.placa=?";
    private static final String SQL_INSERT = "INSERT INTO pagos (nombre, apellido, placa,tipo, valorDia,ValorPagar ) VALUES(?,?,?,?,?,?)";

    private static final String SQL_DELETE = "DELETE FROM pagos WHERE id=?";
    //private Conexion conexion;

    public List<Pago> listar() throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pago pago = null;
        List<Pago> pagos = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();

            while (rs.next()) {
               // int id = rs.getInt("id");
               
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String placa = rs.getString("placa");
                String tipo = rs.getString("tipo");
               // int valorDia = rs.getInt("valorDia");
               // int ValorMensual = rs.getInt("ValorMensual");
                pago = new Pago(nombre, apellido,placa,tipo);
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pagos;
    }
    
    
    
    
    public List<Pago>  listarPlaca(String placaCliente) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pago pago = null;
       List<Pago> pagos = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_PLACA);
             stmt.setString(1, placaCliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
               // int id = rs.getInt("id");
            //  pago.setPlaca(rs.getString("placa"));
               
             
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String placa2 = rs.getString("placa");
                String tipo = rs.getString("tipo");
               
              
                pago = new Pago(nombre, apellido,placa2,tipo);
                pagos.add(pago);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pagos;
    }
    
    
    
    
    
    

    public Pago encontrar(Pago pago) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
     
        try {
            conn = Conexion.getConnection();
          //  stmt = conn.prepareStatement(SQL_SELECT2);
             stmt = conn.prepareStatement(SQL_SELECT_BY_PLACA);
             
        
             
             
             
            stmt.setString(1, pago.getPlaca());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro devuelto

          //  int cedula = rs.getInt("cedula");
                
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String placa = rs.getString("placa");
                String tipo = rs.getString("tipo");
             //   int valorDia = rs.getInt("valorDia");
             //   int ValorMensual = rs.getInt("ValorMensual");
                
                
            pago.setNombre(nombre);
            pago.setApellido(apellido);
            pago.setPlaca(placa);
             pago.setTipo(tipo);
           //  pago.setValorDia(valorDia);
            // pago.setValorMensual(ValorMensual);
             
             
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pago;
    }

    public int insertar(Pago pago) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
         //   stmt.setInt(1, pago.getCedula());
         
         
            stmt.setString(1, pago.getNombre());
            stmt.setString(2, pago.getApellido());
            stmt.setString(3, pago.getPlaca());
            stmt.setString(4, pago.getTipo());
            stmt.setInt(5, pago.getValorDia());
            stmt.setInt(6, pago.getValorMensual());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

   public int eliminar(Pago pago) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pago.getIdPago());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
   
 /*  
   public static void reporteVehiculo() throws SQLException, ClassNotFoundException, JRException{
     Connection conn = null;
       conn = Conexion.getConnection();     
    String rutaInforme="/WEB-INF/reporte/";
        try {
          
           // Compilar el informe
    JasperCompileManager.compileReportToFile("ReporteVehiculo.jrxml");

    // Llenar el informe con datos (puedes obtener estos datos de la base de datos)
    Map<String, Object> parameters = new HashMap<>();
    JasperPrint jasperPrint = JasperFillManager.fillReport(rutaInforme.replace(".jrxml", ".jasper"), parameters);

    // Exportar a PDF
    JasperExportManager.exportReportToPdfFile(jasperPrint, "ReporteVehiculo.jasper");

    System.out.println("PDF creado correctamente en: " + "ReporteVehiculo.pdf");
} catch (JRException e) {
    System.err.println("Error en JasperReports: " + e.getMessage());
    e.printStackTrace();
} catch (Exception e) {
    System.err.println("Error general: " + e.getMessage());
    e.printStackTrace();
} 
   }

/*
// Compilar el informe
            JasperCompileManager.compileReportToFile("ReporteVehiculo.jrxml","ReporteVehiculo.jasper");
            
            InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/reporte/ReporteVehiculo.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(jasperStream);
            
            

            // Llenar el informe con datos (puedes obtener estos datos de la base de datos)
            Map<String, Object> parameters = new HashMap<>();
          //  JasperPrint jasperPrint = JasperFillManager.fillReport(datos_registro.pdf.replace(".jrxml", ".jasper"), parameters);

            // Exportar a PDF
            JasperExportManager.exportReportToPdfFile("report", "/WEB-INF/reporte/datos_registro.pdf");

            System.out.println("PDF creado correctamente en: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
*/

   
   
       public static void generarPDF(String rutaInforme, String nombreArchivo) {
        try {
            // Cargar el informe desde un flujo de entrada
            InputStream inputStream = new FileInputStream(new File(rutaInforme));

            // Compilar el informe
            JasperCompileManager.compileReportToStream(inputStream, new FileOutputStream("ReporteVehiculo.jasper"));

            // Llenar el informe con datos (puedes obtener estos datos de la base de datos)
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport("ReporteVehiculo.jasper", parameters);

            // Exportar a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, nombreArchivo);

            System.out.println("PDF creado correctamente en: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
   
   
   
   
}
      
      