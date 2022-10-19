package Interfaces;

import javax.swing.JFrame;

public class ReportesAT {

	public ReportesAT() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		frame.setTitle("REPORTES");
		frame.setVisible(true);
		
	}
}
