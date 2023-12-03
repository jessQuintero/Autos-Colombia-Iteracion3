package web;

import datos.VehiculoDaoJDBC;
import dominio.Vehiculo;
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



@WebServlet(urlPatterns = {"/VehiculoServlet"})
public class VehiculoServlet extends HttpServlet {


 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "eliminar":
                {
                    try {
                        this.eliminarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Vehiculo> vehiculos = new VehiculoDaoJDBC().listar();
        System.out.println("vehiculos = " + vehiculos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("vehiculos", vehiculos);
       
        response.sendRedirect("vehiculos.jsp");
    }
 
 
 private void modificarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
        String placa = request.getParameter("placa");
        String color = request.getParameter("color");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
         String tipo =request.getParameter("tipo");
        //   int cedula =Integer.parseInt(request.getParameter("idCedula"));
        

        //Creamos el objeto (modelo)
        Vehiculo vehiculos = new Vehiculo(id,placa, color, marca, modelo,tipo);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new VehiculoDaoJDBC().actualizar(vehiculos);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
 
 private void editarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //
        int id = Integer.parseInt(request.getParameter("id"));
        Vehiculo vehiculos = new VehiculoDaoJDBC().encontrar(new Vehiculo(id));
        request.setAttribute("vehiculo", vehiculos);
        String jspEditar = "/WEB-INF/paginas/vehiculos/editarVehiculo.jsp";
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
                        this.insertarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "modificar":
                {
                    try {
                        this.modificarVehiculo(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                    case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;  
                    
                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private void insertarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        String placa = request.getParameter("placa");
        String color = request.getParameter("color");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String tipo =request.getParameter("tipo");
         int cedula =Integer.parseInt(request.getParameter("idCedula"));
        
        //Creamos el objeto (modelo)
        Vehiculo vehiculos = new Vehiculo(placa, color, marca, modelo, tipo,cedula);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new VehiculoDaoJDBC().insertar(vehiculos);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    
    
    private void eliminarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
     

        //Creamos el objeto
        Vehiculo vehiculos = new Vehiculo(id);
      
        int registrosModificados = new VehiculoDaoJDBC().eliminar(vehiculos);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
}
