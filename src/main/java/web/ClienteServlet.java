package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
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



@WebServlet(urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {


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
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "eliminar":
                {
                    try {
                        this.eliminarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
       
       response.sendRedirect("clientes.jsp");
    }
 
 
 private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
        
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
      
        

        //Creamos el objeto (modelo)
        Cliente cliente = new Cliente(id, cedula, nombre, apellido, direccion, telefono);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
 
 private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(id));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/clientes/editarCliente.jsp";
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
                        this.insertarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "modificar":
                {
                    try {
                        this.modificarCliente(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                    
                     case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break; 

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
      
        //Creamos el objeto (modelo)
        Cliente cliente = new Cliente(cedula, nombre, apellido, direccion,telefono);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
     

        //Creamos el objeto
        Cliente cliente = new Cliente(id);
      
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
}
