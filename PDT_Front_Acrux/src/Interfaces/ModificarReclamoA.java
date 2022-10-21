package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Estado;
import Clases.Reclamo;
import Controladores.ControladorListarReclamosA;
import Controladores.ControladorModificarReclamoA;

public class ModificarReclamoA {
	
	public ModificarReclamoA(Reclamo reclamo) {
		initialize(reclamo);
	};
      
	private void initialize(Reclamo reclamo) {
		
		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tituloLabel = new JLabel(reclamo.getTitulo());
		tituloLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(tituloLabel);
        
        JLabel fechaHoraLabel = new JLabel(reclamo.getFechaHora());
        fechaHoraLabel.setBounds(500, 15, 110, 20);
        frame.getContentPane().add(fechaHoraLabel);
        
        JLabel descripcionLabel = new JLabel(reclamo.getDescripcion());
        descripcionLabel.setBounds(15, 40, 300, 300);
        frame.getContentPane().add(descripcionLabel);
        
        JLabel nombreEventoVMELabel = new JLabel("VME: " + reclamo.getNombreEventoVME());
        nombreEventoVMELabel.setBounds(15, 325, 200, 20);
        frame.getContentPane().add(nombreEventoVMELabel);
        
        JLabel nombreActividadAPELabel = new JLabel("APE: " + reclamo.getNombreActividadAPE());
        nombreActividadAPELabel.setBounds(15, 350, 200, 20);
        frame.getContentPane().add(nombreActividadAPELabel);
        
        JLabel semestreLabel = new JLabel("Semestre: " + reclamo.getSemestre());
        semestreLabel.setBounds(15, 375, 110, 20);
        frame.getContentPane().add(semestreLabel);
        
        JLabel fechaLabel = new JLabel("Fecha del evento: " + reclamo.getFecha());
        fechaLabel.setBounds(200, 375, 170, 20);
        frame.getContentPane().add(fechaLabel);
        
        JLabel docenteLabel = new JLabel("Docente: " + reclamo.getDocente());
        docenteLabel.setBounds(420, 375, 110, 20);
        frame.getContentPane().add(docenteLabel);
        
        JLabel creditosLabel = new JLabel("Créditos: " + reclamo.getCreditos());
        creditosLabel.setBounds(15, 400, 110, 20);
        frame.getContentPane().add(creditosLabel);
        
        JLabel estadoLabel = new JLabel("Estado");
        estadoLabel.setBounds(200, 400, 110, 20);
        frame.getContentPane().add(estadoLabel);
        LinkedList<Estado> estados = ControladorListarReclamosA.getEstados();
        ButtonGroup estadoBtnGr = new ButtonGroup();
        frame.getContentPane().add(estadoLabel);
        int x = 200;
        for (Estado estado : estados) {
        	if (estado.getEstado().equals("ACTIVO")) {
	        	JRadioButton radioBtn = new JRadioButton(estado.getNombre());
	        	radioBtn.setActionCommand(estado.getNombre());
	        	x += 115;
	        	radioBtn.setBounds(x,400,100,30);
	        	estadoBtnGr.add(radioBtn);
	        	frame.getContentPane().add(radioBtn);
        	};
        };
		
        JLabel accionLabel = new JLabel("Acción");
        accionLabel.setBounds(15, 425, 110, 20);
        frame.getContentPane().add(accionLabel);
        
        JTextField accionCampo = new JTextField(); //set length of the text  
        accionCampo.setBounds(15, 450, 500, 100);
		frame.getContentPane().add(accionCampo);
        
		JButton modificarBtn = new JButton("MODIFICAR");
		modificarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

				String accion = accionCampo.getText();
    			String estado = "";
    			
    			boolean modificado = ControladorModificarReclamoA.modificar(accion,estado);
    			if (modificado) {
    				JOptionPane.showMessageDialog(null, "Se registraron los cambios");
    			} else {
    				JOptionPane.showMessageDialog(null, "No se pudo registrar los cambios");
    			};

    		};
        });
		modificarBtn.setBounds(15, 475, 130, 20);
		frame.getContentPane().add(modificarBtn);
		
		frame.setTitle("MODIFICAR RECLAMO");
		frame.setVisible(true);
		
	};
}