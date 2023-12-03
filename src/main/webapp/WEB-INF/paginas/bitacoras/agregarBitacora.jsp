<div class="modal fade" id="agregarBitacoraModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Bitacora</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/BitacoraServlet?accion=insertar"
                  method="POST" class="was-validated">
                
                
            
                
                
                
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="placa">Placa</label>
                        <input type="text" class="form-control" name="placa" required>
                    </div>
                    
                    <label for="movimiento"> Movimiento</label>
                    <select name="movimiento" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required>
 
  <option value="Salio">Salio</option>
  <option value="Entro">Entro</option>
 
</select>
                     
          
                   
                   
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    