package Interfaces;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Clases.Usuario;
import Controladores.ControladorListarUsuarios;

public class Reportes {

	public Reportes(String nombreUsuario) {
		initialize(nombreUsuario);
	}
      
	private void initialize(String nombreUsuario) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 250, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton verBtn = new JButton("VER ESCOLARIDAD");
		verBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			LinkedList<Usuario> usuarios;
    			try {
    				usuarios = ControladorListarUsuarios.getUsuarios();
    				for (Usuario usuario: usuarios) {
    					if (usuario.getEmailInstitucional().equals(nombreUsuario)) {
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
    		       			
    		       			return;
    					};
    				};
    			} catch (NamingException e1) {
    				JOptionPane.showMessageDialog(null, "Error al traer los usuarios");
    				e1.printStackTrace();
    			};
       			
    		}
        });
		verBtn.setBounds(15, 15, 150, 20);
		frame.getContentPane().add(verBtn);
		
		frame.setTitle("REPORTES");
		frame.setVisible(true);
		
	}
}
