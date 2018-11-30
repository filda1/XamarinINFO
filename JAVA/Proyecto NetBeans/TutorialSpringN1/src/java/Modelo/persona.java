

package Modelo;

public class persona {
    
    private int id;
    private String nombre;
    private String correo;
    private String edad;

    public persona() {
        
    }

    public persona(String nombre, String correo, String edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
    
    
    
    
}
