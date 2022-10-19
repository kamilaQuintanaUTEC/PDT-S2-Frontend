package Interfaces;

import javax.swing.JFrame;

public class ListarReclamosE {

	public ListarReclamosE() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		frame.setTitle("LISTAR RECLAMOS");
		frame.setVisible(true);
		
	}
}
