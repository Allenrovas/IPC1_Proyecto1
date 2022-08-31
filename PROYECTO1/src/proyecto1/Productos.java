package proyecto1;

import java.io.Serializable;

public class Productos implements Serializable {
    private int codigo; 
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
        // declaracion de atributos
    
    public Productos(int codigo, String nombre, String descripcion, int cantidad, double precio){
        this.codigo= codigo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.precio=precio;
        
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

    public void setNombre(String nombreproducto) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
