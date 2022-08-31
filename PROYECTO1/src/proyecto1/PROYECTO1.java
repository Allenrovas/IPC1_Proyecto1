package proyecto1;

import java.io.File;

/**
 * Aplicación de punto de venta (POS)
 *
 * @author Allen Román
 */
public class PROYECTO1 {

    public static Sucursales[] sucursales = new Sucursales[50];
    public static Productos[] productos = new Productos[200];
    public static Clientes[] clientes = new Clientes[100];
    public static Vendedores[] vendedores = new Vendedores[400];

    public static void main(String[] args) {
        if (new File("Vendedores.bin").exists()) {
            PROYECTO1.vendedores = (Vendedores[]) Archivos.deserialize("Vendedores.bin");
        }
        if (new File("Clientes.bin").exists()) {
            PROYECTO1.clientes = (Clientes[]) Archivos.deserialize("Clientes.bin");
        }
        if (new File("Productos.bin").exists()) {
            PROYECTO1.productos = (Productos[]) Archivos.deserialize("Productos.bin");
        }
        if (new File("Sucursales.bin").exists()) {
            PROYECTO1.sucursales = (Sucursales[]) Archivos.deserialize("Sucursales.bin");
        }
        Login ventana = new Login();
        ventana.setVisible(true);
    }

}
