package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Estado;
import Controladores.ControladorListarEstados;
import Controladores.ControladorListarItrs;

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
		lista.setBounds(15, 50, 700, 700);
		frame.getContentPane().add(lista);
		
		ButtonGroup btnGr = new ButtonGroup();
		
		JRadioButton activosBtn = new JRadioButton("ACTIVOS");
		activosBtn.setActionCommand("ACTIVO");
		activosBtn.setBounds(15,15,100,30);
		activosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					listado(lista, activosBtn.getActionCommand());
				} catch (NamingException e) {
					JOptionPane.showMessageDialog(null, "Error al renderizar lista");
					e.printStackTrace();
				}
			}
        });
		btnGr.add(activosBtn);
    	frame.getContentPane().add(activosBtn);
    	
		JRadioButton eliminadosBtn = new JRadioButton("ELIMINADOS");
		eliminadosBtn.setActionCommand("ELIMINADO");
		eliminadosBtn.setBounds(130,15,100,30);
		eliminadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					listado(lista, eliminadosBtn.getActionCommand());
				} catch (NamingException e) {
					JOptionPane.showMessageDialog(null, "Error al renderizar lista");
					e.printStackTrace();
				}
			}
        });
		btnGr.add(eliminadosBtn);
    	frame.getContentPane().add(eliminadosBtn);

		frame.setTitle("LISTAR ESTADOS");
		frame.setVisible(true);
		
	}
	
	public static void listado(JPanel lista, String estado) throws NamingException {
		
		lista.removeAll();
		lista.repaint();
		
		int y = 0;
		
		LinkedList<Estado> estados = ControladorListarEstados.getEstados();
		
        for (Estado est : estados) {
        	
        	if (est.getEstado().equals(estado) && estado.equals("ACTIVO")) {
        		
        		JTextField eCampo = new JTextField();
        		eCampo.setText(est.getNombre());
        		eCampo.setBounds(0, y, 200, 20);
            	lista.add(eCampo);
                
    			JButton guardarBtn = new JButton("GUARDAR");
    			guardarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean modificado;
						try {
							modificado = ControladorListarEstados.modificar(est, eCampo.getText());
							if (modificado) {
	    	    				est.setNombre(eCampo.getText());
	    	    			} else {
	    	    				eCampo.setText(est.getNombre());
	    	    				JOptionPane.showMessageDialog(null, "No se pudo modificar");
	    	    			};
						} catch (NamingException e1) {
							eCampo.setText(est.getNombre());
							JOptionPane.showMessageDialog(null, "No se pudo modificar");
							e1.printStackTrace();
						}
    	    			
    	    		}
    	        });
    			guardarBtn.setBounds(235, y, 130, 20);
    			lista.add(guardarBtn);
    			
    			JButton eliminarBtn = new JButton("ELIMINAR");
    			eliminarBtn.setBounds(370, y, 130, 20);
    			lista.add(eliminarBtn);
    			eliminarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean eliminado;
						try {
							eliminado = ControladorListarEstados.eliminar(est);
							if (eliminado) {
	    	    				LinkedList<Estado> estadosNuevos = ControladorListarEstados.getEstados();
	    	    				rerender(lista, estado);
	    	    			} else {
	    	    				JOptionPane.showMessageDialog(null, "No se pudo eliminar");
	    	    			};
						} catch (NamingException e1) {
							JOptionPane.showMessageDialog(null, "No se pudo eliminar");
							e1.printStackTrace();
						}
    	    		}
    	        });
    			
    			y += 25;
        		
        	};
        	
        	if (est.getEstado().equals(estado) && estado.equals("ELIMINADO")) {
        		JTextField estadoCampo = new JTextField();
        		estadoCampo.setText(est.getNombre());
        		estadoCampo.setBounds(0, y, 200, 20);
            	lista.add(estadoCampo);
                
    			JButton activarBtn = new JButton("ACTIVAR");
    			activarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean activado;
    	    			try {
    	    				activado = ControladorListarEstados.activar(est);
	    	    			if (activado) {
	    	    				rerender(lista, estado);
	    	    			} else {
	    	    				JOptionPane.showMessageDialog(null, "No se pudo activar");
	    	    			};
						} catch (NamingException e1) {
							JOptionPane.showMessageDialog(null, "No se pudo activar");
							e1.printStackTrace();
						}
    	    		}
    	        });
    			activarBtn.setBounds(235, y, 130, 20);
    			lista.add(activarBtn);
    			
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
        			boolean agregado;
					try {
						agregado = ControladorListarEstados.agregar(eCampo.getText());
						if (agregado) {
		    				rerender(lista, estado);
		    			} else {
		    				JOptionPane.showMessageDialog(null, "No se pudo agregar");
		    			};
					} catch (NamingException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo agregar");
						e1.printStackTrace();
					}
	    			
        		}
            });
    		guardarBtn.setBounds(235, y, 130, 20);
    		lista.add(guardarBtn);
        	
        };
        
	};
	
	public static void rerender (JPanel lista, String estado) throws NamingException {
		listado(lista, estado);
	};
}
