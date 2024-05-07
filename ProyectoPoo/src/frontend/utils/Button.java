package frontend.utils;
import javax.swing.JButton;

import java.awt.*;



public class Button extends JButton{
	private String name;
	private JButton button;

			
	public Button(String name) {
		this.name = name;
		button = createButton();
	}
	public JButton createButton() {
		JButton button = new JButton(name);
		button.setSize(300,80);
		button.setFont(new Font("Arial", Font.BOLD, 14)); 
		button.setBackground(Color.BLACK); 
		button.setForeground(Color.WHITE);
		return button;
	}
	
	public String getName() {
		return this.name;
	}
	public JButton getButton() {
		return this.button;
	}
	
}