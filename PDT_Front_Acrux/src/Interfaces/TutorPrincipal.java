package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TutorPrincipal {

	public TutorPrincipal(String nombreUsuario) {
		initialize(nombreUsuario);
	}
      
	private void initialize(String nombreUsuario) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 250, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton modificarDatosPropiosBtn = new JButton("Modificar Datos Propios");
		modificarDatosPropiosBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios(nombreUsuario);
    		}
        });
		modificarDatosPropiosBtn.setBounds(15, 15, 200, 20);
		frame.getContentPane().add(modificarDatosPropiosBtn);
		
		JButton reportesBtn = new JButton("Reportes");
		reportesBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ReportesAT reportes = new ReportesAT();
    		}
        });
		reportesBtn.setBounds(15, 40, 200, 20);
		frame.getContentPane().add(reportesBtn);
		
		frame.setTitle("TUTOR PRINCIPAL");
		frame.setVisible(true);
		
	}
}
