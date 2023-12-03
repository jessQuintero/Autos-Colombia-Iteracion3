<%-- 
    Document   : index.jsp
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        
        
        
             
        <title>Pagina de Login</title>
    </head>
    <body>
       
        
           <form action="${pageContext.request.contextPath}/UsuarioServlet?accion=ingresar"
              method="POST" class="was-validated">
		<input type="hidden" name="tipo" value="iniciarSesion" />

          

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Bienvenido al Sistema Login </h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="cedula">Cedula</label>
                                        <input type="number" class="form-control" name="cedula" required>
                                    </div>
                                   
                                    <div class="form-group">
                                        <label for="clave">Clave</label>
                                        <input type="password" class="form-control" name="clave" required ">
                                    </div>
                                    
                                    <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Ingresar</button>
                </div> 
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                                    
                           <div>
		<h5>
				<%
					String resultado = (String)request.getAttribute("mensaje");
					String mensaje = "";
					if (resultado != null) {
						mensaje = resultado;
					}
				%>
				<%=mensaje 
                                   //  swal("Hello world!");
                                
                                %>
                               
			</h5>
                   
		</div>                
                                    
                                    
                                    
                </div>
                                
            </section>
                                    
                                    

        </form>

        <!--Pie de Pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

        
        
        
       
        
        
        
       