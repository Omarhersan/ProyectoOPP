package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Inte extends JFrame implements ActionListener {
    private static JLabel encabezado;
    private static JLabel etiquetaID;
    private static JTextField campoTextoID;
    private static JLabel etiquetaContra;
    private static JTextField campoTextoContra;
    private JButton boton;
    
    // Variables globales del backend
    Inventario inv = new Inventario();
    Usuarios users = new Usuarios();
    public Inte() {
    	// Inicializar el backend
    
    	
    	
    	
        
        this.setTitle("InVent");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Encabezado
        encabezado = new JLabel("INVENTARIO");
        encabezado.setFont(new Font("Poor Richard", Font.BOLD, 24));
        encabezado.setHorizontalAlignment(SwingConstants.CENTER);

        //ID
        etiquetaID = new JLabel("Ingresa tu ID:");
        etiquetaID.setFont(new Font("Arial", Font.BOLD, 16));

        campoTextoID = new JTextField(20);
        campoTextoID.setFont(new Font("Arial", Font.PLAIN, 14));      
        
        //JPanel panelID = new JPanel(new GridLayout(1, 2));
        JPanel panelID = new JPanel(new FlowLayout());
        panelID.add(etiquetaID);
        panelID.add(campoTextoID);

        // Contraseña

        etiquetaContra = new JLabel("Ingresa tu contraseña:");
        etiquetaContra.setFont(new Font("Arial", Font.BOLD, 16));

        campoTextoContra = new JTextField(20);
        campoTextoContra.setFont(new Font("Arial", Font.PLAIN, 14));

        //JPanel panelContra = new JPanel(new GridLayout(1, 2));
        JPanel panelContra = new JPanel(new FlowLayout());
        panelContra.add(etiquetaContra);
        panelContra.add(campoTextoContra);

        //Boton
        boton = new JButton("Ingresar");
        boton.setSize(300, 80);
        boton.setFont(new Font("Arial", Font.BOLD, 14)); 
        boton.setBackground(Color.BLACK); 
        boton.setForeground(Color.WHITE);

        //
        JPanel panelCompleto = new JPanel(new GridLayout(5, 1));
        panelCompleto.add(encabezado);
        panelCompleto.add(panelID);
        panelCompleto.add(panelContra);
        panelCompleto.add(boton);
        
        // Añadir componentes al marco
        this.add(panelCompleto);
    }

    public static void main(String[] args) {
        Inte frame = new Inte();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            if ((LogIn(campoTextoID, campoTextoContra)) == true){

            }
            else{
                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
                campoTextoID.setText("");
                campoTextoContra.setText("");
            }
        }
        // PARA LOS BOTONES
    }

    //Esto no sé que es, pero me lo genero para poder usar el metodo LogIn aqui arriba
    private boolean LogIn(JTextField campoTextoID2, JTextField campoTextoContra2) {
    	try {
			users.LogIn(campoTextoID2, campoTextoContra2);
			System.out.println("Correcto");
			return true;
		}
		catch(Exception e){
			e.getStackTrace();
			System.out.println("Incorrecto");
			return false;
		}
           	
        
    }
}