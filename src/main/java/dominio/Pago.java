/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author 
 */
public class Pago {
    private int idPago;
    private String nombre;
    private String apellido;
    private String placa;
    private String tipo;
     private int valorDia;
    private int valorMensual;

    public Pago(int idPago) {
        this.idPago = idPago;
    }

    public Pago(String placa) {
        this.placa = placa;
    }

    
    
    public Pago(String nombre, String apellido, String placa, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.placa = placa;
        this.tipo = tipo;
    }

    
    
    public Pago(int idPago, String nombre, String apellido, String placa, String tipo, int valorDia, int valorMensual) {
        this.idPago = idPago;
        this.nombre = nombre;
        this.apellido = apellido;
        this.placa = placa;
        this.tipo = tipo;
        this.valorDia = valorDia;
        this.valorMensual = valorMensual;
    }

    public Pago(String nombre, String apellido, String placa, String tipo, int valorDia, int valorMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.placa = placa;
        this.tipo = tipo;
        this.valorDia = valorDia;
        this.valorMensual = valorMensual;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValorDia() {
        return valorDia;
    }

    public void setValorDia(int valorDia) {
        this.valorDia = valorDia;
    }

    public int getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(int valorMensual) {
        this.valorMensual = valorMensual;
    }

    
    
        @Override
    public String toString(){
        return "\nPago {"+ "idPago= "+ idPago+", nombre= "+nombre+", apellido="+apellido+", placa="+placa+", tipo=" + tipo + ", valorDia=" + valorDia + ", valorMensual=" + valorMensual +"}";
        
        
    }
   

    
}
    

