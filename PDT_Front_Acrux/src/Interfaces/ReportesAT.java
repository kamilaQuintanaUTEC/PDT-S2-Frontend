package Interfaces;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Clases.Estado;
import Clases.Usuario;
import Controladores.ControladorListarReclamosA;
import Controladores.ControladorListarUsuarios;

public class ReportesAT {

	public ReportesAT() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        LinkedList<Usuario> usuarios = ControladorListarUsuarios.getUsuarios();
        int y = 15;
        for (Usuario usuario : usuarios) {
        	JLabel usuarioLabel = new JLabel(usuario.getPrimerNombre() + " " + usuario.getPrimerApellido());
        	usuarioLabel.setBounds(15, y, 110, 20);
            frame.getContentPane().add(usuarioLabel);
            JButton verBtn = new JButton("VER ESCOLARIDAD");
    		verBtn.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
        			     File path = new File ("escolaridad.pdf");
        			     Desktop.getDesktop().open(path);
        			}catch (IOException ex) {
        			     ex.printStackTrace();
        			     JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        			}
        		}
            });
    		verBtn.setBounds(130, y, 130, 20);
    		y += 25;
        };
		
		frame.setTitle("REPORTES");
		frame.setVisible(true);
		
	}
}
