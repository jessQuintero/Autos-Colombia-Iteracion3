package web;

import datos.BitacoraDaoJDBC;
import dominio.Bitacora;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



@WebServlet(urlPatterns = {"/BitacoraServlet"})
public class BitacoraServlet extends HttpServlet {


 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                 

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 //Redirigimos hacia accion por default
  //      this.accionDefault(request, response);
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Bitacora> bitacoras = new BitacoraDaoJDBC().listar();
        System.out.println("bitacoras = " + bitacoras);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("bitacoras", bitacoras);
       request.getRequestDispatcher("bitacora.jsp").forward(request, response);
      // response.sendRedirect("bitacora.jsp");
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
                        this.insertarBitacora(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                    
                  case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;    
                    
                    
                    
                    
                    
                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BitacoraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private void insertarBitacora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
      
        String placa = request.getParameter("placa");
//       Date fecha = Date.valueOf(request.getParameter("fecha"));
        //Time hora = Time.valueOf(request.getParameter("hora"));
        String movimiento = request.getParameter("movimiento");
    //  Integer.parseInt(request.getParameter("cedula"));
        //Creamos el objeto (modelo)
        Bitacora cliente = new Bitacora(placa,movimiento);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new BitacoraDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
      
 
 
}
