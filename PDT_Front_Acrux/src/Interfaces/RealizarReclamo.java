package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controladores.ControladorRealizarRegistro;

public class RealizarReclamo {

	public RealizarReclamo() {
		initialize();
	}
      
	private void initialize() {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        
        JLabel tituloRegistroLabel = new JLabel("REGISTRO");
        tituloRegistroLabel.setBounds(15, 15, 100, 20);
        frame.getContentPane().add(tituloRegistroLabel);
        
        JLabel requeridoLabel = new JLabel("* campos requeridos");
        requeridoLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(requeridoLabel);
        
        JLabel tituloCampoLabel = new JLabel("Título *");
        tituloCampoLabel.setBounds(15, 40, 110, 20);
        frame.getContentPane().add(tituloCampoLabel);
        JTextField tituloCampo = new JTextField(15); //set length of the text  
        tituloCampo.setBounds(115, 40, 130, 20);
		frame.getContentPane().add(tituloCampo);
		
		JLabel nombreVMECampoLabel = new JLabel("Nombre VME");
		nombreVMECampoLabel.setBounds(260, 40, 110, 20);
        frame.getContentPane().add(nombreVMECampoLabel);
        JTextField nombreVMECampo = new JTextField(15); //set length of the text  
        nombreVMECampo.setBounds(360, 40, 130, 20);
		frame.getContentPane().add(nombreVMECampo);
		
		JLabel nombreAPECampoLabel = new JLabel("Nombre APE");
		nombreAPECampoLabel.setBounds(505, 40, 110, 20);
        frame.getContentPane().add(nombreAPECampoLabel);
        JTextField nombreAPECampo = new JTextField(15); //set length of the text  
        nombreAPECampo.setBounds(605, 40, 130, 20);
		frame.getContentPane().add(nombreAPECampo);
		
		JLabel semestreCampoLabel = new JLabel("Semestre (1-8)");
		semestreCampoLabel.setBounds(750, 40, 110, 20);
        frame.getContentPane().add(semestreCampoLabel);
        JTextField semestreCampo = new JTextField(15); //set length of the text  
        semestreCampo.setBounds(850, 40, 30, 20);
		frame.getContentPane().add(semestreCampo);
		
		JLabel fechaCampoLabel = new JLabel("Fecha");
		fechaCampoLabel.setBounds(15, 65, 110, 20);
        frame.getContentPane().add(fechaCampoLabel);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField fechaCampo = new JFormattedTextField(df); //set length of the text  
        fechaCampo.setBounds(115, 65, 130, 20);
		frame.getContentPane().add(fechaCampo);
		
		JLabel docenteCampoLabel = new JLabel("Docente");
		docenteCampoLabel.setBounds(260, 65, 110, 20);
        frame.getContentPane().add(docenteCampoLabel);
        JTextField docenteCampo = new JTextField(15);
        docenteCampo.setBounds(360, 65, 130, 20);
		frame.getContentPane().add(docenteCampo);
		
		JLabel creditosCampoLabel = new JLabel("Créditos");
		creditosCampoLabel.setBounds(505, 65, 110, 20);
        frame.getContentPane().add(creditosCampoLabel);
        JTextField creditosCampo = new JTextField(15); //set length of the text  
        creditosCampo.setBounds(605, 65, 130, 20);
		frame.getContentPane().add(creditosCampo);
		
		JLabel descripcionCampoLabel = new JLabel("Descripción *");
		descripcionCampoLabel.setBounds(15, 90, 110, 20);
        frame.getContentPane().add(descripcionCampoLabel);
        JTextField descripcionCampo = new JTextField(); //set length of the text  
        descripcionCampo.setBounds(15, 115, 500, 300);
		frame.getContentPane().add(descripcionCampo);
        
		JButton enviarBtn = new JButton("ENVIAR");
		enviarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

				String titulo = tituloCampo.getText();
    			String descripcion = descripcionCampo.getText();
    			String nombreEventoVME = nombreVMECampo.getText();
    			String nombreActividadAPE = nombreAPECampo.getText();
    			int semestre = Integer.parseInt(semestreCampo.getText());
    			String fecha = fechaCampo.getText();
    			String docente = docenteCampo.getText();
    			int creditos = Integer.parseInt(creditosCampo.getText());
    			
    			if (titulo.equals("") || descripcion.equals("")) {
    				JOptionPane.showMessageDialog(null, "Completar todos los datos requeridos");
    			} else {
    				String respuesta = ControladorRealizarRegistro.agregar(titulo,descripcion,nombreEventoVME,nombreActividadAPE,semestre,fecha,docente,creditos);
	    	        JOptionPane.showMessageDialog(null, respuesta);
    			};

    		}
        });
		enviarBtn.setBounds(15, 310, 130, 20);
		frame.getContentPane().add(enviarBtn);
		
		frame.setTitle("REALIZAR UN RECLAMO");
		frame.setVisible(true);
    };
		
}
