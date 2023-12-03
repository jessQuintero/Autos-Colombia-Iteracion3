
package dominio;



public class Celda {

    public Celda(int id, String ubicacion, String piso, String tipo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.piso = piso;
        this.tipo = tipo;
    }
    
        private int id;
        private String ubicacion;
  
          private String piso;
         private String tipo;

 
 
    public Celda() {
    }

    public Celda(int id) {
        this.id = id;
    }

    public Celda(String ubicacion, String piso, String tipo) {
        this.ubicacion = ubicacion;
        this.piso = piso;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    
      @Override
    public String toString(){
        return "\nCelda {"+ "id= "+id+", ubicacion= "+ubicacion+", piso="+piso+", tipo de Vehiculo= "+tipo+"}";
        
        
    }


   
}
