package Interfaces;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.naming.NamingException;
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
		frame.setBounds(50, 100, 1100, 900);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        LinkedList<Usuario> usuarios;
		try {
			usuarios = ControladorListarUsuarios.getUsuarios();
			int y = 15;
	        for (Usuario usuario : usuarios) {
	        	if(usuario.getTipoDeUsuario().equals("ESTUDIANTE")) {
	        		
		        	JLabel usuarioLabel = new JLabel(usuario.getPrimerNombre() + " " + usuario.getPrimerApellido());
		        	usuarioLabel.setBounds(15, y, 210, 20);
		            frame.getContentPane().add(usuarioLabel);
		            JButton verBtn = new JButton("VER ESCOLARIDAD");
		    		verBtn.addActionListener(new ActionListener() {
		        		public void actionPerformed(ActionEvent e) {
		        			
		        			File file = new File("escolaridad.txt");
		        	        FileWriter fr = null;
		        	        try {
		        	            fr = new FileWriter(file);
		        	            fr.write("ESCOLARIDAD: "+ usuario.getCedula() + " - " + usuario.getPrimerNombre() + " " + usuario.getPrimerApellido());
		        	        } catch (IOException e1) {
		        	            e1.printStackTrace();
		        	            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
		        	        }finally{
		        	            //close resources
		        	            try {
		        	                fr.close();
		        	            } catch (IOException e1) {
		        	                e1.printStackTrace();
		        	                JOptionPane.showMessageDialog(null, "No se pudo cerrar el archivo");
		        	            }
		        	        };
		        	        
		        			try {
			       			     File path = new File ("escolaridad.txt");
			       			     Desktop.getDesktop().open(path);
			       			} catch (IOException ex) {
			       			     ex.printStackTrace();
			       			     JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
			       			};
		        			
		        		}
		            });
		    		verBtn.setBounds(200, y, 210, 20);
		    		frame.getContentPane().add(verBtn);
		    		y += 25;
	        		
	        	};
	        };
		} catch (NamingException e1) {
			JOptionPane.showMessageDialog(null, "Error al traer los usuarios");
			e1.printStackTrace();
		}
		
		frame.setTitle("REPORTES");
		frame.setVisible(true);
		
	}
}
