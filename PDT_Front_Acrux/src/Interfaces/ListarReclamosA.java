package Interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Clases.Estado;
import Clases.Reclamo;
import Controladores.ControladorListarReclamosA;

public class ListarReclamosA {

	public ListarReclamosA(String nombreUsuario) {
		initialize(nombreUsuario);
	}
      
	private void initialize(String nombreUsuario) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(15, 100, 700, 700);
		new JScrollPane(lista);
		frame.getContentPane().add(lista);
		
		JLabel usuarioCampoLabel = new JLabel("Nombre de usuario");
		usuarioCampoLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(usuarioCampoLabel);
        JTextField usuarioCampo = new JTextField(15); //set length of the text  
        usuarioCampo.setBounds(125, 15, 130, 20);
        frame.getContentPane().add(usuarioCampo);
        
        ButtonGroup estadoBtnGr = new ButtonGroup();
        JLabel estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(15, 40, 110, 20);
        frame.getContentPane().add(estadoLabel);
        LinkedList<Estado> estados;
		try {
			estados = ControladorListarReclamosA.getEstados();
			int x = 15;
	        for (Estado estado : estados) {
	        	if (estado.getEstado().equals("ACTIVO")) {
		        	JRadioButton radioBtn = new JRadioButton(estado.getNombre());
		        	radioBtn.setActionCommand(estado.getNombre());
		        	x += 115;
		        	radioBtn.setBounds(x,45,100,30);
		        	estadoBtnGr.add(radioBtn);
		        	frame.getContentPane().add(radioBtn);
	        	};
	        };
		} catch (NamingException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo traer los estados");
			e1.printStackTrace();
		};
        
		JButton filtrarBtn = new JButton("FILTRAR");
		filtrarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			render(usuarioCampo, estadoBtnGr, lista, frame, nombreUsuario);
    	        
    		}
        });
		filtrarBtn.setBounds(15, 80, 130, 20);
		frame.getContentPane().add(filtrarBtn);
		
		render(usuarioCampo, estadoBtnGr, lista, frame, nombreUsuario);
		
		frame.setTitle("LISTAR RECLAMOS");
		frame.setVisible(true);
		
	};
	
	public static void listado(LinkedList<Reclamo> reclamos, JPanel lista, String nombreUsuario) {
		
		int y = 0;
		
        for (Reclamo reclamo : reclamos) {
        		
        	JLabel reclamoLabel = new JLabel(reclamo.getTitulo());
        	reclamoLabel.setBounds(0, y, 200, 20);
        	lista.add(reclamoLabel);
                
			JButton verBtn = new JButton("VER");
			verBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			VerReclamo verReclamo = new VerReclamo(reclamo);
	    		}
	        });
			verBtn.setBounds(235, y, 130, 20);
			lista.add(verBtn);
    			
			JButton modificarBtn = new JButton("MODIFICAR");
			modificarBtn.setBounds(370, y, 130, 20);
			lista.add(modificarBtn);
			modificarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModificarReclamoA modificarReclamoA = new ModificarReclamoA(nombreUsuario,reclamo);
	    		};
	        });
			
			y += 25;
        	
        };
        
	};
	
	public static void render (JTextField usuarioCampo, ButtonGroup estadoBtnGr, JPanel lista, JFrame frame, String nombreUsuario) {
		String usuario = usuarioCampo.getText();
		String estado = "";
		try {
			estado = estadoBtnGr.getSelection().getActionCommand();
		} catch (NullPointerException er) {};
		lista.removeAll();
        frame.remove(lista);
        frame.repaint();
        LinkedList<Reclamo> reclamos;
        try {
        	reclamos = ControladorListarReclamosA.getReclamos(usuario, estado);
        	listado(reclamos,lista,nombreUsuario);
        	frame.getContentPane().add(lista);
        } catch (NamingException e1) {
        	JOptionPane.showMessageDialog(null, "Error al traer los reclamos");
			e1.printStackTrace();
        };
	};
}
