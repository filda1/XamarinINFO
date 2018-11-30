
package Model;

public class vehiculo {
    
    private int id;
    private String placa;
    private String propietario;
    private String entrada;
    private String salida;
    private String tipo;
    private Float pago;
    private String estado;

    public vehiculo(){
    
    }
    public vehiculo(int id, String placa, String propietario, String entrada, String salida, String tipo, String estado) {
        this.id = id;
        this.placa = placa;
        this.propietario = propietario;
        this.entrada = entrada;
        this.salida = salida;
        this.tipo = tipo;
        this.estado = estado;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPago(Float pago) {
        this.pago = pago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSalida() {
        return salida;
    }

    public String getTipo() {
        return tipo;
    }

    public Float getPago() {
        return pago;
    }

    public String getEstado() {
        return estado;
    }
  
    
}
