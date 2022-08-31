package proyecto1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Allen Román
 */
public class Login extends JFrame implements ActionListener {

    static String nombre = "";
    JButton inicio;
    JTextField ingreso1;
    JPasswordField ingreso2;

    public Login() {
        this.setTitle("Modulo de Autentificación");
        this.setBounds(600, 250, 400, 250);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel pos = new JLabel();
        pos.setText("POS");
        pos.setBounds(200, 25, 25, 25);
        this.add(pos);

        JLabel label1 = new JLabel();
        label1.setText("Código");
        label1.setBounds(50, 60, 75, 25);
        this.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("Contraseña");
        label2.setBounds(50, 110, 75, 25);
        this.add(label2);

        ingreso1 = new JTextField();
        ingreso1.setBounds(150, 60, 200, 25);
        this.add(ingreso1);

        ingreso2 = new JPasswordField();
        ingreso2.setBounds(150, 110, 200, 25);
        this.add(ingreso2);

        inicio = new JButton();
        inicio.setText("Iniciar Sesión");
        inicio.setBounds(150, 160, 200, 25);
        inicio.addActionListener(this);
        this.add(inicio);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == inicio) {
            String usuario = "";
            String contrasenia = "";
            System.out.println("Se presiono el botón");
            contrasenia = ingreso2.getText();
            usuario = ingreso1.getText();

            if (ingreso1.getText().equals("admin") && ingreso2.getText().equals("admin")) {
                System.out.println("User y password correctas");
                this.dispose();
                Admin ventana1 = new Admin();
                ventana1.setVisible(true);
            } else if (usuario.equals("") && contrasenia.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un usuario");
            } else if (PROYECTO1.vendedores != null) {

                int usuario1 = Integer.parseInt(usuario);
                for (int i = 0; i < PROYECTO1.vendedores.length; i++) {
                    if (usuario1 == PROYECTO1.vendedores[i].getCodigo() && contrasenia.equals(PROYECTO1.vendedores[i].getPassword()) && PROYECTO1.vendedores[i] != null) {
                        nombre = PROYECTO1.vendedores[i].getNombre();
                        this.dispose();
                        Ventas ventana1 = new Ventas();
                        ventana1.setVisible(true);
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "asdf");
            }

        }
    }
}
