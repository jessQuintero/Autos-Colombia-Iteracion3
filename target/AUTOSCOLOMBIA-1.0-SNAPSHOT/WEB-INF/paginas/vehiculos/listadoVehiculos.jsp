<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="vehiculos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Vehiculos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                 <th>ID</th>
                                <th>Placa</th>

                                <th>Color</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                 <th>Tipo de Vehiculo </th>
                                  <th>Cedula </th>
                                  <th>  </th>

   <th>Acciones</th>
                            </tr>
                            
                            
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista -->
                            <c:forEach var="vehiculo" items="${vehiculos}" >
                                <tr>
                                    <td>${vehiculo.id}</td>
                                    <td>${vehiculo.placa}</td>
                                    <td>${vehiculo.color}</td>
                                    <td>${vehiculo.marca}</td>
                                    <td>${vehiculo.modelo}</td>
                                     <td>${vehiculo.idTipo}</td>
                                      <td>${vehiculo.cedulaCliente}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/VehiculoServlet?accion=editar&id=${vehiculo.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>

                                    <td>            
                                        <a href="${pageContext.request.contextPath}/VehiculoServlet?accion=eliminar&id=${vehiculo.id}"
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
<jsp:include page="/WEB-INF/paginas/vehiculos/agregarVehiculos.jsp"/>