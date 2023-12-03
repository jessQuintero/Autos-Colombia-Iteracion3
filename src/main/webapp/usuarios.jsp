<%-- 
    Document   : usuarios.jsp
    
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

        
       
        
        
        
        <title>Control de Usuarios</title>
    </head>
    <body>
      

      

        <!--Cabecero-->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        
        <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>
                    <i class="fas fa-cog"></i> Modulo de Usuarios</h1>
            </div>
        </div>
    </div>
        

        <!--Botones de Agregar-->
     <section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="#" class="btn btn-primary btn-block"
                   data-toggle="modal" data-target="#agregarUsuarioModal">
                    <i class="fas fa-plus"></i> Agregar Usuario
                </a>
            </div>
        </div>
    </div>
</section>

        <!--Listado Usuarios -->
        <jsp:include page="WEB-INF/paginas/usuarios/listadoUsuario.jsp"/>

        <!--Pie de Pagina-->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        
        
        
    </body>
</html>
