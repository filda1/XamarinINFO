
package com.manosenelcodigo.modelos;


public class Persona 
{
    private int id;
    private String nombre;
    private String correo;
    private int pais;

    public Persona() 
    {
        
    }

    public Persona(String nombre, String correo, int pais) {
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
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

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
    
    
}
