package frontend;
import frontend.utils.*;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.*;


public class test {

	public static void main(String[] args) {
		
		Button b1 = new Button("Prueba");
		JButton boton = b1.getButton();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(500,200);
		frame.setVisible(true);
		
		
		panel.add(boton);
		frame.add(panel, BorderLayout.CENTER);
	}

}
