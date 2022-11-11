package Interfaces;

import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.entities.AccionReclamo;

import Clases.Reclamo;
import Controladores.ControladorListarReclamosE;

public class VerReclamo {
	public VerReclamo(Reclamo reclamo) {
		initialize(reclamo);
	}
      
	private void initialize(Reclamo reclamo) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 900, 600);
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
        
        JLabel estadoLabel = new JLabel("Estado: " + reclamo.getEstado().getNombre());
        estadoLabel.setBounds(200, 250, 200, 20);
        frame.getContentPane().add(estadoLabel);
        
        int y = 290;
        try {
			LinkedList<AccionReclamo> acciones = ControladorListarReclamosE.getAcciones(reclamo);
			for (AccionReclamo accionR: acciones) {
				
				JTextArea accionLabel = new JTextArea("Acción: " + accionR.getDetalle());
				accionLabel.setBounds(15, y, 600, 50);
				accionLabel.setEditable(false);
				accionLabel.setLineWrap(true);
		        frame.getContentPane().add(accionLabel);
		        
		        JLabel analistaLabel = new JLabel("Analista: " + accionR.getAnalista().getUsuario().getNombre() + accionR.getAnalista().getUsuario().getApellido());
		        analistaLabel.setBounds(15, y + 48, 220, 20);
		        frame.getContentPane().add(analistaLabel);
		        
		        JLabel fechaALabel = new JLabel("Fecha: " + accionR.getFechaAccion());
		        fechaALabel.setBounds(230, y + 48, 200, 20);
		        frame.getContentPane().add(fechaALabel);
		        
		        y+=90;
		        
			}; 
		} catch (NamingException e) {
			JOptionPane.showMessageDialog(null, "No se pudo traer las acciones");
			e.printStackTrace();
		};
        
		frame.setTitle("RECLAMO");
		frame.setVisible(true);
		
	};
}
