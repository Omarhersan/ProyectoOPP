package frontend;
import frontend.utils.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import backend.Inventario;
import backend.Usuarios;



public class Inte extends JFrame{
    private static JLabel encabezado;
    private static JLabel etiquetaID;
    private static JTextField campoTextoID;
    private static JLabel etiquetaContra;
    private static JTextField campoTextoContra;

    
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

        //Boton_Inicial
        JButton botonIngreso = new Button("Ingresar").getButton();
        botonIngreso.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botonIngreso) {
		            if ((LogIn(campoTextoID, campoTextoContra)) == true){
		            	// Falta implementar el siguiente panel

		            }
		            else{
		                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
		                campoTextoID.setText("");
		                campoTextoContra.setText("");
		            }
				}
				}

        });

        //
        JPanel panelCompleto = new JPanel(new GridLayout(5, 1));
        panelCompleto.add(encabezado);
        panelCompleto.add(panelID);
        panelCompleto.add(panelContra);
        panelCompleto.add(botonIngreso, BorderLayout.SOUTH);
        
        // Añadir componentes al marco
        this.add(panelCompleto);
    }

    public static void main(String[] args) {
        Inte frame = new Inte();
        frame.setVisible(true);
    }
    

    //Esto no sé que es, pero me lo genero para poder usar el metodo LogIn aqui arriba
    private boolean LogIn(JTextField campoTextoID2, JTextField campoTextoContra2) {
    	
    	try {
    		if(users.LogIn(campoTextoID2, campoTextoContra2))
    			return true;
    		else
    			return false;
		}
		catch(Exception e){
			e.getStackTrace();
			System.out.println("Incorrecto");
			return false;
		}
           	
        
    }
}