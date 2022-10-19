package Controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ControladorModificarUsuario {

	public static String modificar(
			String primerNombre,
			String segundoNombre,
			String primerApellido,
			String segundoApellido,
			String cedula,
			String fecNacimiento,
			String emailPersonal,
			String telefono,
			String locDepartamento,
			String itr,
			String añoIngreso,
			String area,
			String rol,
			String estado
	) {
		
		//controlar formato de mail personal
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailPersonal);
		boolean mailPersonalCorrecto = matcher.find();
		
		String respuesta = "";
		
		if (!mailPersonalCorrecto) {
			respuesta += "Verificar formato del correo personal, debe ser ejemplo@ejemplo.com\n";
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma los cambios?");
	        // 0=yes, 1=no, 2=cancel
	        if (confirmacion == 0) {
	        	System.out.println("A IMPLEMENTAR");
				//IMPLEMENTAR
	        	respuesta +="Cambios hechos.";
	        };
		};
		
		return respuesta;
	};
}
