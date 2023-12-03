<%-- 
    Document   : pagos.jsp
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`






<%-- 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

  
       
             
   
             
        
        
        
        <title>Pagos</title>
    </head>
    <body>
      

  
        <!--Cabecero-->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        
        <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>
                    <i class="fas fa-cog"></i> Modulo de Pagos</h1>
            </div>
        </div>
    </div>
        
 <div class="container">
        <div class="row">
            <div class="col-md-6">
             
         <form action="${pageContext.request.contextPath}/PagoServlet?accion=buscar"
              method="POST" class="was-validated">
             
         <div class="input-group">
  <div class="form-outline" data-mdb-input-init>
    <input id="search-input" type="search" id="form1" class="form-control"  name="placa" minlength="6" maxlength="6" required/>
   
  </div>
  <button id="search-button" type="submit" class="btn btn-primary">
    <i class="fas fa-search"></i>
  </button>
</div>
             
  <td>
                                     
                       
          
              </form>
       
                     </div>
        </div>
    </div>


        <!--Listado Pagos -->
        <jsp:include page="WEB-INF/paginas/pagos/listadoPago.jsp"/>

        <!--Pie de Pagina-->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        
        
        
    </body>
</html>
