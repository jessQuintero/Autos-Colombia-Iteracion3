<div class="modal fade" id="agregarCeldaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Celda</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/CeldaServlet?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="ubicacion">Ubicacion</label>
                        <input type="text" class="form-control" name="ubicacion" minlength="3" maxlength="3" required>
                   
                        
                   <div class="form-group">
                     <label for="piso">Piso</label>
                    <select name="piso" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required>
 
                    <option value="Primer Piso">Primer Piso</option>
                    <option value="Segundo Piso">Segundo Piso</option>

                  </select>
                     
                    </div>         
                        
                    
                     <div class="form-group">
                     <label for="tipo">Tipo Vehiculo</label>
                    <select name="tipo" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required>
 
                    <option value="Carro">Carro</option>
                    <option value="Moto">Moto</option>

                  </select>
                     
                 </div>    
                   
                   
                </div>
                   
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    