package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Estado;
import Clases.Itr;
import Clases.Reclamo;
import Clases.Usuario;
import Controladores.ControladorListarItrs;
import Controladores.ControladorListarReclamosA;
import Controladores.ControladorListarReclamosE;
import Controladores.ControladorListarUsuarios;

public class ListarReclamosE {

	public ListarReclamosE() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(15, 70, 700, 700);
		frame.getContentPane().add(lista);
		
        ButtonGroup estadoBtnGr = new ButtonGroup();
        JLabel estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(estadoLabel);
        LinkedList<Estado> estados = ControladorListarReclamosE.getEstados();
        int x = 15;
        for (Estado estado : estados) {
        	if (estado.getEstado().equals("ACTIVO")) {
	        	JRadioButton radioBtn = new JRadioButton(estado.getNombre());
	        	radioBtn.setActionCommand(estado.getNombre());
	        	x += 115;
	        	radioBtn.setBounds(x,20,100,30);
	        	estadoBtnGr.add(radioBtn);
	        	frame.getContentPane().add(radioBtn);
        	};
        };
        
		JButton filtrarBtn = new JButton("FILTRAR");
		filtrarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    	        
    	        String estado = "";
    	        
    	        try {
    	        	estado = estadoBtnGr.getSelection().getActionCommand();
    	        } catch (NullPointerException er) {
    	        	JOptionPane.showMessageDialog(null, "Seleccionar un estado");
    			};
    			
    			LinkedList<Reclamo> reclamos = ControladorListarReclamosE.getReclamos(estado);
    	        
    	        listado(reclamos, lista, estado);
    	        
    	        frame.getContentPane().add(lista);
    	        
    		}
        });
		filtrarBtn.setBounds(15, 50, 130, 20);
		frame.getContentPane().add(filtrarBtn);
		
		frame.setTitle("LISTAR RECLAMOS");
		frame.setVisible(true);
		
	};
	
	public static void listado(LinkedList<Reclamo> reclamos, JPanel lista, String estado) {
		
		lista.removeAll();
		lista.repaint();
		
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
	    			ModificarReclamoE modificarReclamoE = new ModificarReclamoE(reclamo);
	    		}
	        });
			
			JButton eliminarBtn = new JButton("ELIMINAR");
			eliminarBtn.setBounds(370, y, 130, 20);
			lista.add(eliminarBtn);
			eliminarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean eliminado = ControladorListarReclamosE.eliminar(reclamo);
	    			if (eliminado) {
	    				LinkedList<Reclamo> reclamos = ControladorListarReclamosE.getReclamos(estado);
	    				rerender(reclamos, lista, estado);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "No se pudo eliminar");
	    			};
	    		}
	        });
			
			y += 25;
        	
        };
        
	};
	
	public static void rerender (LinkedList<Reclamo> reclamos, JPanel lista, String estado) {
		listado(reclamos, lista, estado);
	};
}
