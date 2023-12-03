package web;

import datos.CeldaDaoJDBC;
import dominio.Celda;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperPrint;



@WebServlet(urlPatterns = {"/CeldaServlet"})
public class CeldaServlet extends HttpServlet {


 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarCelda(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "eliminar":
                {
                    try {
                        this.eliminarCelda(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Celda> celdas = new CeldaDaoJDBC().listar();
        System.out.println("celdas = " + celdas);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("celdas", celdas);
       
        response.sendRedirect("celdas.jsp");
    }
 
 
 private void modificarCelda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        String ubicacion = request.getParameter("ubicacion");
          String piso = request.getParameter("piso");
        String tipo = request.getParameter("tipo");
      
       
      
        

        //Creamos el objeto (modelo)
        Celda celda = new Celda(id, ubicacion, piso, tipo);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new CeldaDaoJDBC().actualizar(celda);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
 
 private void editarCelda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //
        int id = Integer.parseInt(request.getParameter("id"));
        Celda celda = new CeldaDaoJDBC().encontrar(new Celda(id));
        request.setAttribute("celda", celda);
        String jspEditar = "/WEB-INF/paginas/celdas/editarCelda.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
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
                        this.insertarCelda(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "modificar":
                {
                    try {
                        this.modificarCelda(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                    
                    
                     case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break; 

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CeldaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
 
    
    
    private void insertarCelda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        
        String ubicacion = request.getParameter("ubicacion");
        String piso = request.getParameter("piso");
        String tipo = request.getParameter("tipo");
        
        
        //Creamos el objeto (modelo)
        Celda celda = new Celda(ubicacion, piso, tipo);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new CeldaDaoJDBC().insertar(celda);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    
    
    private void eliminarCelda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
     

        //Creamos el objeto
        Celda celda = new Celda(id);
      
        int registrosModificados = new CeldaDaoJDBC().eliminar(celda);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
}
