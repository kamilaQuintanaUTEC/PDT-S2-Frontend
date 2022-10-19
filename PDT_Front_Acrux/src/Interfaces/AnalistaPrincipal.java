package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnalistaPrincipal {
	
	public AnalistaPrincipal(String nombreUsuario) {
		initialize(nombreUsuario);
	}
      
	private void initialize(String nombreUsuario) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 250, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton listarUsuariosBtn = new JButton("Listado de usuarios");
		listarUsuariosBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ListarUsuarios listarUsuarios = new ListarUsuarios();
    		}
        });
		listarUsuariosBtn.setBounds(15, 15, 200, 20);
		frame.getContentPane().add(listarUsuariosBtn);
		
		JButton modificarDatosPropiosBtn = new JButton("Modificar Datos Propios");
		modificarDatosPropiosBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios(nombreUsuario);
    		}
        });
		modificarDatosPropiosBtn.setBounds(15, 40, 200, 20);
		frame.getContentPane().add(modificarDatosPropiosBtn);
		
		JButton listarItrsBtn = new JButton("Listado de ITRs");
		listarItrsBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ListarItrs listarItrs = new ListarItrs();
    		}
        });
		listarItrsBtn.setBounds(15, 65, 200, 20);
		frame.getContentPane().add(listarItrsBtn);
		
		JButton listarReclamosBtn = new JButton("Listado de Reclamos");
		listarReclamosBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ListarReclamosA listarReclamos = new ListarReclamosA();
    		}
        });
		listarReclamosBtn.setBounds(15, 90, 200, 20);
		frame.getContentPane().add(listarReclamosBtn);
		
		JButton listarEstadosBtn = new JButton("Listado de Estados");
		listarEstadosBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ListarEstados listarEstados = new ListarEstados();
    		}
        });
		listarEstadosBtn.setBounds(15, 115, 200, 20);
		frame.getContentPane().add(listarEstadosBtn);
		
		JButton reportesBtn = new JButton("Reportes");
		reportesBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) { 
    			ReportesAT reportes = new ReportesAT();
    		}
        });
		reportesBtn.setBounds(15, 115, 200, 20);
		frame.getContentPane().add(reportesBtn);
		
		frame.setTitle("ANALISTA - PRINCIPAL");
		frame.setVisible(true);
		
	}
}
