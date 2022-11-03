package Interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Clases.Reclamo;

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
		
        JLabel accionLabel = new JLabel("Acción realizada: " + reclamo.getAccion());
        accionLabel.setBounds(15, 275, 400, 80);
        frame.getContentPane().add(accionLabel);
        
        JLabel accionFecLabel = new JLabel("Fecha: " + reclamo.getAccionFec());
        accionFecLabel.setBounds(15, 400, 170, 20);
        frame.getContentPane().add(accionFecLabel);
        
        JLabel accionAnalistaLabel = new JLabel("Analista: " + reclamo.getAccionAnalista());
        accionAnalistaLabel.setBounds(200, 400, 200, 20);
        frame.getContentPane().add(accionAnalistaLabel);
        
		frame.setTitle("RECLAMO");
		frame.setVisible(true);
		
	};
}
