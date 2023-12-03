<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="celdas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Celda</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                 <th>ID</th>
                                <th>Ubicacion</th>

                                <th>Piso</th>
                                <th>Tipo de Vahiculo</th>
                              
                                 <th>      </th>
                               

   <th>Acciones</th>
                            </tr>
                            
                            
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista -->
                            <c:forEach var="celda" items="${celdas}" >
                                <tr>
                                    <td>${celda.id}</td>
                                    <td>${celda.ubicacion}</td>
                                    <td>${celda.piso}</td>
                                    <td>${celda.tipo}</td>
                                   
                                    <td>
                                        <a href="${pageContext.request.contextPath}/CeldaServlet?accion=editar&id=${celda.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>

                                    <td>            
                                        <a href="${pageContext.request.contextPath}/CeldaServlet?accion=eliminar&id=${celda.id}"
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
<jsp:include page="/WEB-INF/paginas/celdas/agregarCelda.jsp"/>