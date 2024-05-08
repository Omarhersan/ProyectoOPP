package frontend;
import backend.Usuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import frontend.utils.Button;

public class LogInWindow extends Component {
	private JPanel encabezadoPanel;
	private JPanel ingresoDeDatosPanel;
	private JPanel panelBotonIngreso;
	
	private static JLabel encabezado;
	private static JLabel etiquetaID;
	private static JLabel etiquetaContraseña;
	
	private static JTextField campoTextoID;
	private static JTextField campoTextoContraseña;
	
	private boolean logedIn = false;
	private MenuWindow menu;
	
	HashMap<String, Usuarios> users = new Usuarios().getUsers();
	
	public LogInWindow(LocalFrame localFrame) {	
		encabezadoPanel = new JPanel();
		ingresoDeDatosPanel = new JPanel();
		panelBotonIngreso = new JPanel();
		panelBotonIngreso.setLayout(new BorderLayout(100,0));
		
		encabezado = new JLabel("Inventario");
		encabezado.setFont(new Font("Poor Richard", Font.BOLD, 24));
	    encabezado.setHorizontalAlignment(SwingConstants.CENTER);
		
	    // Ingreso de datos
		etiquetaID = new JLabel("Ingresa tu ID");
		etiquetaID.setFont(new Font("Arial", Font.BOLD, 16));
	
	    campoTextoID = new JTextField(20);
	    campoTextoID.setFont(new Font("Arial", Font.PLAIN, 14));  
	    
	    etiquetaContraseña = new JLabel("Ingresa tu contraseña:");
	    etiquetaContraseña.setFont(new Font("Arial", Font.BOLD, 16));
	
	    campoTextoContraseña = new JTextField(20);
	    campoTextoContraseña.setFont(new Font("Arial", Font.PLAIN, 14));
	    
		
		//Boton_Inicial
        JButton botonIngreso = new Button("Ingresar").getButton();
        botonIngreso.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		
				if (e.getSource() == botonIngreso) {
		            if ((LogIn(campoTextoID, campoTextoContraseña)) == true){
		            	// Falta implementar el siguiente panel
		            	logedIn = true;
		            	menu = new MenuWindow();
		            	localFrame.runMenu(menu);

		            }
		            else{
		                JOptionPane.showMessageDialog(null, "Acceso Incorrecto", "Incorrecto", JOptionPane.WARNING_MESSAGE);
		                campoTextoID.setText("");
		                campoTextoContraseña.setText("");
		            }
				}
				}

        });

		encabezadoPanel.add(encabezado);
		ingresoDeDatosPanel.add(etiquetaID);
		ingresoDeDatosPanel.add(campoTextoID);
		ingresoDeDatosPanel.add(etiquetaContraseña);
		ingresoDeDatosPanel.add(campoTextoContraseña);
		panelBotonIngreso.add(botonIngreso);
		
		
	}
	public JPanel getEncabezadoPanel() {
		return this.encabezadoPanel;
	}
	public JPanel getIngresoDeDatosPanel() {
		return this.ingresoDeDatosPanel;
	}
	public JPanel getPanelBotonIngreso() {
		return this.panelBotonIngreso;
	}
	
	private boolean LogIn(JTextField campoTextoID2, JTextField campoTextoContra2) {
    	try {
    		if(users.get(campoTextoID2.getText()).LogIn(campoTextoID2, campoTextoContra2))
    			return true;
    		else
    			return false;
		}
		catch(Exception e){
			e.getStackTrace();
			return false;
		}
           	
        
    }
	public boolean getLogedIn() {
		return this.logedIn;
	}
	public MenuWindow getMenu() {
		return this.menu;
	}
}
