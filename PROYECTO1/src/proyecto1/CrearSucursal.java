package proyecto1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CrearSucursal extends JFrame implements ActionListener{
    
    JTextField ingreso1; JTextField ingreso2; JTextField ingreso3;  JTextField ingreso4; JTextField ingreso5;
    JButton agregar;
    
    public CrearSucursal(){
        this.setTitle("Crear Sucursal");
        this.setBounds(600,250,400,400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);
        
        JLabel titulo = new JLabel();
        titulo.setText("Crear Nueva Sucursal");
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
        label3.setText("Dirección");
        label3.setBounds(50, 160, 75, 25);
        this.add(label3);
        
        JLabel label4 = new JLabel();
        label4.setText("Correo");
        label4.setBounds(50, 210, 75, 25);
        this.add(label4);
        
        JLabel label5 = new JLabel();
        label5.setText("Telefono");
        label5.setBounds(50, 260, 75, 25);
        this.add(label5);
        
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
        
        agregar = new JButton();
        agregar.setBounds(150, 310, 200, 25);
        agregar.setText("Agregar");
        agregar.addActionListener(this);
        this.add(agregar);
 
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==agregar){

          for (int i = 0; i < PROYECTO1.sucursales.length; i++) {
              if(PROYECTO1.sucursales[i]==null){
                int codigo = 0;
                int telefono = 0;
                String codigo1 = ingreso1.getText();
                codigo = Integer.parseInt(codigo1);
                String nombre = ingreso2.getText();
                String direccion = ingreso3.getText();
                String correo = ingreso4.getText();
                String telefono1 = ingreso5.getText();
                telefono = Integer.parseInt(telefono1);

                Sucursales nuevo = new Sucursales(codigo, nombre, direccion, correo, telefono);

                PROYECTO1.sucursales[i] = nuevo;
                break;
                   }
            }
            this.dispose();
            Admin.tablasucursal();
        }
    }
    
}
