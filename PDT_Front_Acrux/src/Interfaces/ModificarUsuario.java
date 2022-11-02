package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clases.Usuario;
import Controladores.ControladorLoginRegistro;
import Controladores.ControladorModificarUsuario;

public class ModificarUsuario {

	public ModificarUsuario(Usuario usuario) {
		initialize(usuario);
	}
      
	private void initialize(Usuario usuario) {

		JFrame frame = new JFrame();
		frame.setBounds(50, 100, 1100, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JLabel primerNombreCampoLabel = new JLabel("Primer nombre");
        primerNombreCampoLabel.setBounds(15, 15, 110, 20);
        frame.getContentPane().add(primerNombreCampoLabel);
        JTextField primerNombreCampo = new JTextField(15); //set length of the text 
        primerNombreCampo.setText(usuario.getPrimerNombre());
        primerNombreCampo.setBounds(115, 15, 130, 20);
		frame.getContentPane().add(primerNombreCampo);
		
		JLabel segundoNombreCampoLabel = new JLabel("Segundo nombre");
		segundoNombreCampoLabel.setBounds(260, 15, 110, 20);
        frame.getContentPane().add(segundoNombreCampoLabel);
        JTextField segundoNombreCampo = new JTextField(15); //set length of the text  
        segundoNombreCampo.setText(usuario.getSegundoNombre());
        segundoNombreCampo.setBounds(360, 15, 130, 20);
		frame.getContentPane().add(segundoNombreCampo);
		
		JLabel primerApellidoCampoLabel = new JLabel("Primer apellido");
		primerApellidoCampoLabel.setBounds(505, 15, 110, 20);
        frame.getContentPane().add(primerApellidoCampoLabel);
        JTextField primerApellidoCampo = new JTextField(15); //set length of the text 
        primerApellidoCampo.setText(usuario.getPrimerApellido());
        primerApellidoCampo.setBounds(605, 15, 130, 20);
		frame.getContentPane().add(primerApellidoCampo);
		
		JLabel segundoApellidoCampoLabel = new JLabel("Segundo apellido");
		segundoApellidoCampoLabel.setBounds(750, 15, 110, 20);
        frame.getContentPane().add(segundoApellidoCampoLabel);
        JTextField segundoApellidoCampo = new JTextField(15); //set length of the text 
        segundoApellidoCampo.setText(usuario.getSegundoApellido());
        segundoApellidoCampo.setBounds(850, 15, 130, 20);
		frame.getContentPane().add(segundoApellidoCampo);
		
		JLabel cedulaCampoLabel = new JLabel("Cédula");
		cedulaCampoLabel.setBounds(15, 40, 110, 20);
        frame.getContentPane().add(cedulaCampoLabel);
        JTextField cedulaCampo = new JTextField(8); //set length of the text  
        cedulaCampo.setText(usuario.getCedula());
        cedulaCampo.setBounds(115, 40, 130, 20);
		frame.getContentPane().add(cedulaCampo);
		
		JLabel fechaNacimientoLabel = new JLabel("Fec. nacimiento");
		fechaNacimientoLabel.setBounds(260, 40, 110, 20);
        frame.getContentPane().add(fechaNacimientoLabel);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField fechaNacimientoCampo = new JFormattedTextField(df);
        fechaNacimientoCampo.setText(usuario.getFecNacimiento());
        fechaNacimientoCampo.setBounds(360, 40, 130, 20);
		frame.getContentPane().add(fechaNacimientoCampo);
		
		JLabel telefonoCampoLabel = new JLabel("Teléfono");
		telefonoCampoLabel.setBounds(505, 40, 110, 20);
        frame.getContentPane().add(telefonoCampoLabel);
        JTextField telefonoCampo = new JTextField(15); //set length of the text  
        telefonoCampo.setText(usuario.getTelefono());
        telefonoCampo.setBounds(605, 40, 130, 20);
		frame.getContentPane().add(telefonoCampo);
		
		JLabel localidadCampoLabel = new JLabel("Loc. y Departamento");
		localidadCampoLabel.setBounds(750, 40, 110, 20);
        frame.getContentPane().add(localidadCampoLabel);
        JTextField localidadCampo = new JTextField(15); //set length of the text  
        localidadCampo.setText(usuario.getLocDepartamento());
        localidadCampo.setBounds(850, 40, 130, 20);
		frame.getContentPane().add(localidadCampo);
		
		JLabel correoPersonalCampoLabel = new JLabel("Correo personal");
		correoPersonalCampoLabel.setBounds(15, 65, 110, 20);
        frame.getContentPane().add(correoPersonalCampoLabel);
        JTextField correoPersonalCampo = new JTextField(8); //set length of the text  
        correoPersonalCampo.setText(usuario.getEmailPersonal());
        correoPersonalCampo.setBounds(115, 65, 130, 20);
		frame.getContentPane().add(correoPersonalCampo);
		
		JLabel ITRLabel = new JLabel("ITR");
		ITRLabel.setBounds(260, 65, 30, 20);
        frame.getContentPane().add(ITRLabel);
        ButtonGroup itrsBtnGr = new ButtonGroup();
        LinkedList<String> itrs;
		try {
			itrs = ControladorLoginRegistro.getItrs();
	        int x = 290;
	        for (String itr : itrs) {
	        	JRadioButton radioBtn = new JRadioButton(itr);
	        	radioBtn.setActionCommand(itr);
	        	radioBtn.setBounds(x,60,100,30);
	        	x += 100;
	        	itrsBtnGr.add(radioBtn);
	        	if (usuario.getItr().getNombre().equals(itr)) {
	        		radioBtn.setSelected(true);
	        	};
	        	frame.getContentPane().add(radioBtn);
	        };
		} catch (NamingException e1) {
			JOptionPane.showMessageDialog(null, "Error al traer los ITRs");
			e1.printStackTrace();
		}
        
        JTextField añoIngresoCampo = new JTextField(15);
        if (usuario.getTipoDeUsuario().equals("ESTUDIANTE")) {
        	JLabel añoIngresoCampoLabel = new JLabel("Año de ingreso");
            añoIngresoCampoLabel.setBounds(750, 65, 110, 20);
            frame.getContentPane().add(añoIngresoCampoLabel);
            añoIngresoCampo.setBounds(850, 65, 130, 20);
            añoIngresoCampo.setText(usuario.getAñoIngreso());
    		frame.getContentPane().add(añoIngresoCampo);
        };
        
        JTextField areaCampo = new JTextField(15);
        ButtonGroup rolBtnGr = new ButtonGroup();
        if (usuario.getTipoDeUsuario().equals("TUTOR")) {
        	JLabel areaCampoLabel = new JLabel("Área");
    		areaCampoLabel.setBounds(750, 65, 50, 20);
            frame.getContentPane().add(areaCampoLabel);
            areaCampo.setBounds(850, 65, 130, 20);
            areaCampo.setText(usuario.getArea());
    		frame.getContentPane().add(areaCampo);
    		
    		JLabel rolLabel = new JLabel("Rol");
    		rolLabel.setBounds(750, 90, 35, 20);
            frame.getContentPane().add(rolLabel);
            LinkedList<String> roles = new LinkedList<String>();
            roles.add("ENCARGADO");
            roles.add("TUTOR");
            int xr = 750;
            for (String rol : roles) {
            	JRadioButton radioBtn = new JRadioButton(rol);
            	radioBtn.setActionCommand(rol);
            	xr += 100;
            	radioBtn.setBounds(xr,85,100,30);
            	rolBtnGr.add(radioBtn);
            	if (usuario.getRol().equals(rol)) {
	        		radioBtn.setSelected(true);
	        	};
            	frame.getContentPane().add(radioBtn);
            };
        };
        
        JRadioButton validar = new JRadioButton("Validar");
        if (usuario.getEstado().equals("NO VALIDADO") || usuario.getEstado().equals("ELIMINADO")) {
        	validar.setBounds(15, 90, 110, 20);
        	frame.getContentPane().add(validar);
        };
        
		JButton confirmarBtn = new JButton("CONFIRMAR CAMBIOS");
		confirmarBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

				String primerNombre = primerNombreCampo.getText();
    			String segundoNombre = segundoNombreCampo.getText();
    			String primerApellido = primerApellidoCampo.getText();
    			String segundoApellido = segundoApellidoCampo.getText();
    			String cedula = cedulaCampo.getText();
    			String fecNacimiento = fechaNacimientoCampo.getText();
    			String emailPersonal = correoPersonalCampo.getText();
    			String telefono = telefonoCampo.getText();
    			String locDepartamento = localidadCampo.getText();
    			String itr = itrsBtnGr.getSelection().getActionCommand();
    			String añoIngreso = usuario.getTipoDeUsuario().equals("ESTUDIANTE")? añoIngresoCampo.getText() : "";
    			String area = usuario.getTipoDeUsuario().equals("TUTOR")? areaCampo.getText() : "";
    			String rol = usuario.getTipoDeUsuario().equals("TUTOR")? rolBtnGr.getSelection().getActionCommand() : "";
    			String estado = (usuario.getEstado().equals("NO VALIDADO") || usuario.getEstado().equals("ELIMINADO")) && validar.isSelected() ? "VALIDADO" : usuario.getEstado();
    			 
    			if (primerNombre.equals("") || segundoNombre.equals("") || primerApellido.equals("") || segundoApellido.equals("") || cedula.equals("") || fecNacimiento.equals("") || emailPersonal.equals("") || telefono.equals("") || locDepartamento.equals("") || (usuario.getTipoDeUsuario().equals("ESTUDIANTE") && añoIngreso.equals("")) || (usuario.getTipoDeUsuario().equals("TUTOR") && area.equals(""))) {
    				JOptionPane.showMessageDialog(null, "Completar todos los datos requeridos");
    			} else {
    				String respuesta = ControladorModificarUsuario.modificar(usuario.getEmailInstitucional(),primerNombre,segundoNombre,primerApellido,segundoApellido,cedula,fecNacimiento,emailPersonal,telefono,locDepartamento,itr,añoIngreso,area,rol,estado);
	    	        JOptionPane.showMessageDialog(null, respuesta);
    			};

    		}
        });
		confirmarBtn.setBounds(150, 90, 190, 20);
		frame.getContentPane().add(confirmarBtn);
		
		frame.setTitle("MODIFICAR USUARIO");
		frame.setVisible(true);
		
	}
}
