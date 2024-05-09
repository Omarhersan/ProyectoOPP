package frontend;

import backend.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.List;


import frontend.utils.Button;

public class MenuPagosPendientes extends Component {
	private JPanel panelPP;
	private PagosPendientes pagoPendiente = new PagosPendientes();
	List<PPendiente> pendientes = pagoPendiente.lecPendientes();
    
	private JPanel columns;
	
	
	public MenuPagosPendientes(LocalFrame localFrame) {
		int numI = pendientes.size();
		
        panelPP = new JPanel(new GridLayout(numI, 3));
        
        columns = new JPanel(new GridLayout(1,2));
        columns.setBackground(Color.GRAY);
        columns.add(new JLabel("Nombre"));
        columns.add(new JLabel("Deuda"));
        
        panelPP.add(columns, BorderLayout.CENTER);
        
        for (int i = 1; i < numI; i++) {
            JPanel panelP = new JPanel(new GridLayout(1, 3));
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
        }
	}
	    
	public JPanel getPanelInventario() {
		return this.panelPP;
	}
}