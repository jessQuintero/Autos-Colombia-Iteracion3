
package dominio;


public class Vehiculo {
    
 private int id;
    private String placa;
    private String color;
    private String marca;
    private String modelo;
    private String idTipo;
    private int cedulaCliente;
    
    public Vehiculo() {
    }

    public Vehiculo(int id) {
        this.id = id;
    }

    public Vehiculo(int id, String placa, String color, String marca, String modelo, String idTipo, int cedulaCliente) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.idTipo = idTipo;
        this.cedulaCliente = cedulaCliente;
    }
    
        public Vehiculo(int id, String placa, String color, String marca, String modelo, String idTipo) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.idTipo = idTipo;
   
    }

    public Vehiculo(String placa, String color, String marca, String modelo, String idTipo, int cedulaCliente) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.idTipo = idTipo;
        this.cedulaCliente = cedulaCliente;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

   

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    
    
    
    
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", idTipo=" + idTipo +", cedulaCliente=" + cedulaCliente + '}';
    }
    
 

    

}
