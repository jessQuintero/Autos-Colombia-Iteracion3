<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Usuario</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/UsuarioServlet?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="cedula">Cedula Ciudadania</label>
                        <input type="number" class="form-control" name="cedula" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" name="correo" placeholder="Escribe el Correo Electrónico"  required>
                    </div>
                    <div class="form-group">
                        <label for="clave">Clave</label>
                        <input type="password" class="form-control" placeholder="Minimo 6 caracter entre Mayuscula, minuscula y numeros" name="clave" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" required>
                    </div>
                   
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    