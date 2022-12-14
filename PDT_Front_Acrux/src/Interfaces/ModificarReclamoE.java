package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.exception.ServiciosException;

import Clases.Reclamo;
import Controladores.ControladoModificarReclamoE;
import Controladores.ControladorModificarReclamoA;
import Controladores.ControladorRealizarReclamo;

public class ModificarReclamoE {

	public ModificarReclamoE(String nombreUsuario, Reclamo reclamo) {
		initialize(nombreUsuario,reclamo);
	}
      
	private void initialize(String nombreUsuario, Reclamo reclamo) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        
        JLabel tituloRegistroLabel = new JLabel("REGISTRO");
        tituloRegistroLabel.setBounds(15, 15, 100, 20);
        frame.getContentPane().add(tituloRegistroLabel);
        
        JLabel requeridoLabel = new JLabel("* campos requeridos");
        requeridoLabel.setBounds(15, 40, 150, 20);
        frame.getContentPane().add(requeridoLabel);
        
        JLabel tituloCampoLabel = new JLabel("Título *");
        tituloCampoLabel.setBounds(15, 65, 110, 20);
        frame.getContentPane().add(tituloCampoLabel);
        JTextField tituloCampo = new JTextField(15); //set length of the text  
        tituloCampo.setBounds(115, 65, 130, 20);
        tituloCampo.setText(reclamo.getTitulo());
		frame.getContentPane().add(tituloCampo);
		
		JLabel nombreVMECampoLabel = new JLabel("Nombre VME");
		nombreVMECampoLabel.setBounds(260, 65, 110, 20);
        frame.getContentPane().add(nombreVMECampoLabel);
        JTextField nombreVMECampo = new JTextField(15); //set length of the text  
        nombreVMECampo.setBounds(360, 65, 130, 20);
        nombreVMECampo.setText(reclamo.getNombreEventoVME());
		frame.getContentPane().add(nombreVMECampo);
		
		JLabel nombreAPECampoLabel = new JLabel("Nombre APE");
		nombreAPECampoLabel.setBounds(505, 65, 110, 20);
        frame.getContentPane().add(nombreAPECampoLabel);
        JTextField nombreAPECampo = new JTextField(15); //set length of the text  
        nombreAPECampo.setBounds(605, 65, 130, 20);
        nombreAPECampo.setText(reclamo.getNombreActividadAPE());
		frame.getContentPane().add(nombreAPECampo);
		
		JLabel semestreCampoLabel = new JLabel("Semestre (1-8)");
		semestreCampoLabel.setBounds(750, 65, 110, 20);
        frame.getContentPane().add(semestreCampoLabel);
        JTextField semestreCampo = new JTextField(15); //set length of the text  
        semestreCampo.setBounds(850, 65, 30, 20);
        semestreCampo.setText(String.valueOf(reclamo.getSemestre()));
		frame.getContentPane().add(semestreCampo);
		
		JLabel fechaCampoLabel = new JLabel("Fecha");
		fechaCampoLabel.setBounds(15, 90, 110, 20);
        frame.getContentPane().add(fechaCampoLabel);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField fechaCampo = new JFormattedTextField(df); //set length of the text  
        fechaCampo.setBounds(115, 90, 130, 20);
        fechaCampo.setText(reclamo.getFecha());
		frame.getContentPane().add(fechaCampo);
		
		JLabel docenteCampoLabel = new JLabel("Docente");
		docenteCampoLabel.setBounds(260, 90, 110, 20);
        frame.getContentPane().add(docenteCampoLabel);
        JTextField docenteCampo = new JTextField(15);
        docenteCampo.setBounds(360, 90, 130, 20);
        docenteCampo.setText(reclamo.getDocente());
		frame.getContentPane().add(docenteCampo);
		
		JLabel creditosCampoLabel = new JLabel("Créditos");
		creditosCampoLabel.setBounds(505, 90, 110, 20);
        frame.getContentPane().add(creditosCampoLabel);
        JTextField creditosCampo = new JTextField(15); //set length of the text  
        creditosCampo.setBounds(605, 90, 30, 20);
        creditosCampo.setText(String.valueOf(reclamo.getCreditos()));
		frame.getContentPane().add(creditosCampo);
		
		JLabel descripcionCampoLabel = new JLabel("Descripción *");
		descripcionCampoLabel.setBounds(15, 115, 110, 20);
        frame.getContentPane().add(descripcionCampoLabel);
        JTextArea descripcionCampo = new JTextArea(); //set length of the text  
        descripcionCampo.setBounds(15, 140, 500, 150);
        descripcionCampo.setLineWrap(true);
        descripcionCampo.setText(reclamo.getDescripcion());
		frame.getContentPane().add(descripcionCampo);
        
		JButton enviarBtn = new JButton("MODIFICAR");
		enviarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

				String titulo = tituloCampo.getText();
    			String descripcion = descripcionCampo.getText();
    			String nombreEventoVME = nombreVMECampo.getText();
    			String nombreActividadAPE = nombreAPECampo.getText();
    			String semestre = semestreCampo.getText();
    			String fecha = fechaCampo.getText();
    			String docente = docenteCampo.getText();
    			String creditos = creditosCampo.getText();
    			
    			if (titulo.equals("") || descripcion.equals("")) {
    				JOptionPane.showMessageDialog(null, "Completar todos los datos requeridos");
    			} else {
    				boolean modificado;
					try {
						modificado = ControladoModificarReclamoE.modificar(nombreUsuario,reclamo.getTitulo(),titulo,descripcion,nombreEventoVME,nombreActividadAPE,semestre,fecha,docente,creditos);
						if (modificado) {
							frame.dispose();
	        				JOptionPane.showMessageDialog(null, "Se registraron los cambios");
	        			} else {
	        				JOptionPane.showMessageDialog(null, "No se pudo registrar los cambios");
	        			};
					} catch (NamingException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo registrar los cambios");
						e1.printStackTrace();
					} catch (ServiciosException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo registrar los cambios");
						e1.printStackTrace();
					};
    			};

    		}
        });
		enviarBtn.setBounds(15, 315, 130, 20);
		frame.getContentPane().add(enviarBtn);
		
		frame.setTitle("REALIZAR UN RECLAMO");
		frame.setVisible(true);
    };

}
