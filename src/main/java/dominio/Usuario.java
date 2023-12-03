
package dominio;


public class Usuario {
    
    
    
    public Usuario() {
       
     
    }

    public Usuario(int id, int cedula, String nombre, String apellido, String correo, String clave) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    
    
    
 private int id;
  private int cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;

    
       public Usuario(int id) {
        this.id = id;
     
    }

    
    public Usuario(int cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

    public Usuario(int cedula, String nombre, String apellido, String correo, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    

   
    
      @Override
    public String toString(){
        return "\nUsuario {"+ "id= "+id+", cedula= "+cedula+", nombre="+nombre+", apellido= "+apellido+", correo= "+correo+"clave= "+clave+"}";
        
        
    }


   
}
