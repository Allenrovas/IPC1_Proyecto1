package proyecto1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.print.PrinterException;
import java.io.*;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Archivos {

    public static void CargarSucursales(String ruta) {
        String content = getContentOfFile(ruta);

        JsonParser parser = new JsonParser();
        JsonArray arreglo = parser.parse(content).getAsJsonArray();
        int contador = 0;
        do {
            for (int i = 0; i < arreglo.size(); i++) {
                contador += 1;
                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                String direccion = objeto.get("direccion").getAsString();
                String correo = objeto.get("correo").getAsString();
                int telefono = objeto.get("telefono").getAsInt();

                Sucursales nuevo = new Sucursales(codigo, nombre, direccion, correo, telefono);

                PROYECTO1.sucursales[i] = nuevo;
            }
        } while (contador <= 50);
    }

    public static void CargarProductos(String ruta) {
        String content = getContentOfFile(ruta);

        JsonParser parser = new JsonParser();
        JsonArray arreglo = parser.parse(content).getAsJsonArray();
        int contador = 0;
        do {
            for (int i = 0; i < arreglo.size(); i++) {
                contador += 1;
                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                String descripcion = objeto.get("descripcion").getAsString();
                int cantidad = objeto.get("cantidad").getAsInt();
                double precio = objeto.get("precio").getAsDouble();

                Productos nuevo = new Productos(codigo, nombre, descripcion, cantidad, precio);

                PROYECTO1.productos[i] = nuevo;
            }
        } while (contador <= 200);
    }

    public static void CargarClientes(String ruta) {
        String content = getContentOfFile(ruta);

        JsonParser parser = new JsonParser();
        JsonArray arreglo = parser.parse(content).getAsJsonArray();
        int contador = 0;
        do {
            for (int i = 0; i < arreglo.size(); i++) {
                contador += 1;
                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                String nit = objeto.get("nit").getAsString();
                String correo = objeto.get("correo").getAsString();
                String genero = objeto.get("genero").getAsString();

                Clientes nuevo = new Clientes(codigo, nombre, nit, correo, genero);
                PROYECTO1.clientes[i] = nuevo;

            }
        } while (contador <= 100);
    }

    public static void CargarVendedores(String ruta) {
        String content = getContentOfFile(ruta);

        JsonParser parser = new JsonParser();
        JsonArray arreglo = parser.parse(content).getAsJsonArray();
        int contador = 0;
        do {
            for (int i = 0; i < arreglo.size(); i++) {
                contador += 1;
                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                int caja = objeto.get("caja").getAsInt();
                int ventas = objeto.get("ventas").getAsInt();
                String genero = objeto.get("genero").getAsString();
                String password = objeto.get("password").getAsString();

                Vendedores nuevo = new Vendedores(codigo, nombre, caja, ventas, genero, password);
                PROYECTO1.vendedores[i] = nuevo;
            }
        } while (contador <= 400);
    }

    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (FileNotFoundException fnfe) {
            System.err.println("No se encontró el archivo. Inténtelo de nuevo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog) {
        boolean fitWidth = true;
        boolean interactive = true;
        // (Definimos el modo de impresión)
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            // Print the table (Imprimo la tabla)             
            boolean complete = jTable.print(mode,
                    new MessageFormat(header),
                    new MessageFormat(footer),
                    showPrintDialog,
                    null,
                    interactive);
            if (complete) {
                // Mostramos el mensaje de impresión existosa
                JOptionPane.showMessageDialog(jTable,
                        "Print complete (Impresión completa)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostramos un mensaje indicando que la impresión fue cancelada                 
                JOptionPane.showMessageDialog(jTable,
                        "Print canceled (Impresión cancelada)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(jTable,
                    "Print fail (Fallo de impresión): " + pe.getMessage(),
                    "Print result (Resultado de la impresión)",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void serialize(String pathname, Object object) {
        // Serializar un objeto
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathname));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String pathname) {
        // Leer un objeto serializado
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            Object data = objectInputStream.readObject();
            objectInputStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void BurbujaDesc1(Productos[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                n++;
            }
        }
        Productos temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].getCantidad() < arr[j].getCantidad() && arr[j].getCantidad() != 0 && arr[j - 1].getCantidad() != 0) { //Solo se realiza el cambio de signo
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void BurbujaDesc2(Vendedores[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                n++;
            }
        }
        Vendedores temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].getVentas() < arr[j].getVentas() && arr[j].getVentas() != 0 && arr[j - 1].getVentas() != 0) { //Solo se realiza el cambio de signo
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
