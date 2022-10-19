package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Usuario;
import Controladores.ControladorListarUsuarios;
import Controladores.ControladorLoginRegistro;

public class ListarUsuarios {

	public ListarUsuarios() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(15, 90, 700, 700);
		frame.getContentPane().add(lista);
		
		LinkedList<Usuario> usuarios = ControladorListarUsuarios.getUsuarios();
		listado(usuarios, lista);
		
		JLabel añoIngresoCampoLabel = new JLabel("Año de ingreso");
        añoIngresoCampoLabel.setBounds(15, 40, 110, 20);
        frame.getContentPane().add(añoIngresoCampoLabel);
        añoIngresoCampoLabel.hide();
        JTextField añoIngresoCampo = new JTextField(15); //set length of the text  
        añoIngresoCampo.setBounds(125, 40, 130, 20);
        frame.getContentPane().add(añoIngresoCampo);
        añoIngresoCampo.hide();
        
        ButtonGroup usuariosBtnGr = new ButtonGroup();
        LinkedList<String> tipoUsuarios = ControladorLoginRegistro.getTipoDeUsuarios();
        int x = -85;
        for (String tipoUsuario : tipoUsuarios) {
        	JRadioButton radioBtn = new JRadioButton(tipoUsuario);
        	radioBtn.setActionCommand(tipoUsuario);
        	x += 100;
        	radioBtn.setBounds(x,15,100,30);
        	radioBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
			        if (usuariosBtnGr.getSelection().getActionCommand().equals("Estudiante")) {
			        	añoIngresoCampoLabel.show();
			        	añoIngresoCampo.show();
			        } else {
			        	añoIngresoCampoLabel.hide();
			        	añoIngresoCampo.hide();
			        };
				}
	        });
        	usuariosBtnGr.add(radioBtn);
        	frame.getContentPane().add(radioBtn);
        };
        
        ButtonGroup itrsBtnGr = new ButtonGroup();
        LinkedList<String> itrs = ControladorLoginRegistro.getItrs();
        int xi = 250;
        for (String itr : itrs) {
        	JRadioButton radioBtn = new JRadioButton(itr);
        	radioBtn.setActionCommand(itr);
        	xi += 100;
        	radioBtn.setBounds(xi,15,100,30);
        	itrsBtnGr.add(radioBtn);
        	frame.getContentPane().add(radioBtn);
        };
     
        ButtonGroup estadosBtnGr = new ButtonGroup();
        LinkedList<String> estados = ControladorListarUsuarios.getEstados();
        int xe = 250;
        for (String estado : estados) {
        	JRadioButton radioBtn = new JRadioButton(estado);
        	radioBtn.setActionCommand(estado);
        	xe += 100;
        	radioBtn.setBounds(xe,40,100,30);
        	estadosBtnGr.add(radioBtn);
        	frame.getContentPane().add(radioBtn);
        };
        
		JButton filtrarBtn = new JButton("FILTRAR");
		filtrarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    	        String tipoDeUsuario = "";
    	        try {
    	        	tipoDeUsuario = usuariosBtnGr.getSelection().getActionCommand();
    	        } catch (NullPointerException er) {};
    	        
    	        String itr = "";
    	        try {
    	        	itr = itrsBtnGr.getSelection().getActionCommand();
    	        } catch (NullPointerException er) {};
    	        
    	        String estado = "";
    	        try {
    	        	estado = estadosBtnGr.getSelection().getActionCommand();
    	        } catch (NullPointerException er) {};
    	        
    	        String añoIngreso = añoIngresoCampo.getText();

    	        lista.removeAll();
    	        frame.remove(lista);
    	        frame.repaint();
    			
    	        LinkedList<Usuario> usuarios = ControladorListarUsuarios.getUsuarios();
    	        LinkedList<Usuario> usuariosFiltrados = ControladorListarUsuarios.filtrar(usuarios, tipoDeUsuario, itr, añoIngreso, estado);
    	        
    	        listado(usuariosFiltrados, lista);
    	        frame.getContentPane().add(lista);
    	        
    		}
        });
		filtrarBtn.setBounds(15, 65, 130, 20);
		frame.getContentPane().add(filtrarBtn);
        
		frame.setTitle("LISTAR USUARIOS");
		frame.setVisible(true);
		
	}
	
	public static void listado(LinkedList<Usuario> usuarios, JPanel lista) {
		
		int y = 0;
        for (Usuario usuario : usuarios) {
        	
        	JLabel usuarioLabel = new JLabel(usuario.getCedula() + ": " + usuario.getPrimerNombre() + " " + usuario.getPrimerApellido());
        	usuarioLabel.setBounds(0, y, 200, 20);
        	lista.add(usuarioLabel);
            
			JButton modificarBtn = new JButton("MODIFICAR");
			modificarBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			ModificarUsuario modificarUsuario = new ModificarUsuario(usuario);
	    		}
	        });
			modificarBtn.setBounds(235, y, 130, 20);
			lista.add(modificarBtn);
			
			JButton eliminarBtn = new JButton("ELIMINAR");
			eliminarBtn.setBounds(370, y, 130, 20);
			lista.add(eliminarBtn);
			eliminarBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			ControladorListarUsuarios.eliminar(usuario.getCedula());
	    			//re render??
	    			lista.remove(usuarioLabel);
	    			lista.remove(modificarBtn);
	    			lista.remove(eliminarBtn);
	    			lista.repaint();
	    		}
	        });
			
			y += 25;
        }
        
	};
}
