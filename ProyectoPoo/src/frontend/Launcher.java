package frontend;

import java.awt.Frame;

import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				localFrame frame = new localFrame();
				frame.show();
				
			}
			
		});

	}

}
