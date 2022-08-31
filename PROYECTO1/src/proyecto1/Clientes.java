package proyecto1;

import java.io.Serializable;

public class Clientes implements Serializable {
    private int codigo; 
    private String nombre;
    private String nit;
    private String correo;
    private String genero;
        // declaracion de atributos
    
    public Clientes(int codigo, String nombre, String nit, String correo, String genero ){
        this.codigo= codigo;
        this.nombre=nombre;
        this.nit= nit;
        this.correo= correo;
        this.genero=genero;
        
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
