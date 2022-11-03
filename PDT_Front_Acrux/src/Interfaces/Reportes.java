package Interfaces;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Reportes {

	public Reportes() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 250, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton verBtn = new JButton("VER ESCOLARIDAD");
		verBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    			    File path = new File (".\\escolaridad.pdf");
    			    Desktop.getDesktop().open(path);
    			}catch (IOException ex) {
    			    ex.printStackTrace();
    			    JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
    			}
    		}
        });
		verBtn.setBounds(15, 15, 150, 20);
		frame.getContentPane().add(verBtn);
		
		frame.setTitle("REPORTES");
		frame.setVisible(true);
		
	}
}
