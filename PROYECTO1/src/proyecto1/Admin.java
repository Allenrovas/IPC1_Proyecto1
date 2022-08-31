package proyecto1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Admin extends JFrame implements ActionListener {

    JButton crear1;
    JButton crear2;
    JButton crear3;
    JButton crear4;
    JButton carga1;
    JButton carga2;
    JButton carga3;
    JButton carga4;
    JButton actualizar1;
    JButton actualizar2;
    JButton actualizar3;
    JButton actualizar4;
    JButton eliminar1;
    JButton eliminar2;
    JButton eliminar3;
    JButton eliminar4;
    JButton exportar1;
    JButton exportar2;
    JButton exportar3;
    JButton exportar4;
    JButton cerrar;
    static JTextField tabla1;
    static JTextField tabla2;
    static JTextField tabla3;
    static JTextField tabla4;
    static JTextField grafica2;
    static JTextField grafica3;
    static JTextField grafica4;
    JPanel panel1;
    static JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    static JTable tablasucursal;
    static JTable tablaproductos;
    static JTable tablaclientes;
    static JTable tablavendedores;
    static String[] columnas;
    static Object[][] datos;
    static int S;

    public Admin() {

        this.setTitle("Administración");
        this.setBounds(600, 250, 1200, 900);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBounds(0, 80, 1400, 850);
        this.add(pestañas);

        JLabel titulo = new JLabel();
        titulo.setText("Módulo de Administración");
        titulo.setBounds(300, 20, 1000, 50);
        titulo.setFont(new Font("Century Gothic", 1, 50));
        this.add(titulo);

        panel1 = new JPanel();
        panel1.setBackground(new Color(52, 159, 219));
        pestañas.add("Sucursales", panel1);
        panel1.setLayout(null);
        crear1 = new JButton();
        crear1.setText("Crear");
        crear1.setBounds(700, 50, 170, 50);
        crear1.addActionListener(this);
        panel1.add(crear1);
        carga1 = new JButton();
        carga1.setText("Carga Masiva");
        carga1.setBounds(900, 50, 170, 50);
        carga1.addActionListener(this);
        panel1.add(carga1);
        actualizar1 = new JButton();
        actualizar1.setText("Actualizar");
        actualizar1.setBounds(700, 120, 170, 50);

        actualizar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    S = tablasucursal.getSelectedRow();
                    ActualizarSucursal ventana = new ActualizarSucursal();
                    ventana.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione una Sucursal.");
                }
            }
        });
        panel1.add(actualizar1);
        eliminar1 = new JButton();
        eliminar1.setText("Eliminar");
        eliminar1.setBounds(900, 120, 170, 50);
        eliminar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int S = tablasucursal.getSelectedRow();
                    PROYECTO1.sucursales[S] = null;
                    tablasucursal();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione una Sucursal.");
                }
            }
        });
        panel1.add(eliminar1);
        exportar1 = new JButton();
        exportar1.setText("Exportar Listado a PDF");
        exportar1.setBounds(700, 190, 370, 50);
        exportar1.addActionListener(this);
        panel1.add(exportar1);
        tabla1 = new JTextField();
        tabla1.setBounds(50, 50, 550, 675);
        panel1.add(tabla1);

        panel2 = new JPanel();
        panel2.setBackground(new Color(52, 159, 219));
        pestañas.add("Productos", panel2);
        panel2.setLayout(null);
        crear2 = new JButton();
        crear2.setText("Crear");
        crear2.setBounds(700, 50, 170, 50);
        crear2.addActionListener(this);
        panel2.add(crear2);
        carga2 = new JButton();
        carga2.setText("Carga Masiva");
        carga2.setBounds(900, 50, 170, 50);
        carga2.addActionListener(this);
        panel2.add(carga2);
        actualizar2 = new JButton();
        actualizar2.setText("Actualizar");
        actualizar2.setBounds(700, 120, 170, 50);
        actualizar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    S = tablaproductos.getSelectedRow();
                    ActualizarProducto ventana = new ActualizarProducto();
                    ventana.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto.");
                }
            }
        });
        panel2.add(actualizar2);
        eliminar2 = new JButton();
        eliminar2.setText("Eliminar");
        eliminar2.setBounds(900, 120, 170, 50);
        eliminar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int S = tablaproductos.getSelectedRow();
                    PROYECTO1.productos[S] = null;
                    tablaproductos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto.");
                }
                graficaproductos();
            }
        });
        panel2.add(eliminar2);
        exportar2 = new JButton();
        exportar2.setText("Exportar Listado a PDF");
        exportar2.setBounds(700, 190, 370, 50);
        exportar2.addActionListener(this);
        panel2.add(exportar2);
        tabla2 = new JTextField();
        tabla2.setBounds(50, 50, 550, 675);
        panel2.add(tabla2);
        grafica2 = new JTextField();
        grafica2.setBounds(700, 350, 370, 375);
        grafica2.setEditable(false);
        panel2.add(grafica2);

        panel3 = new JPanel();
        panel3.setBackground(new Color(52, 159, 219));
        pestañas.add("Clientes", panel3);
        panel3.setLayout(null);
        crear3 = new JButton();
        crear3.setText("Crear");
        crear3.setBounds(700, 50, 170, 50);
        crear3.addActionListener(this);
        panel3.add(crear3);
        carga3 = new JButton();
        carga3.setText("Carga Masiva");
        carga3.setBounds(900, 50, 170, 50);
        carga3.addActionListener(this);
        panel3.add(carga3);
        actualizar3 = new JButton();
        actualizar3.setText("Actualizar");
        actualizar3.setBounds(700, 120, 170, 50);
        actualizar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    S = tablaclientes.getSelectedRow();
                    ActualizarCliente ventana = new ActualizarCliente();
                    ventana.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Cliente.");
                }
            }
        });
        panel3.add(actualizar3);
        eliminar3 = new JButton();
        eliminar3.setText("Eliminar");
        eliminar3.setBounds(900, 120, 170, 50);
        eliminar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int S = tablaclientes.getSelectedRow();
                    PROYECTO1.clientes[S] = null;
                    tablaclientes();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Cliente.");
                }
            }
        });
        panel3.add(eliminar3);
        exportar3 = new JButton();
        exportar3.setText("Exportar Listado a PDF");
        exportar3.setBounds(700, 190, 370, 50);
        exportar3.addActionListener(this);
        panel3.add(exportar3);
        tabla3 = new JTextField();
        tabla3.setBounds(50, 50, 550, 675);
        panel3.add(tabla3);
        grafica3 = new JTextField();
        grafica3.setBounds(700, 350, 370, 375);
        grafica3.setEditable(false);
        panel3.add(grafica3);

        panel4 = new JPanel();
        panel4.setBackground(new Color(52, 159, 219));
        pestañas.add("Vendedores", panel4);
        panel4.setLayout(null);
        crear4 = new JButton();
        crear4.setText("Crear");
        crear4.setBounds(700, 50, 170, 50);
        crear4.addActionListener(this);
        panel4.add(crear4);
        carga4 = new JButton();
        carga4.setText("Carga Masiva");
        carga4.setBounds(900, 50, 170, 50);
        carga4.addActionListener(this);
        panel4.add(carga4);
        actualizar4 = new JButton();
        actualizar4.setText("Actualizar");
        actualizar4.setBounds(700, 120, 170, 50);
        actualizar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    S = tablavendedores.getSelectedRow();
                    ActualizarVendedor ventana = new ActualizarVendedor();
                    ventana.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Vendedor.");
                }
            }
        });
        panel4.add(actualizar4);
        eliminar4 = new JButton();
        eliminar4.setText("Eliminar");
        eliminar4.setBounds(900, 120, 170, 50);
        eliminar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int S = tablavendedores.getSelectedRow();
                    PROYECTO1.vendedores[S] = null;
                    tablavendedores();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un Vendedor.");
                }
            }
        });
        panel4.add(eliminar4);
        exportar4 = new JButton();
        exportar4.setText("Exportar Listado a PDF");
        exportar4.setBounds(700, 190, 370, 50);
        exportar4.addActionListener(this);
        panel4.add(exportar4);
        tabla4 = new JTextField();
        tabla4.setBounds(50, 50, 550, 675);
        panel4.add(tabla4);
        grafica4 = new JTextField();
        grafica4.setBounds(700, 350, 370, 375);
        grafica4.setEditable(false);
        panel4.add(grafica4);

        cerrar = new JButton();
        cerrar.setText("Cerrar Sesión");
        cerrar.setBounds(1025, 0, 150, 25);
        cerrar.addActionListener(this);
        cerrar.setBackground(new Color(255, 0, 0));
        this.add(cerrar);

        tablasucursal();
        tablaproductos();
        tablaclientes();
        tablavendedores();

    }

    public static void tablasucursal() {
        tabla1.removeAll();
        String[] columnas = {"Codigo", "Nombre", "Dirección", "Correo", "Teléfono"};
        Object[][] datos = new Object[50][5];

        for (int i = 0; i < PROYECTO1.sucursales.length; i++) {
            if (PROYECTO1.sucursales[i] != null) {

                datos[i][0] = PROYECTO1.sucursales[i].getCodigo();
                datos[i][1] = PROYECTO1.sucursales[i].getNombre();
                datos[i][2] = PROYECTO1.sucursales[i].getDireccion();
                datos[i][3] = PROYECTO1.sucursales[i].getCorreo();
                datos[i][4] = PROYECTO1.sucursales[i].getTelefono();

            }

        }
        tablasucursal = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablasucursal);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla1.add(scroll);
    }

    public static void tablaproductos() {
        tabla2.removeAll();
        System.out.println("Si remueve");
        String[] columnas = {"Codigo", "Nombre", "Descripcion", "Cantidad", "Precio"};
        Object[][] datos = new Object[200][5];

        for (int i = 0; i < PROYECTO1.productos.length; i++) {
            if (PROYECTO1.productos[i] != null) {

                datos[i][0] = PROYECTO1.productos[i].getCodigo();
                datos[i][1] = PROYECTO1.productos[i].getNombre();
                datos[i][2] = PROYECTO1.productos[i].getDescripcion();
                datos[i][3] = PROYECTO1.productos[i].getCantidad();
                datos[i][4] = PROYECTO1.productos[i].getPrecio();

            }

        }
        tablaproductos = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablaproductos);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla2.add(scroll);
    }

    public static void tablaclientes() {
        tabla3.removeAll();
        String[] columnas = {"Código", "Nombre", "NIT", "Correo", "Género"};
        Object[][] datos = new Object[100][5];

        for (int i = 0; i < PROYECTO1.clientes.length; i++) {
            if (PROYECTO1.clientes[i] != null) {

                datos[i][0] = PROYECTO1.clientes[i].getCodigo();
                datos[i][1] = PROYECTO1.clientes[i].getNombre();
                datos[i][2] = PROYECTO1.clientes[i].getNit();
                datos[i][3] = PROYECTO1.clientes[i].getCorreo();
                datos[i][4] = PROYECTO1.clientes[i].getGenero();

            }

        }
        tablaclientes = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablaclientes);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla3.add(scroll);
    }

    public static void tablavendedores() {
        tabla4.removeAll();
        String[] columnas = {"Código", "Nombre", "Caja", "Ventas", "Género", "Contraseña"};
        Object[][] datos = new Object[400][6];

        for (int i = 0; i < PROYECTO1.vendedores.length; i++) {
            if (PROYECTO1.vendedores[i] != null) {

                datos[i][0] = PROYECTO1.vendedores[i].getCodigo();
                datos[i][1] = PROYECTO1.vendedores[i].getNombre();
                datos[i][2] = PROYECTO1.vendedores[i].getCaja();
                datos[i][3] = PROYECTO1.vendedores[i].getVentas();
                datos[i][4] = PROYECTO1.vendedores[i].getGenero();
                datos[i][5] = PROYECTO1.vendedores[i].getPassword();

            }

        }
        tablavendedores = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablavendedores);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla4.add(scroll);
    }

    public static void graficaproductos() {
        grafica2.removeAll();
        DefaultCategoryDataset barras = new DefaultCategoryDataset();
        int i = 0;
        for (int j = 0; j < PROYECTO1.productos.length; j++) {
            if (PROYECTO1.productos[j] != null) {
                barras.setValue(PROYECTO1.productos[j].getCantidad(), PROYECTO1.productos[j].getNombre(), PROYECTO1.productos[j].getNombre());
                i = j + 1;
                break;
            }
        }

        for (int j = i; j < PROYECTO1.productos.length; j++) {
            if (PROYECTO1.productos[j] != null) {
                barras.setValue(PROYECTO1.productos[j].getCantidad(), PROYECTO1.productos[j].getNombre(), PROYECTO1.productos[j].getNombre());
                i = j + 1;
                break;
            }
        }

        for (int j = i; j < PROYECTO1.productos.length; j++) {
            if (PROYECTO1.productos[j] != null) {
                barras.setValue(PROYECTO1.productos[j].getCantidad(), PROYECTO1.productos[j].getNombre(), PROYECTO1.productos[j].getNombre());
                break;
            }
        }

        JFreeChart barra1 = ChartFactory.createBarChart3D("Top 3 - Productos con más disponibilidad", "Producto", "Cantidad", barras, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel barra2 = new ChartPanel(barra1);

        barra2.setBounds(0, 0, 370, 375);
        grafica2.add(barra2);

    }

    public static void graficavendedores() {
        grafica4.removeAll();
        DefaultCategoryDataset barras = new DefaultCategoryDataset();
        int i = 0;
        for (int j = 0; j < PROYECTO1.vendedores.length; j++) {
            if (PROYECTO1.vendedores[j] != null) {
                barras.setValue(PROYECTO1.vendedores[j].getVentas(), PROYECTO1.vendedores[j].getNombre(), PROYECTO1.vendedores[j].getNombre());
                i = j + 1;
                break;
            }
        }
        for (int j = i; j < PROYECTO1.vendedores.length; j++) {
            if (PROYECTO1.vendedores[j] != null) {
                barras.setValue(PROYECTO1.vendedores[j].getVentas(), PROYECTO1.vendedores[j].getNombre(), PROYECTO1.vendedores[j].getNombre());
                i = j + 1;
                break;
            }
        }
        for (int j = i; j < PROYECTO1.vendedores.length; j++) {
            if (PROYECTO1.vendedores[j] != null) {
                barras.setValue(PROYECTO1.vendedores[j].getVentas(), PROYECTO1.vendedores[j].getNombre(), PROYECTO1.vendedores[j].getNombre());
                break;
            }
        }
        JFreeChart barra1 = ChartFactory.createBarChart3D("Top 3 - Vendedores con más ventas", "Vendedor", "Ventas", barras, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel barra2 = new ChartPanel(barra1);
        barra2.setBounds(0, 0, 370, 375);
        grafica4.add(barra2);
    }

    public static void graficaclientes() {
        grafica3.removeAll();
        DefaultPieDataset datasetPie = new DefaultPieDataset();
        int hombre = 0;
        int mujer = 0;

        for (int i = 0; i < PROYECTO1.clientes.length; i++) {
            if (PROYECTO1.clientes[i] != null) {
                if (PROYECTO1.clientes[i].getGenero().equals("f")) {
                    mujer++;
                }
            }
        }

        for (int i = 0; i < PROYECTO1.clientes.length; i++) {
            if (PROYECTO1.clientes[i] != null) {
                if (PROYECTO1.clientes[i].getGenero().equals("m")) {
                    hombre++;
                }
            }
        }

        datasetPie.setValue("Femenino", new Integer(mujer));
        datasetPie.setValue("Masculino", new Integer(hombre));

        JFreeChart Pie = ChartFactory.createPieChart3D("Género de vendedores", datasetPie, true, true, false);
        ChartPanel pie1 = new ChartPanel(Pie);

        pie1.setBounds(0, 0, 370, 375);
        grafica3.add(pie1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cerrar) {
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
            Archivos.serialize("Vendedores.bin", PROYECTO1.vendedores);
            Archivos.serialize("Clientes.bin", PROYECTO1.clientes);
            Archivos.serialize("Productos.bin", PROYECTO1.productos);
            Archivos.serialize("Sucursales.bin", PROYECTO1.sucursales);
        }

        if (ae.getSource() == carga1) {
            JFileChooser elegir = new JFileChooser();
            elegir.showOpenDialog(this);
            File archivo = elegir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            Archivos.CargarSucursales(ruta);
            tablasucursal();
        }
        if (ae.getSource() == exportar1) {
            System.out.println("hola");
            Archivos.utilJTablePrint(tablasucursal, "Sucursales", "", rootPaneCheckingEnabled);
        }
        if (ae.getSource() == crear1) {
            CrearSucursal ventana = new CrearSucursal();
            ventana.setVisible(true);
            tablasucursal();
        }

        if (ae.getSource() == carga2) {
            JFileChooser elegir = new JFileChooser();
            elegir.showOpenDialog(this);
            File archivo = elegir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            Archivos.CargarProductos(ruta);
            Archivos.BurbujaDesc1(PROYECTO1.productos);
            tablaproductos();
            graficaproductos();

        }
        if (ae.getSource() == exportar2) {
            System.out.println("hola1");
            Archivos.utilJTablePrint(tablaproductos, "Productos", "", rootPaneCheckingEnabled);
        }
        if (ae.getSource() == crear2) {
            CrearProductos ventana = new CrearProductos();
            ventana.setVisible(true);
            tablaproductos();
            graficaproductos();
        }

        if (ae.getSource() == carga3) {
            JFileChooser elegir = new JFileChooser();
            elegir.showOpenDialog(this);
            File archivo = elegir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            Archivos.CargarClientes(ruta);
            tablaclientes();
            graficaclientes();
        }
        if (ae.getSource() == exportar3) {
            System.out.println("hola");
            Archivos.utilJTablePrint(tablaclientes, "Clientes", "", rootPaneCheckingEnabled);
        }
        if (ae.getSource() == crear3) {
            CrearClientes ventana = new CrearClientes();
            ventana.setVisible(true);
            tablaclientes();
            graficaclientes();
        }

        if (ae.getSource() == carga4) {
            JFileChooser elegir = new JFileChooser();
            elegir.showOpenDialog(this);
            File archivo = elegir.getSelectedFile();
            String ruta = archivo.getAbsolutePath();
            Archivos.CargarVendedores(ruta);
            Archivos.BurbujaDesc2(PROYECTO1.vendedores);
            tablavendedores();
            graficavendedores();
        }
        if (ae.getSource() == exportar4) {
            System.out.println("hola");
            Archivos.utilJTablePrint(tablavendedores, "Vendedores", "", rootPaneCheckingEnabled);
        }
        if (ae.getSource() == crear4) {
            CrearVendedores ventana = new CrearVendedores();
            ventana.setVisible(true);
            tablavendedores();
        }

    }

}
