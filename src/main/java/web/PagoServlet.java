package web;

import datos.PagoDaoJDBC;
import dominio.Pago;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.DD;
import net.sf.jasperreports.engine.JRException;
import static org.apache.pdfbox.cos.COSName.LL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.eclipse.jdt.internal.compiler.batch.Main;


@WebServlet(urlPatterns = {"/PagoServlet"})
public class PagoServlet extends HttpServlet {


 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                    
                 case "reportar":
                {
                    try {
                        this.generarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JRException ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                    break;    

                case "eliminar":
                {
                    try {
                        this.eliminarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Pago> pagos = new PagoDaoJDBC().listar();
        System.out.println("pagos = " + pagos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pagos", pagos);
       
       response.sendRedirect("pagos.jsp");
    }
 
 
  
 
 
 private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //
        String placa = request.getParameter("placa");
        Pago pago = new PagoDaoJDBC().encontrar(new Pago(placa));
        request.setAttribute("pago", pago);
        String jspEditar = "/WEB-INF/paginas/pagos/editarPago.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
 
 
 
 private void generarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, JRException, SQLException {
      
     
     
      try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 32);
            contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
            contentStream.showText("Hello World!");
            contentStream.endText();

           
            contentStream.close();

            document.save("C:/reportes/document.pdf");
            System.out.println("Documento generado Exitosamente");
        }
     
     
     
             
                    
 }
 
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                {
                    try {
                        this.insertarCliente(request, response);
                        //  this.generarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                    break;

              case "buscar":
                {
                    try {
                        this.verificar(request, response);
                       
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                    
                     case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break; 
                 

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        
    
    private void verificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
      Pago pago=null;
       //recuperamos los valores del campo de texto 
           
      String placa = request.getParameter("placa");
      
      if(placa!=null){
            System.out.println("Dato Placa = " + placa);
            List<Pago> pagos = new PagoDaoJDBC().listarPlaca(placa);
            
              if(pagos!=null){
             System.out.println("pagos = " + pagos);
             HttpSession sesion = request.getSession();
        sesion.setAttribute("pagos", pagos);
         response.sendRedirect("pagos.jsp");
              }
            
          
       
     
      }
           
      else if (pago == null) {
			request.setAttribute("mensaje", "Error Placa no existe o encontrada");
			request.getRequestDispatcher("pagos.jsp").forward(request, response);
		} else {
            
                  
			response.sendRedirect("pagos.jsp");
		}

                
    }
 
 
    
    
    
    
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, JRException {
       
       String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String placa = request.getParameter("placa");
        String tipo = request.getParameter("tipo");
        int valorDia = Integer.parseInt(request.getParameter("valorHora"));
        int ValorMensual = Integer.parseInt(request.getParameter("pago"));
      
        //Creamos el objeto (modelo)
        Pago pago = new Pago(nombre, apellido,placa, tipo,valorDia,ValorMensual);

  
  
        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new PagoDaoJDBC().insertar(pago);
      //  new PagoDaoJDBC().reporteVehiculo();
        System.out.println("registrosModificados = " + registrosModificados);

              try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A5);
            
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 8);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 580);
            //  contentStream.setLeading(15);
            contentStream.showText("Cliente: "+ nombre+" " +apellido);
             contentStream.newLine();
            contentStream.showText("Placa: "+ placa);
             contentStream.newLine();
               contentStream.showText("Tipo de vehiculo: "+ tipo);
               contentStream.newLine();
              contentStream.showText("Valor Dia: 5.000 pesos"); 
              contentStream.newLine(); 
               contentStream.showText("Costo Total X 30 dias: 150.000 pesos");
               contentStream.newLine(); 
            contentStream.endText();
            contentStream.close();
     
        Calendar calendario = Calendar.getInstance();

        // Obtener el mes actual
        int mesActual = calendario.get(Calendar.MONTH) + 1; // Sumar 1 porque los meses comienzan desde 0
        int segundo = calendario.get(Calendar.SECOND)+1;
        // Imprimir el mes actual
      //  System.out.println("Mes actual: " + mesActual);    
          
          File directorio = new File("C:/reportes/");
            if (!directorio.exists()) {
                directorio.mkdirs(); // crea los directorios necesarios
            }
      
       document.save("C:/reportes/"+placa+"_"+mesActual+"_"+segundo+".pdf");
            System.out.println("Documento generado Exitosamente");
            
        }
        
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("placa"));
     

        //Creamos el objeto
        Pago pago = new Pago(id);
      
        int registrosModificados = new PagoDaoJDBC().eliminar(pago);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
}
