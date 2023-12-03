<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="bitacoras">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Bitacora</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                 <th>Placa</th>
                                <th>Movimiento</th>

                                <th>Fecha</th>
                                  <th>Hora</th>
                                 <th>      </th>
                               

  
                            </tr>
                            
                            
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista -->
                            <c:forEach var="bitacora" items="${bitacoras}" >
                                <tr>
                                    <td>${bitacora.placa}</td>
                                    <td>${bitacora.movimiento}</td>
                                    <td>${bitacora.fecha}</td>
                                     <td>${bitacora.hora}</td>


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
<jsp:include page="/WEB-INF/paginas/bitacoras/agregarBitacora.jsp"/>