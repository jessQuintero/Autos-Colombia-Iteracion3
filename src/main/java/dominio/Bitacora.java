
package dominio;

import java.sql.Date;
import java.sql.Time;


public class Bitacora {
    
 private int id;
  private String placa;
    private Date fecha;
    private Time hora;
    private String movimiento;

    public Bitacora() {
    }

    public Bitacora(int id, String placa, Date fecha, String movimiento) {
        this.id = id;
        this.placa = placa;
        this.fecha = fecha;
        this.movimiento = movimiento;
    }

    
    
    public Bitacora(int id, String placa, Date fecha, String movimiento,Time hora) {
        this.id = id;
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
        this.movimiento = movimiento;
    }

    public Bitacora(String placa, Date fecha, Time hora, String movimiento) {
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
        this.movimiento = movimiento;
    }
      public Bitacora(String placa,String movimiento ) {
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
        this.movimiento = movimiento;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    
   
    
      @Override
    public String toString(){
        return "\nBitacoras {"+ "id= "+id+", placa= "+placa+", fecha="+fecha+", hora= "+hora+", movimiento= "+movimiento+"}";
        
        
    }


   
}
