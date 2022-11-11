package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.exception.ServiciosException;

import Clases.Estado;
import Clases.Reclamo;
import Controladores.ControladorListarReclamosA;
import Controladores.ControladorModificarReclamoA;

public class ModificarReclamoA {
	
	public ModificarReclamoA(String nombreUsuario, Reclamo reclamo) {
		initialize(nombreUsuario, reclamo);
	};
      
	private void initialize(String nombreUsuario, Reclamo reclamo) {
		
		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tituloLabel = new JLabel(reclamo.getTitulo());
		tituloLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(tituloLabel);
        
        JLabel fechaHoraLabel = new JLabel(reclamo.getFechaHora());
        fechaHoraLabel.setBounds(500, 15, 200, 20);
        frame.getContentPane().add(fechaHoraLabel);
        
        JTextArea descripcionLabel = new JTextArea(reclamo.getDescripcion());
        descripcionLabel.setEditable(false);
        descripcionLabel.setBounds(15, 40, 300, 150);
        descripcionLabel.setLineWrap(true);
        frame.getContentPane().add(descripcionLabel);
        
        JLabel nombreEventoVMELabel = new JLabel("VME: " + reclamo.getNombreEventoVME());
        nombreEventoVMELabel.setBounds(15, 175, 200, 20);
        frame.getContentPane().add(nombreEventoVMELabel);
        
        JLabel nombreActividadAPELabel = new JLabel("APE: " + reclamo.getNombreActividadAPE());
        nombreActividadAPELabel.setBounds(15, 200, 200, 20);
        frame.getContentPane().add(nombreActividadAPELabel);
        
        JLabel semestreLabel = new JLabel("Semestre: " + reclamo.getSemestre());
        semestreLabel.setBounds(15, 225, 110, 20);
        frame.getContentPane().add(semestreLabel);
        
        JLabel fechaLabel = new JLabel("Fecha del evento: " + reclamo.getFecha());
        fechaLabel.setBounds(200, 225, 170, 20);
        frame.getContentPane().add(fechaLabel);
        
        JLabel docenteLabel = new JLabel("Docente: " + reclamo.getDocente());
        docenteLabel.setBounds(420, 225, 110, 20);
        frame.getContentPane().add(docenteLabel);
        
        JLabel creditosLabel = new JLabel("Créditos: " + reclamo.getCreditos());
        creditosLabel.setBounds(15, 250, 110, 20);
        frame.getContentPane().add(creditosLabel);
        
        JLabel estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(200, 250, 110, 20);
        frame.getContentPane().add(estadoLabel);
        LinkedList<Estado> estados;
        ButtonGroup estadoBtnGr = new ButtonGroup();
		try {
			estados = ControladorListarReclamosA.getEstados();
	        frame.getContentPane().add(estadoLabel);
	        int x = 200;
	        for (Estado estado : estados) {
	        	if (estado.getEstado().equals("ACTIVO")) {
		        	JRadioButton radioBtn = new JRadioButton(estado.getNombre());
		        	radioBtn.setActionCommand(estado.getNombre());
		        	x += 115;
		        	radioBtn.setBounds(x,250,100,30);
		        	if (reclamo.getEstado().getNombre().equals(estado.getNombre())) {
		        		radioBtn.setSelected(true);
		        	};
		        	radioBtn.addActionListener(new ActionListener() {
		        		public void actionPerformed(ActionEvent e) {

		        			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma los cambios?");
		        	        if (confirmacion == 0) {
		        	        	try {
									boolean modificado = ControladorModificarReclamoA.modificarEstado(reclamo,estado.getNombre());
									if (modificado) {
										reclamo.setEstado(estado);
										JOptionPane.showMessageDialog(null, "Se modificó el estado");
									} else {
										JOptionPane.showMessageDialog(null, "No se pudo modificar el estado");
									};
			        			} catch (NamingException e1) {
									JOptionPane.showMessageDialog(null, "No se pudo modificar el estado");
									e1.printStackTrace();
								} catch (ServiciosException e1) {
									JOptionPane.showMessageDialog(null, "No se pudo modificar el estado");
									e1.printStackTrace();
								};
		        	        };
		        		};
		            });
		        	estadoBtnGr.add(radioBtn);
		        	frame.getContentPane().add(radioBtn);
	        	};
	        };
		} catch (NamingException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo traer los estados");
			e1.printStackTrace();
		}
		
        JLabel accionLabel = new JLabel("Acción");
        accionLabel.setBounds(15, 275, 110, 20);
        frame.getContentPane().add(accionLabel);
        
        JTextArea accionCampo = new JTextArea();
        accionCampo.setLineWrap(true);
        accionCampo.setBounds(15, 300, 500, 100);
		frame.getContentPane().add(accionCampo);
        
		JButton modificarBtn = new JButton("AGREGAR ACCIÓN");
		modificarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma los cambios?");
    	        if (confirmacion == 0) {
    	        	String accion = accionCampo.getText();
    	        	
    	        	if (accion.equals("")) {
    	        		JOptionPane.showMessageDialog(null, "No se puede registrar una acción vacía");
    	        	} else {
    	        		boolean modificado;
        				try {
        					modificado = ControladorModificarReclamoA.agregarAcción(nombreUsuario,accion,reclamo);
        					if (modificado) {
        	    				JOptionPane.showMessageDialog(null, "Se registró la acción");
        	    			} else {
        	    				JOptionPane.showMessageDialog(null, "No se pudo registrar la acción");
        	    			};
        				} catch (NamingException e1) {
        					JOptionPane.showMessageDialog(null, "No se pudo registrar la acción");
        					e1.printStackTrace();
        				} catch (ServiciosException e1) {
        					JOptionPane.showMessageDialog(null, "No se pudo registrar la acción");
        					e1.printStackTrace();
        				};
    	        	};
    	        };
    		};
        });
		modificarBtn.setBounds(15, 425, 200, 20);
		frame.getContentPane().add(modificarBtn);
		
		frame.setTitle("MODIFICAR RECLAMO");
		frame.setVisible(true);
		
	};
}