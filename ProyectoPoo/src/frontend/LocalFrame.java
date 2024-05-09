package frontend;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;


public class LocalFrame extends JFrame {
	private JPanel encabezadoPanel;
	private JPanel ingresoDeDatosPanel;
	private JFrame window;
	private LogInWindow main;
	private MenuWindow menu;
	
	public LocalFrame() {
		runMain();
	}
	public void runMain() {
		// Log In Window
		main = new LogInWindow(this);
		
		window = new JFrame();
		window.setTitle("InVent");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500, 300);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout(5, 1));
					
		window.add(main.getEncabezadoPanel(), BorderLayout.NORTH);
		window.add(main.getIngresoDeDatosPanel(), BorderLayout.CENTER);
		window.add(main.getPanelBotonIngreso(), BorderLayout.SOUTH);
		
	}
	
	public void runMenu(LocalFrame this, MenuWindow menu) {
		//this.window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		window = new JFrame();
		window.setTitle("InVent-Menú");
        window.setSize(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(5, 1));
        
        window.add(menu.getPanelMenu(), BorderLayout.CENTER);
        this.show();
        
	}
	
	public void runInventario(LocalFrame this, MenuInventarioWindow menuInventario) {
		//this.window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		window = new JFrame();
		window.setTitle("InVent-Inventario");
        window.setSize(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(5, 1));
        //this.show();
        
    
        window.add(menuInventario.getPanelInventario(), BorderLayout.CENTER);
        
        this.show();
	}
	
	public void runVenta(MenuVenta menuVenta) {
		window = new JFrame();
		window.setTitle("InVent-Venta");
        window.setSize(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(5, 1));
        
        window.add(menuVenta.getPanelVenta(), BorderLayout.CENTER);
        window.add(menuVenta.getPanelBotonVenta(), BorderLayout.SOUTH);
        this.show();

	}
		
		
		
		
		
		
	
	
	public void show() {
		window.setVisible(true);
	}
	
}
