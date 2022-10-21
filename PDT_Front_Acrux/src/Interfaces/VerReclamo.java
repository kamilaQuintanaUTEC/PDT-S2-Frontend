package Interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Clases.Reclamo;

public class VerReclamo {
	public VerReclamo(Reclamo reclamo) {
		initialize(reclamo);
	}
      
	private void initialize(Reclamo reclamo) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 900, 600);
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
        
        JLabel estadoLabel = new JLabel("Estado: " + reclamo.getEstado());
        estadoLabel.setBounds(200, 400, 200, 20);
        frame.getContentPane().add(estadoLabel);
		
        JLabel accionLabel = new JLabel("Acción realizada: " + reclamo.getAccion());
        accionLabel.setBounds(15, 425, 400, 100);
        frame.getContentPane().add(accionLabel);
        
        JLabel accionFecLabel = new JLabel("Fecha: " + reclamo.getAccionFec());
        accionFecLabel.setBounds(15, 550, 170, 20);
        frame.getContentPane().add(accionFecLabel);
        
        JLabel accionAnalistaLabel = new JLabel("Analista: " + reclamo.getAccionAnalista());
        accionAnalistaLabel.setBounds(200, 550, 200, 20);
        frame.getContentPane().add(accionAnalistaLabel);
        
		frame.setTitle("RECLAMO");
		frame.setVisible(true);
		
	};
}
