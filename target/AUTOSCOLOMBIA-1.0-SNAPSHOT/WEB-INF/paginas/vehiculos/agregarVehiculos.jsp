<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal fade" id="agregarVehiculoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Vehiculo</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/VehiculoServlet?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nit">PLACA</label>
                        <input type="text" class="form-control" name="placa" minlength="6" maxlength="6" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Color</label>
                        <input type="text" class="form-control" name="color" required>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Marca</label>
                        <input type="text" class="form-control" name="marca" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Modelo</label>
                        <input type="number" class="form-control" name="modelo" required>
                    </div>
                  
                    
                    <div class="form-group">
                     <label for="tipo">Tipo Vehiculo</label>
                    <select name="tipo" class="form-control" required>
 
                    <option value="1">Carro</option>
                    <option value="2">Moto</option>

                  </select>
                                      
                </div>
                    
                      <div class="form-group">
               
                     <label for="labelCedula">Cedula del Propietarios</label>
                    
                     <select name="idCedula" class="form-control" required>
                    <option>Escoge nombre</option>
                    <c:forEach var="cliente" items="${clientes}" >
                    <option value="${cliente.cedula}">${cliente.nombre}</option>
                    
 </c:forEach>
                  </select>
                   
                                      
                </div>
                    
                    
                    
                    
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    