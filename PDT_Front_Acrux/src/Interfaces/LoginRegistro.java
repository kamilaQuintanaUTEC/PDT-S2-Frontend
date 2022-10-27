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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controladores.ControladorLoginRegistro;

public class LoginRegistro {  

		public LoginRegistro() {
			initialize();
		}
	      
		private void initialize() {

			JFrame frame = new JFrame();
			frame.setBounds(50, 100, 1100, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel tituloIncioSesionLabel = new JLabel("INICIAR SESIÓN");
			tituloIncioSesionLabel.setBounds(15, 15, 100, 20);
	        frame.getContentPane().add(tituloIncioSesionLabel);
			
	        JLabel nombreUsuarioCampoLabel = new JLabel();  
	        nombreUsuarioCampoLabel.setText("Correo electrónico");
	        nombreUsuarioCampoLabel.setBounds(15, 40, 110, 20);
	        frame.getContentPane().add(nombreUsuarioCampoLabel);
	        JTextField nombreUsuarioCampo = new JTextField(15); //set length of the text  
	        nombreUsuarioCampo.setBounds(130, 40, 130, 20);
			frame.getContentPane().add(nombreUsuarioCampo);
	  
			JLabel contraseñaCampoLabel = new JLabel("Contraseña");
	        contraseñaCampoLabel.setBounds(15, 65, 110, 20);
	        frame.getContentPane().add(contraseñaCampoLabel);
	        JPasswordField contraseñaCampo = new JPasswordField(15);    //set length for the password  
	        contraseñaCampo.setBounds(130, 65, 130, 20);
			frame.getContentPane().add(contraseñaCampo);
	          
			JButton ingresarBtn = new JButton("INGRESAR");
	        ingresarBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			
	    	        String nombreUsuario = nombreUsuarioCampo.getText();
	    	        String contraseña = contraseñaCampo.getText();
	    	        
	    	        String tipoDeUsuario;
					try {
						tipoDeUsuario = ControladorLoginRegistro.login(nombreUsuario,contraseña);
		    	        switch (tipoDeUsuario){
		    	        	case "NO VALIDADO": JOptionPane.showMessageDialog(null, "Datos incorrectos o usuario no validado aún");
		    	        	break;
		    	        	case "ESTUDIANTE": EstudiantePrincipal estudiantePrincipal = new EstudiantePrincipal(nombreUsuario);
		    	        	break;
		    	        	case "TUTOR": TutorPrincipal tutorPrincipal = new TutorPrincipal(nombreUsuario);
		    	        	break;
		    	        	case "ANALISTA": AnalistaPrincipal analistaPrincipal = new AnalistaPrincipal(nombreUsuario);
		    	        	break;
		    	        }
					} catch (NamingException e1) {
						JOptionPane.showMessageDialog(null, "Error al intentar iniciar sesión");
						e1.printStackTrace();
					}
	    		}
	        });
	        ingresarBtn.setBounds(15, 90, 130, 20);
			frame.getContentPane().add(ingresarBtn);
			
			JLabel lineaDivisoria = new JLabel("---------------------------- ó ----------------------------");
			lineaDivisoria.setBounds(15, 115, 250, 20);
	        frame.getContentPane().add(lineaDivisoria);
	        
	        JLabel tituloRegistroLabel = new JLabel("REGISTRO");
	        tituloRegistroLabel.setBounds(15, 135, 100, 20);
	        frame.getContentPane().add(tituloRegistroLabel);
	        
	        JLabel primerNombreCampoLabel = new JLabel("Primer nombre");
	        primerNombreCampoLabel.setBounds(15, 160, 110, 20);
	        frame.getContentPane().add(primerNombreCampoLabel);
	        JTextField primerNombreCampo = new JTextField(15); //set length of the text  
	        primerNombreCampo.setBounds(115, 160, 130, 20);
			frame.getContentPane().add(primerNombreCampo);
			
			JLabel segundoNombreCampoLabel = new JLabel("Segundo nombre");
			segundoNombreCampoLabel.setBounds(260, 160, 110, 20);
	        frame.getContentPane().add(segundoNombreCampoLabel);
	        JTextField segundoNombreCampo = new JTextField(15); //set length of the text  
	        segundoNombreCampo.setBounds(360, 160, 130, 20);
			frame.getContentPane().add(segundoNombreCampo);
			
			JLabel primerApellidoCampoLabel = new JLabel("Primer apellido");
			primerApellidoCampoLabel.setBounds(505, 160, 110, 20);
	        frame.getContentPane().add(primerApellidoCampoLabel);
	        JTextField primerApellidoCampo = new JTextField(15); //set length of the text  
	        primerApellidoCampo.setBounds(605, 160, 130, 20);
			frame.getContentPane().add(primerApellidoCampo);
			
			JLabel segundoApellidoCampoLabel = new JLabel("Segundo apellido");
			segundoApellidoCampoLabel.setBounds(750, 160, 110, 20);
	        frame.getContentPane().add(segundoApellidoCampoLabel);
	        JTextField segundoApellidoCampo = new JTextField(15); //set length of the text  
	        segundoApellidoCampo.setBounds(850, 160, 130, 20);
			frame.getContentPane().add(segundoApellidoCampo);
			
			JLabel cedulaCampoLabel = new JLabel("Cédula");
			cedulaCampoLabel.setBounds(15, 185, 110, 20);
	        frame.getContentPane().add(cedulaCampoLabel);
	        JTextField cedulaCampo = new JTextField(8); //set length of the text  
	        cedulaCampo.setBounds(115, 185, 130, 20);
			frame.getContentPane().add(cedulaCampo);
			
			JLabel fechaNacimientoLabel = new JLabel("Fec. nacimiento");
			fechaNacimientoLabel.setBounds(260, 185, 110, 20);
	        frame.getContentPane().add(fechaNacimientoLabel);
	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        JFormattedTextField fechaNacimientoCampo = new JFormattedTextField(df);
	        fechaNacimientoCampo.setBounds(360, 185, 130, 20);
			frame.getContentPane().add(fechaNacimientoCampo);
			
			JLabel telefonoCampoLabel = new JLabel("Teléfono");
			telefonoCampoLabel.setBounds(505, 185, 110, 20);
	        frame.getContentPane().add(telefonoCampoLabel);
	        JTextField telefonoCampo = new JTextField(15); //set length of the text  
	        telefonoCampo.setBounds(605, 185, 130, 20);
			frame.getContentPane().add(telefonoCampo);
			
			JLabel localidadCampoLabel = new JLabel("Loc. y Departamento");
			localidadCampoLabel.setBounds(750, 185, 110, 20);
	        frame.getContentPane().add(localidadCampoLabel);
	        JTextField localidadCampo = new JTextField(15); //set length of the text  
	        localidadCampo.setBounds(850, 185, 130, 20);
			frame.getContentPane().add(localidadCampo);
			
			JLabel correoPersonalCampoLabel = new JLabel("Correo personal");
			correoPersonalCampoLabel.setBounds(15, 210, 110, 20);
	        frame.getContentPane().add(correoPersonalCampoLabel);
	        JTextField correoPersonalCampo = new JTextField(8); //set length of the text  
	        correoPersonalCampo.setBounds(115, 210, 130, 20);
			frame.getContentPane().add(correoPersonalCampo);
			
			JLabel correoUtecCampoLabel = new JLabel("Correo UTEC");
			correoUtecCampoLabel.setBounds(260, 210, 110, 20);
	        frame.getContentPane().add(correoUtecCampoLabel);
	        JTextField correoUtecCampo = new JTextField(15); //set length of the text  
	        correoUtecCampo.setBounds(360, 210, 130, 20);
			frame.getContentPane().add(correoUtecCampo);
			
			JLabel contraseñaRCampoLabel = new JLabel("Contraseña");
			contraseñaRCampoLabel.setBounds(505, 210, 110, 20);
	        frame.getContentPane().add(contraseñaRCampoLabel);
	        JTextField contraseñaRCampo = new JTextField(15); //set length of the text  
	        contraseñaRCampo.setBounds(605, 210, 130, 20);
			frame.getContentPane().add(contraseñaRCampo);
			
			JLabel ITRLabel = new JLabel("ITR");
			ITRLabel.setBounds(750, 210, 30, 20);
	        frame.getContentPane().add(ITRLabel);
	        ButtonGroup itrsBtnGr = new ButtonGroup();
	        LinkedList<String> itrs;
			try {
				itrs = ControladorLoginRegistro.getItrs();
				int x = 685;
		        for (String itr : itrs) {
		        	JRadioButton radioBtn = new JRadioButton(itr);
		        	radioBtn.setActionCommand(itr);
		        	x += 100;
		        	radioBtn.setBounds(x,205,100,30);
		        	itrsBtnGr.add(radioBtn);
		        	frame.getContentPane().add(radioBtn);
		        };
			} catch (NamingException e1) {
				JOptionPane.showMessageDialog(null, "Error al traer los ITRs");
				e1.printStackTrace();
			} 
	        
			JLabel tipoDeUsuarioLabel = new JLabel("Tipo de usuario");
			tipoDeUsuarioLabel.setBounds(15, 235, 100, 20);
	        frame.getContentPane().add(tipoDeUsuarioLabel);
	        ButtonGroup usuariosBtnGr = new ButtonGroup();
	        LinkedList<String> usuarios = ControladorLoginRegistro.getTipoDeUsuarios();
	        int xu = -70;
	        for (String usuario : usuarios) {
	        	JRadioButton radioBtn = new JRadioButton(usuario);
	        	radioBtn.setActionCommand(usuario);
	        	xu += 250;
	        	radioBtn.setBounds(xu,230,120,30);
	        	usuariosBtnGr.add(radioBtn);
	        	frame.getContentPane().add(radioBtn);
	        };
	        
	        JLabel añoIngresoCampoLabel = new JLabel("Año de ingreso");
	        añoIngresoCampoLabel.setBounds(180, 260, 110, 20);
	        frame.getContentPane().add(añoIngresoCampoLabel);
	        JTextField añoIngresoCampo = new JTextField(15); //set length of the text  
	        añoIngresoCampo.setBounds(280, 260, 130, 20);
	        frame.getContentPane().add(añoIngresoCampo);
			
			JLabel areaCampoLabel = new JLabel("Área");
			areaCampoLabel.setBounds(680, 260, 50, 20);
	        frame.getContentPane().add(areaCampoLabel);
	        JTextField areaCampo = new JTextField(15); //set length of the text  
	        areaCampo.setBounds(720, 260, 130, 20);
	        frame.getContentPane().add(areaCampo);
			
			JLabel rolLabel = new JLabel("Rol");
			rolLabel.setBounds(680, 285, 35, 20);
	        frame.getContentPane().add(rolLabel);
	        ButtonGroup rolBtnGr = new ButtonGroup();
	        LinkedList<String> roles = new LinkedList<String>();
	        roles.add("ENCARGADO");
	        roles.add("TUTOR");
	        int xr = 610;
	        for (String rol : roles) {
	        	JRadioButton radioBtn = new JRadioButton(rol);
	        	radioBtn.setActionCommand(rol);
	        	xr += 100;
	        	radioBtn.setBounds(xr,280,100,30);
	        	rolBtnGr.add(radioBtn);
	        	frame.getContentPane().add(radioBtn);
	        };
	        
			JButton registrarBtn = new JButton("REGISTRAR");
			registrarBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			try {
	    				String primerNombre = primerNombreCampo.getText();
		    			String segundoNombre = segundoNombreCampo.getText();
		    			String primerApellido = primerApellidoCampo.getText();
		    			String segundoApellido = segundoApellidoCampo.getText();
		    			String cedula = cedulaCampo.getText();
		    			String fecNacimiento = fechaNacimientoCampo.getText();
		    			String emailPersonal = correoPersonalCampo.getText();
		    			String emailInstitucional = correoUtecCampo.getText();
		    			String telefono = telefonoCampo.getText();
		    			String locDepartamento = localidadCampo.getText();
		    			String contraseña = contraseñaRCampo.getText();
		    			String itr = itrsBtnGr.getSelection().getActionCommand();
		    			String tipoDeUsuario = usuariosBtnGr.getSelection().getActionCommand();
		    			String añoIngreso = añoIngresoCampo.getText();
		    			String area = areaCampo.getText();
		    			String rol = usuariosBtnGr.getSelection().getActionCommand().equals("TUTOR") ? rolBtnGr.getSelection().getActionCommand() : "";
		    			
		    			if (primerNombre.equals("") || segundoNombre.equals("") || primerApellido.equals("") || segundoApellido.equals("") || cedula.equals("") || fecNacimiento.equals("") || emailPersonal.equals("") || emailInstitucional.equals("") || telefono.equals("") || locDepartamento.equals("") || contraseña.equals("") || contraseña.equals("") || (tipoDeUsuario.equals("ESTUDIANTE") && añoIngreso.equals("")) || (tipoDeUsuario.equals("TUTOR") && area.equals(""))) {
		    				JOptionPane.showMessageDialog(null, "Completar todos los datos requeridos");
		    			} else {
		    				String respuesta = ControladorLoginRegistro.registro(primerNombre,segundoNombre,primerApellido,segundoApellido,cedula,fecNacimiento,emailPersonal,telefono,locDepartamento,emailInstitucional,contraseña,itr,tipoDeUsuario,añoIngreso,area,rol);
			    	        JOptionPane.showMessageDialog(null, respuesta);
		    			};

	    			} catch (NullPointerException er) {
	    				er.printStackTrace();
	    				System.out.println(er);
	    				if (itrsBtnGr.getSelection() == null ) {
	    					JOptionPane.showMessageDialog(null, "Seleccionar un ITR");
	    				}
	    				if (usuariosBtnGr.getSelection() == null ) {
	    					JOptionPane.showMessageDialog(null, "Seleccionar un tipo de usuario");
	    				}
	    				if (usuariosBtnGr.getSelection().getActionCommand().equals("TUTOR") ) {
	    					JOptionPane.showMessageDialog(null, "Seleccionar un rol");
	    				}
	    			}
   
	    		}
	        });
			registrarBtn.setBounds(15, 310, 130, 20);
			frame.getContentPane().add(registrarBtn);
			
			frame.setTitle("GESTIÓN UNIVERSITARIA");
			frame.setVisible(true);
	    };

}
