package frontend;

import backend.*;
import frontend.utils.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.List;


import frontend.utils.Button;

public class MenuPagosPendientes extends Component {
	private JPanel panelPP;
	private PagosPendientes pagoPendiente = new PagosPendientes();
	List<PPendiente> pendientes = pagoPendiente.lecPendientes();
	private JPanel panelColumnasPendientes;
	private JPanel panelBotonPagarPendiente;
    
	private JPanel columns;
	
	
	public MenuPagosPendientes(LocalFrame localFrame) {
		int numI = pendientes.size();
		
        panelPP = new JPanel(new GridLayout(numI+1, 2));
        panelBotonPagarPendiente = new JPanel(new FlowLayout());
        //panelColumnasPendientes = new JPanel(new BorderLayout());
        
        columns = new JPanel(new GridLayout(1,2));
        columns.setBackground(Color.GRAY);
        columns.add(new JLabel("Nombre"));
        columns.add(new JLabel("Deuda"));
        
        //panelColumnasPendientes.add(columns);
        panelPP.add(columns);
        
        
        for (int i = 0; i < numI; i++) {
            JPanel panelP = new JPanel(new GridLayout(1, 2));
            PPendiente persona = pendientes.get(i); // Obtener el producto en la posición i

            String nP = persona.getNombre();;
            JLabel personaN = new JLabel(nP);
            personaN.setFont(new Font("Arial", Font.BOLD, 16));
            panelP.add(personaN);

            String pD = String.valueOf(persona.getDeuda());;
            JLabel personaC = new JLabel(pD);
            personaC.setFont(new Font("Arial", Font.BOLD, 16));
            panelP.add(personaC);
            
    
            panelPP.add(panelP, BorderLayout.CENTER);
        JButton botonPagar = new Button("Pagar").getButton();
        botonPagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String Nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre a anotar:");
				double pago = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad a pagar:")); 
				PagosPendientes pagoPendiente = new PagosPendientes();
				List<PPendiente> pendientes = pagoPendiente.lecPendientes();
				pagoPendiente.actualizarMenosDeuda(Nombre, pago);
				pagoPendiente.sobrescribirCSV();
				
				
			}
        	
        });
        
        panelBotonPagarPendiente.add(botonPagar);
        }
	}
	    
	public JPanel getPanelPendientes() {
		return this.panelPP;
	}
	public JPanel getPanelBotonPagoPendiente() {
		return this.panelBotonPagarPendiente;
	}
	
	
	
}