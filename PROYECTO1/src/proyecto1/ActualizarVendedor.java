package proyecto1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarVendedor extends JFrame implements ActionListener{
 JTextField ingreso1; JTextField ingreso2; JTextField ingreso3;  JTextField ingreso4; JTextField ingreso5; JTextField ingreso6;
    JButton agregar;
    
    public ActualizarVendedor(){
        this.setTitle("Crear Vendedores");
        this.setBounds(600,250,400,450);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);
        
        JLabel titulo = new JLabel();
        titulo.setText("Crear Nuevo Vendedor");
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
        label3.setText("Caja");
        label3.setBounds(50, 160, 75, 25);
        this.add(label3);
        
        JLabel label4 = new JLabel();
        label4.setText("Ventas");
        label4.setBounds(50, 210, 75, 25);
        this.add(label4);
        
        JLabel label5 = new JLabel();
        label5.setText("Genero");
        label5.setBounds(50, 260, 75, 25);
        this.add(label5);
        
        JLabel label6 = new JLabel();
        label6.setText("Contraseña");
        label6.setBounds(50, 310, 75, 25);
        this.add(label6);
        
        ingreso1 = new JTextField();
        ingreso1.setBounds(150,60,200,25);
        this.add(ingreso1);
        
        ingreso2 = new JTextField();
        ingreso2.setBounds(150,110,200,25);
        this.add(ingreso2);
        
        ingreso3 = new JTextField();
        ingreso3.setBounds(150,160,200,25);
        this.add(ingreso3);
        
        ingreso4 = new JTextField();
        ingreso4.setBounds(150,210,200,25);
        this.add(ingreso4);
        
        ingreso5 = new JTextField();
        ingreso5.setBounds(150,260,200,25);
        this.add(ingreso5);
        
        ingreso6 = new JTextField();
        ingreso6.setBounds(150,310,200,25);
        this.add(ingreso6);
        
        agregar = new JButton();
        agregar.setBounds(150, 360, 200, 25);
        agregar.setText("Agregar");
        agregar.addActionListener(this);
        this.add(agregar);
 
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        int codigo = 0;
                int caja = 0;
                int ventas;
                String codigo1 = ingreso1.getText();
                codigo = Integer.parseInt(codigo1);
                String nombre = ingreso2.getText();
                String caja1 = ingreso3.getText();
                caja = Integer.parseInt(caja1);
                String ventas1 = ingreso4.getText();
                ventas = Integer.parseInt(ventas1);
                String genero = ingreso5.getText();
                String password = ingreso6.getText();

                Vendedores nuevo = new Vendedores(codigo, nombre, caja, ventas, genero, password);

                PROYECTO1.vendedores[Admin.S] = nuevo;
                
            this.dispose();
            Admin.tablavendedores();
    }
    
}
