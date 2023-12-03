package web;

import datos.UsuarioDaoJDBC;
import dominio.Usuario;
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



@WebServlet(urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {


 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarUsuario(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                    
                
                    

                case "eliminar":
                {
                    try {
                        this.eliminarUsuario(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
 
 private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Usuario> usuarios = new UsuarioDaoJDBC().listar();
        System.out.println("usuarios = " + usuarios);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarios", usuarios);
       
        response.sendRedirect("usuarios.jsp");
    }
 
 
 
 
  
  private void verificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
      
       //recuperamos los valores del formulario 
    
           
       
      int cedula = Integer.parseInt(request.getParameter("cedula"));
      String clave = request.getParameter("clave");
      
       System.out.println("Datos enviados = " + cedula+" "+clave);
      
        Usuario usuario = new UsuarioDaoJDBC().iniciarSesion(cedula,clave);
            
        if (usuario == null) {
			request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
            
                        HttpSession sesion = request.getSession();
			sesion.setAttribute("sesion", usuario);
            
			response.sendRedirect("principal.jsp");
		}

                
    }
 
 
 
  
  
 
 private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
        
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
      //  clave=EncoderByMd5(clave);
        

        //Creamos el objeto (modelo)
        Usuario usuarios = new Usuario(id, cedula, nombre, apellido, correo, clave);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new UsuarioDaoJDBC().actualizar(usuarios);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
 
 private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuarios = new UsuarioDaoJDBC().encontrar(new Usuario(id));
        request.setAttribute("usuario", usuarios);
        String jspEditar = "/WEB-INF/paginas/usuarios/editarUsuario.jsp";
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
                        this.insertarUsuario(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                
                case "modificar":
                {
                    try {
                        this.modificarUsuario(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "listar":
                {
                    try {
                     this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;         
                    
                   
                case "ingresar":
                {
                    try {
                        this.verificar(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;       
                        
                    
                default:
                {
                    try {
                        this.accionDefault(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            try {
                this.accionDefault(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
      
        //Creamos el objeto (modelo)
        Usuario usuarios = new Usuario(cedula, nombre, apellido, correo,clave);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new UsuarioDaoJDBC().insertar(usuarios);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    
    
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //recuperamos los valores del formulario 
        int id = Integer.parseInt(request.getParameter("id"));
     

        //Creamos el objeto
        Usuario usuarios = new Usuario(id);
      
        int registrosModificados = new UsuarioDaoJDBC().eliminar(usuarios);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
 
 
 
}
