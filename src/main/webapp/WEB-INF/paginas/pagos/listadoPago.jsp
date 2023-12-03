<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="celdas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Pago</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                
                                <th>Nombre</th>

                                <th>Apellido</th>
                                <th>Placa de Vehiculo</th>
                               <th>Tipo de Vehiculo</th>
                                 <th>      </th>
                               

   <th>Acciones</th>
                            </tr>
                            
                            
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista -->
                            <c:forEach var="pago" items="${pagos}" >
                                <tr>
                                    <td>${pago.nombre}</td>
                                    <td>${pago.apellido}</td>
                                    <td>${pago.placa}</td>
                                    <td>${pago.tipo}</td>
                                   <td></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/PagoServlet?accion=editar&placa=${pago.placa}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Generar Pago
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
<jsp:include page="/WEB-INF/paginas/pagos/agregarPago.jsp"/>