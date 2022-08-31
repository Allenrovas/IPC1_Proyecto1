package proyecto1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventas extends JFrame implements ActionListener {

    JPanel panel1;
    JPanel panel2;
    JButton filtro;
    JButton crear;
    JButton agregar;
    JButton vender;
    JButton filtro1;
    JButton visualizar;
    JButton cerrar;
    JTextField nombre1;
    JTextField nit1;
    JTextField correo1;
    JTextField genero1;
    JTextField codigo1;
    JTextField cantidad1;
    JTextField total1;
    static JTextField tabla5;
    static JTable tablaventas1;
    int total2;
    JTextField factura1;
    JTextField nit3;
    JTextField nombre3;
    JTextField genero3;
    static JTextField tabla6;

    public Ventas() {
        //tablaventas1();
        this.setTitle("Ventas");
        this.setBounds(600, 250, 1200, 900);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBounds(0, 80, 1200, 850);
        this.add(pestañas);

        JLabel titulo = new JLabel();
        titulo.setText("Módulo de Ventas");
        titulo.setBounds(300, 20, 1000, 50);
        titulo.setFont(new Font("Century Gothic", 1, 50));
        this.add(titulo);

        JLabel bienvenida = new JLabel();
        bienvenida.setText("¡Bienvenid@ " + Login.nombre + "!");
        bienvenida.setBounds(800, 0, 225, 25);
        this.add(bienvenida);

        panel1 = new JPanel();
        panel1.setBackground(new Color(52, 159, 219));
        pestañas.add("Nueva Venta", panel1);
        panel1.setLayout(null);
        JTextField cuadro1 = new JTextField();
        cuadro1.setBounds(50, 50, 900, 250);
        cuadro1.setEditable(false);
        panel1.add(cuadro1);
        JTextField seleccionar = new JTextField();
        seleccionar.setBounds(0, 0, 135, 25);
        seleccionar.setEditable(false);
        seleccionar.setText("Seleccionar Cliente");
        cuadro1.add(seleccionar);
        JLabel filtrar = new JLabel();
        filtrar.setBounds(60, 40, 75, 25);
        filtrar.setText("Filtrar por:");
        cuadro1.add(filtrar);
        JLabel nombre = new JLabel();
        nombre.setBounds(145, 40, 75, 25);
        nombre.setText("Nombre");
        cuadro1.add(nombre);
        nombre1 = new JTextField();
        nombre1.setBounds(230, 40, 200, 25);
        cuadro1.add(nombre1);
        JLabel nit = new JLabel();
        nit.setBounds(450, 40, 75, 25);
        nit.setText("NIT");
        cuadro1.add(nit);
        nit1 = new JTextField();
        nit1.setBounds(535, 40, 200, 25);
        cuadro1.add(nit1);
        JLabel correo = new JLabel();
        correo.setBounds(145, 80, 75, 25);
        correo.setText("Correo");
        cuadro1.add(correo);
        correo1 = new JTextField();
        correo1.setBounds(230, 80, 200, 25);
        cuadro1.add(correo1);
        JLabel genero = new JLabel();
        genero.setBounds(450, 80, 75, 25);
        genero.setText("Genero");
        cuadro1.add(genero);
        genero1 = new JTextField();
        genero1.setBounds(535, 80, 200, 25);
        cuadro1.add(genero1);
        filtro = new JButton();
        filtro.setText("Aplicar Filtro");
        filtro.setBounds(230, 120, 505, 25);
        filtro.addActionListener(this);
        cuadro1.add(filtro);
        JLabel filtrados = new JLabel();
        filtrados.setBounds(60, 160, 75, 25);
        filtrados.setText("Filtrados:");
        cuadro1.add(filtrados);
        JLabel cliente = new JLabel();
        cliente.setBounds(145, 160, 75, 25);
        cliente.setText("Cliente");
        cuadro1.add(cliente);
        JComboBox cliente1 = new JComboBox();
        cliente1.setBounds(230, 160, 295, 25);
        cuadro1.add(cliente1);
        cliente1.add(cliente);

        crear = new JButton();
        crear.setText("Nuevo Cliente");
        crear.setBounds(540, 160, 185, 25);
        crear.addActionListener(this);
        cuadro1.add(crear);

        JTextField cuadro2 = new JTextField();
        cuadro2.setBounds(50, 350, 900, 350);
        cuadro2.setEditable(false);
        panel1.add(cuadro2);
        JTextField producto = new JTextField();
        producto.setBounds(0, 0, 135, 25);
        producto.setEditable(false);
        producto.setText("Agregar Productos");
        cuadro2.add(producto);
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy ").format(Calendar.getInstance().getTime());
        JLabel fecha1 = new JLabel();
        fecha1.setText("Fecha: " + timeStamp);
        fecha1.setBounds(450, 0, 225, 25);
        cuadro2.add(fecha1);
        Random dado1 = new Random();
        int dado = (int) (dado1.nextInt(10000) + 1);
        JLabel no = new JLabel();
        no.setText("No.: " + dado);
        no.setBounds(800, 0, 225, 25);
        cuadro2.add(no);
        JLabel codigo = new JLabel();
        codigo.setBounds(60, 40, 75, 25);
        codigo.setText("Código");
        cuadro2.add(codigo);
        codigo1 = new JTextField();
        codigo1.setBounds(150, 40, 200, 25);
        cuadro2.add(codigo1);
        JLabel cantidad = new JLabel();
        cantidad.setBounds(375, 40, 75, 25);
        cantidad.setText("Cantidad");
        cuadro2.add(cantidad);
        cantidad1 = new JTextField();
        cantidad1.setBounds(440, 40, 200, 25);
        cuadro2.add(cantidad1);
        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(675, 40, 185, 25);
        agregar.addActionListener(this);
        cuadro2.add(agregar);
        tabla5 = new JTextField();
        tabla5.setBounds(60, 100, 800, 150);
        cuadro2.add(tabla5);
        vender = new JButton();
        vender.setText("Vender");
        vender.setBounds(60, 275, 450, 25);
        vender.setBackground(new Color(130, 224, 170));
        vender.addActionListener(this);
        cuadro2.add(vender);
        JLabel total = new JLabel();
        total.setText("Total");
        total.setBounds(575, 275, 75, 25);
        cuadro2.add(total);
        total1 = new JTextField();
        total1.setBounds(675, 275, 175, 25);
        total1.setEditable(false);
        total1.setText("");
        cuadro2.add(total1);

        panel2 = new JPanel();
        panel2.setBackground(new Color(52, 159, 219));
        pestañas.add("Ventas", panel2);
        panel2.setLayout(null);
        JTextField cuadro3 = new JTextField();
        cuadro3.setBounds(50, 50, 900, 700);
        cuadro3.setEditable(false);
        panel2.add(cuadro3);
        JTextField listado = new JTextField();
        listado.setBounds(0, 0, 135, 25);
        listado.setEditable(false);
        listado.setText("Listado General");
        cuadro3.add(listado);
        JLabel filtrar2 = new JLabel();
        filtrar2.setBounds(60, 40, 75, 25);
        filtrar2.setText("Filtrar por:");
        cuadro3.add(filtrar2);
        JLabel factura = new JLabel();
        factura.setBounds(145, 40, 75, 25);
        factura.setText("No. Factura");
        cuadro3.add(factura);
        factura1 = new JTextField();
        factura1.setBounds(230, 40, 200, 25);
        cuadro3.add(factura1);
        JLabel nit2 = new JLabel();
        nit2.setBounds(450, 40, 75, 25);
        nit2.setText("NIT");
        cuadro3.add(nit2);
        nit3 = new JTextField();
        nit3.setBounds(535, 40, 200, 25);
        cuadro3.add(nit3);
        JLabel nombre2 = new JLabel();
        nombre2.setBounds(145, 80, 75, 25);
        nombre2.setText("Nombre");
        cuadro3.add(nombre2);
        nombre3 = new JTextField();
        nombre3.setBounds(230, 80, 200, 25);
        cuadro3.add(nombre3);
        JLabel genero2 = new JLabel();
        genero2.setBounds(450, 80, 75, 25);
        genero2.setText("Genero");
        cuadro3.add(genero2);
        genero3 = new JTextField();
        genero3.setBounds(535, 80, 200, 25);
        cuadro3.add(genero3);
        filtro1 = new JButton();
        filtro1.setText("Aplicar Filtro");
        filtro1.setBounds(230, 120, 505, 25);
        filtro1.addActionListener(this);
        cuadro3.add(filtro1);
        JLabel filtrados1 = new JLabel();
        filtrados1.setBounds(60, 160, 75, 25);
        filtrados1.setText("Filtrados:");
        cuadro3.add(filtrados1);
        tabla6 = new JTextField();
        tabla6.setBounds(60, 200, 750, 450);
        cuadro3.add(tabla6);

        cerrar = new JButton();
        cerrar.setText("Cerrar Sesión");
        cerrar.setBounds(1025, 0, 150, 25);
        cerrar.addActionListener(this);
        cerrar.setBackground(new Color(255, 0, 0));
        this.add(cerrar);
    }

    public static void tablaventas1() {
        tabla5.removeAll();
        String[] columnas = {"Código", "Nombre", "Cantidad", "Precio", "Subtotal"};
        Object[][] datos = new Object[200][5];

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
        tablaventas1 = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablaventas1);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla5.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cerrar) {
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
            Archivos.serialize("Clientes.bin", PROYECTO1.clientes);
        }
        if (ae.getSource() == crear) {
            CrearClientes ventana = new CrearClientes();
            ventana.setVisible(true);

        }
        if (ae.getSource() == filtro) {
            CrearClientes ventana = new CrearClientes();
            ventana.setVisible(true);

        }
    }

}
