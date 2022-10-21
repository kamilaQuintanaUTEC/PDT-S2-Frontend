package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Itr;
import Controladores.ControladorListarItrs;

public class ListarItrs {

	public ListarItrs() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel lista = new JPanel();
		lista.setLayout(null);
		lista.setBounds(15, 50, 700, 700);
		frame.getContentPane().add(lista);
		
		LinkedList<Itr> itrs = ControladorListarItrs.getItrs();
		
		ButtonGroup btnGr = new ButtonGroup();
		
		JRadioButton activosBtn = new JRadioButton("ACTIVOS");
		activosBtn.setActionCommand("ACTIVO");
		activosBtn.setBounds(15,15,100,30);
		activosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				listado(itrs, lista, activosBtn.getActionCommand());
			}
        });
		btnGr.add(activosBtn);
    	frame.getContentPane().add(activosBtn);
    	
		JRadioButton eliminadosBtn = new JRadioButton("ELIMINADOS");
		eliminadosBtn.setActionCommand("ELIMINADO");
		eliminadosBtn.setBounds(130,15,100,30);
		eliminadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				listado(itrs, lista, eliminadosBtn.getActionCommand());
			}
        });
		btnGr.add(eliminadosBtn);
    	frame.getContentPane().add(eliminadosBtn);

		frame.setTitle("LISTAR ITRS");
		frame.setVisible(true);
		
	}
	
	public static void listado(LinkedList<Itr> itrs, JPanel lista, String estado) {
		
		lista.removeAll();
		lista.repaint();
		
		int y = 0;
		
        for (Itr itr : itrs) {
        	
        	if (itr.getEstado().equals(estado)) {
        		
        		JTextField itrCampo = new JTextField();
            	itrCampo.setText(itr.getNombre());
            	itrCampo.setBounds(0, y, 200, 20);
            	lista.add(itrCampo);
                
    			JButton guardarBtn = new JButton("GUARDAR");
    			guardarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean modificado = ControladorListarItrs.modificar(itr, itrCampo.getText());
    	    			if (modificado) {
    	    				itr.setNombre(itrCampo.getText());
    	    			} else {
    	    				itrCampo.setText(itr.getNombre());
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
    	    			boolean eliminado = ControladorListarItrs.eliminar(itr);
    	    			if (eliminado) {
    	    				LinkedList<Itr> itrsNuevos = ControladorListarItrs.getItrs();
    	    				rerender(itrsNuevos, lista, estado);
    	    			} else {
    	    				JOptionPane.showMessageDialog(null, "No se pudo eliminar");
    	    			};
    	    		}
    	        });
    			
    			y += 25;
        		
        	};
        	
        }
        
        if (estado.equals("ACTIVO")) {
        	
        	JTextField itrCampo = new JTextField();
        	itrCampo.setBounds(0, y, 200, 20);
        	lista.add(itrCampo);
        	
        	JButton guardarBtn = new JButton("GUARDAR");
    		guardarBtn.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			boolean agregado = ControladorListarItrs.agregar(itrCampo.getText());
	    			if (agregado) {
	    				LinkedList<Itr> itrsNuevos = ControladorListarItrs.getItrs();
	    				rerender(itrsNuevos, lista, estado);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "No se pudo agregar");
	    			};
        		}
            });
    		guardarBtn.setBounds(235, y, 130, 20);
    		lista.add(guardarBtn);
        	
        };
        
	};
	
	public static void rerender (LinkedList<Itr> itrs, JPanel lista, String estado) {
		listado(itrs, lista, estado);
	};
}
