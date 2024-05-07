package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;


public class localFrame {
	private JPanel encabezadoPanel;
	private JPanel ingresoDeDatosPanel;
	private JFrame window;
	private LogInWindow main;
	
	public localFrame() {
		// Log In Window
		window = new JFrame();
		window.setTitle("InVent");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500, 300);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout(5, 1));
		
		main = new LogInWindow();
		
		window.add(main.getEncabezadoPanel(), BorderLayout.NORTH);
		window.add(main.getIngresoDeDatosPanel(), BorderLayout.CENTER);
		window.add(main.getPanelBotonIngreso(), BorderLayout.SOUTH);
		
		
	}
	
	public void show() {
		window.setVisible(true);
	}
	
}
