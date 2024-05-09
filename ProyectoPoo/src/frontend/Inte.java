package frontend;
<<<<<<< HEAD
=======
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


package frontend;
>>>>>>> 0e74d2ace6b2db76da4cc1a8dc41286042290edb

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;

public class Inte extends JFrame implements ActionListener {
    private static JLabel encabezado;
    private static JLabel etiquetaID;
    private static JTextField campoTextoID;
    private static JLabel etiquetaContra;
    private static JTextField campoTextoContra;
    private JButton boton;

    private static JLabel encabezadoM;
    private JButton inventario;
    private JButton venta;
    private JButton pagosP;
    private JButton corte;

    
    private static JLabel[] objs;

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


    public void Menu() {
        this.setTitle("InVent-Menú");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        encabezadoM = new JLabel("MENÚ");
        encabezadoM.setFont(new Font("Poor Richard", Font.BOLD, 24));
        encabezadoM.setHorizontalAlignment(SwingConstants.CENTER);

        inventario = new JButton("Inventario");
        inventario.setSize(100, 80);
        inventario.setFont(new Font("Arial", Font.BOLD, 14)); 
        inventario.setBackground(Color.BLACK); 
        inventario.setForeground(Color.WHITE);

        venta = new JButton("Venta");
        venta.setSize(100, 80);
        venta.setFont(new Font("Arial", Font.BOLD, 14)); 
        venta.setBackground(Color.BLACK); 
        venta.setForeground(Color.WHITE);

        pagosP = new JButton("Pagos Pendientes");
        pagosP.setSize(100, 80);
        pagosP.setFont(new Font("Arial", Font.BOLD, 14)); 
        pagosP.setBackground(Color.BLACK); 
        pagosP.setForeground(Color.WHITE);

        corte = new JButton("Corte");
        corte.setSize(100, 80);
        corte.setFont(new Font("Arial", Font.BOLD, 14)); 
        corte.setBackground(Color.BLACK); 
        corte.setForeground(Color.WHITE);

        JPanel panelM = new JPanel();
        panelM.setLayout(new BoxLayout(panelM, BoxLayout.Y_AXIS));
        panelM.add(encabezadoM);
        panelM.add(inventario);
        panelM.add(venta);
        panelM.add(pagosP);
        panelM.add(corte);

        this.add(panelM);
    }

    public void Inventario(HashMap<Integer, Producto> items) {

        this.setTitle("InVent-Inventario");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        int numI = items.size();
        JPanel panelObj = new JPanel(new GridLayout(numI, 3));
        for (int i = 0; i < numI; i++) {
            JPanel itemP = new JPanel(new GridLayout(1, 3));
            Producto producto = items.get(i); // Obtener el producto en la posición i

            String nP = producto.getNombreProducto();;
            JLabel productN = new JLabel(nP);
            productN.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productN);

            String pC = String.valueOf(producto.getCantidadEnInventario());;
            JLabel productC = new JLabel(pC);
            productC.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productC);

            String pP = String.valueOf(producto.getCantidadEnInventario());;
            JLabel productP = new JLabel(pP);
            productP.setFont(new Font("Arial", Font.BOLD, 16));
            itemP.add(productP);
    
            panelObj.add(itemP);
        }
        this.add(panelObj);
    }
    public static void main(String[] args) {
        Inte frame = new Inte();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            if ((LogIn(campoTextoID, campoTextoContra)) == true){
                Menu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
                campoTextoID.setText("");
                campoTextoContra.setText("");
            }
            if (e.getSource() == inventario) {
                String filePath = "C:/Users/omara/eclipse-workspace/ProyectoPoo/src/backend/Data/Productos.csv";
                HashMap<Integer, Producto> items = parseCSV(filePath);
                Inventario(items);
            }
            if (e.getSource() == venta) {
                
            }
            if (e.getSource() == pagosP) {

            }
            if (e.getSource() == corte) {

            }
        }
        // PARA LOS BOTONES
    }

    private HashMap<Integer, Producto> parseCSV(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseCSV'");
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