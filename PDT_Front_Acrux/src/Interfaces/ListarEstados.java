package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Estado;
import Controladores.ControladorListarEstados;

public class ListarEstados {

	public ListarEstados() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(15, 40, 700, 700);
		frame.getContentPane().add(lista);
		
		LinkedList<Estado> estados = ControladorListarEstados.getEstados();
		
		JRadioButton activosBtn = new JRadioButton("ACTIVOS");
		activosBtn.setActionCommand("ACTIVO");
		activosBtn.setBounds(15,15,100,30);
		activosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				listado(estados, lista, activosBtn.getActionCommand());
			}
        });
    	frame.getContentPane().add(activosBtn);
    	
		JRadioButton eliminadosBtn = new JRadioButton("ELIMINADOS");
		eliminadosBtn.setActionCommand("ELIMINADO");
		eliminadosBtn.setBounds(130,15,100,30);
		eliminadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				listado(estados, lista, eliminadosBtn.getActionCommand());
			}
        });
    	frame.getContentPane().add(eliminadosBtn);

		frame.setTitle("LISTAR ESTADOS");
		frame.setVisible(true);
		
	}
	
	public static void listado(LinkedList<Estado> estados, JPanel lista, String estado) {
		
		int y = 0;
		
        for (Estado est : estados) {
        	
        	if (est.getEstado().equals(estado)) {
        		
        		JTextField eCampo = new JTextField();
        		eCampo.setText(est.getNombre());
        		eCampo.setBounds(0, y, 200, 20);
            	lista.add(eCampo);
                
    			JButton guardarBtn = new JButton("GUARDAR");
    			guardarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean modificado = ControladorListarEstados.modificar(est, eCampo.getText());
    	    			if (modificado) {
    	    				est.setNombre(eCampo.getText());
    	    			} else {
    	    				eCampo.setText(est.getNombre());
    	    				JOptionPane.showMessageDialog(null, "No se pudo modificar");
    	    			};
    	    		}
    	        });
    			guardarBtn.setBounds(235, y, 130, 20);
    			lista.add(guardarBtn);
    			
    			JButton eliminarBtn = new JButton("ELIMINAR");
    			eliminarBtn.setBounds(370, y, 130, 20);
    			lista.add(eliminarBtn);
    			eliminarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean eliminado = ControladorListarEstados.eliminar(est);
    	    			if (eliminado) {
    	    				rerender(estados, lista, estado);
    	    			} else {
    	    				JOptionPane.showMessageDialog(null, "No se pudo eliminar");
    	    			};
    	    		}
    	        });
    			
    			y += 25;
        		
        	};
        	
        }
        
        if (estado.equals("ACTIVO")) {
        	
        	JTextField eCampo = new JTextField();
        	eCampo.setBounds(0, y, 200, 20);
        	lista.add(eCampo);
        	
        	JButton guardarBtn = new JButton("GUARDAR");
    		guardarBtn.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			boolean agregado = ControladorListarEstados.agregar(eCampo.getText());
	    			if (agregado) {
	    				rerender(estados, lista, estado);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "No se pudo agregar");
	    			};
        		}
            });
    		guardarBtn.setBounds(235, y, 130, 20);
    		lista.add(guardarBtn);
        	
        };
        
	};
	
	public static void rerender (LinkedList<Estado> estados, JPanel lista, String estado) {
		lista.removeAll();
		lista.repaint();
		listado(estados, lista, estado);
	};
}
