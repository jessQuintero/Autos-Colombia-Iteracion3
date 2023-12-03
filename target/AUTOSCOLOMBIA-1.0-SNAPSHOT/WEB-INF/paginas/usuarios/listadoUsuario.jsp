<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="usuarios">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Usuarios</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                 <th>Cedula</th>
                                <th>Nombre</th>

                                <th>Apellido</th>
                                <th>Correo</th>
                               
                                 <th>      </th>
                               

   <th>Acciones</th>
                            </tr>
                            
                            
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista -->
                            <c:forEach var="usuario" items="${usuarios}" >
                                <tr>
                                    <td>${usuario.cedula}</td>
                                    <td>${usuario.nombre}</td>
                                    <td>${usuario.apellido}</td>
                                    <td>${usuario.correo}</td>
                                 
                                    <td>
                                        <a href="${pageContext.request.contextPath}/UsuarioServlet?accion=editar&id=${usuario.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>

                                    <td>            
                                        <a href="${pageContext.request.contextPath}/UsuarioServlet?accion=eliminar&id=${usuario.id}"
                                           class="btn btn-danger btn-block">
                                            <i class="fas fa-angle-double-right"></i> Eliminar
                                        </a>

                                    </td>           




                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Agregar MODAL -->
<jsp:include page="/WEB-INF/paginas/usuarios/agregarUsuario.jsp"/>