package proyecto1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarProducto extends JFrame implements ActionListener {

    JTextField ingreso1;
    JTextField ingreso2;
    JTextField ingreso3;
    JTextField ingreso4;
    JTextField ingreso5;
    JButton agregar;

    public ActualizarProducto() {
        this.setTitle("Actualizar Productos");
        this.setBounds(600, 250, 400, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel titulo = new JLabel();
        titulo.setText("Actualizar Producto");
        titulo.setBounds(125, 25, 150, 25);
        this.add(titulo);

        JLabel label1 = new JLabel();
        label1.setText("Código");
        label1.setBounds(50, 60, 75, 25);
        this.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("Nombre");
        label2.setBounds(50, 110, 75, 25);
        this.add(label2);

        JLabel label3 = new JLabel();
        label3.setText("Descripción");
        label3.setBounds(50, 160, 75, 25);
        this.add(label3);

        JLabel label4 = new JLabel();
        label4.setText("Cantidad");
        label4.setBounds(50, 210, 75, 25);
        this.add(label4);

        JLabel label5 = new JLabel();
        label5.setText("Precio");
        label5.setBounds(50, 260, 75, 25);
        this.add(label5);

        ingreso1 = new JTextField();
        ingreso1.setBounds(150, 60, 200, 25);
        this.add(ingreso1);

        ingreso2 = new JTextField();
        ingreso2.setBounds(150, 110, 200, 25);
        this.add(ingreso2);

        ingreso3 = new JTextField();
        ingreso3.setBounds(150, 160, 200, 25);
        this.add(ingreso3);

        ingreso4 = new JTextField();
        ingreso4.setBounds(150, 210, 200, 25);
        this.add(ingreso4);

        ingreso5 = new JTextField();
        ingreso5.setBounds(150, 260, 200, 25);
        this.add(ingreso5);

        agregar = new JButton();
        agregar.setBounds(150, 310, 200, 25);
        agregar.setText("Actualizar");
        agregar.addActionListener(this);
        this.add(agregar);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == agregar) {
            int codigo = 0;
            double precio = 0;
            int cantidad = 0;
            String codigo1 = ingreso1.getText();
            codigo = Integer.parseInt(codigo1);
            String nombre = ingreso2.getText();
            String descripcion = ingreso3.getText();
            String cantidad1 = ingreso4.getText();
            cantidad = Integer.parseInt(cantidad1);
            String precio1 = ingreso5.getText();
            precio = Double.parseDouble(precio1);

            Productos nuevo = new Productos(codigo, nombre, descripcion, cantidad, precio);

            PROYECTO1.productos[Admin.S] = nuevo;
            this.dispose();
            Archivos.BurbujaDesc1(PROYECTO1.productos);
            Admin.tablaproductos();
            Admin.graficaproductos();
        }

    }

}
