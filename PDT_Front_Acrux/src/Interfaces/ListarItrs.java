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

import Clases.Itr;
import Controladores.ControladorListarItrs;

public class ListarItrs {

	public ListarItrs() throws NamingException {
		initialize();
	}
      
	private void initialize() throws NamingException {

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

		frame.setTitle("LISTAR ITRS");
		frame.setVisible(true);
		
	}
	
	public static void listado(JPanel lista, String estado) throws NamingException {
		
		lista.removeAll();
		lista.repaint();
		
		int y = 0;
		
		LinkedList<Itr> itrs = ControladorListarItrs.getItrs();
		
        for (Itr itr : itrs) {
        	
        	if (itr.getEstado().equals(estado) && estado.equals("ACTIVO")) {
        		
        		JTextField itrCampo = new JTextField();
            	itrCampo.setText(itr.getNombre());
            	itrCampo.setBounds(0, y, 200, 20);
            	lista.add(itrCampo);
                
    			JButton guardarBtn = new JButton("GUARDAR");
    			guardarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean modificado;
						try {
							modificado = ControladorListarItrs.modificar(itr, itrCampo.getText());
	    	    			if (modificado) {
	    	    				itr.setNombre(itrCampo.getText());
	    	    			} else {
	    	    				itrCampo.setText(itr.getNombre());
	    	    				JOptionPane.showMessageDialog(null, "No se pudo modificar");
	    	    			};
						} catch (NamingException e1) {
							itrCampo.setText(itr.getNombre());
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
							eliminado = ControladorListarItrs.eliminar(itr);
	    	    			if (eliminado) {
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
        	
        	if (itr.getEstado().equals(estado) && estado.equals("ELIMINADO")) {
        		JTextField itrCampo = new JTextField();
            	itrCampo.setText(itr.getNombre());
            	itrCampo.setBounds(0, y, 200, 20);
            	lista.add(itrCampo);
                
    			JButton activarBtn = new JButton("ACTIVAR");
    			activarBtn.addActionListener(new ActionListener() {
    	    		public void actionPerformed(ActionEvent e) {
    	    			boolean activado;
    	    			try {
    	    				activado = ControladorListarItrs.activar(itr);
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
        	
        	JTextField itrCampo = new JTextField();
        	itrCampo.setBounds(0, y, 200, 20);
        	lista.add(itrCampo);
        	
        	JButton guardarBtn = new JButton("GUARDAR");
    		guardarBtn.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			boolean agregado;
					try {
						agregado = ControladorListarItrs.agregar(itrCampo.getText());
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
