package Controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Clases.Usuario;

public class ControladorModificarDatosPropios {
	
	public static Usuario getUsuario(String nombreUsuario) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		Usuario s1 = new Usuario("Test1", "", "Test1", "", "12345678", "20/01/2000", "test1@test.com", "999999999", "Casa", nombreUsuario, "testContraseña1", null, "Analista", "", "", "", "VALIDADO");
		return s1;
	}
	
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
			String contraseña,
			String itr,
			String añoIngreso,
			String area,
			String rol
	) {
		
		//controlar formato de mail personal
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailPersonal);
		boolean mailPersonalCorrecto = matcher.find();
		
		//controlar que contraseña contenga letras y números, al menos 8 caracteres
		String contraseñaLetRegex = ".*[a-zA-Z].*";
		String contraseñaNumRegex = ".*[0-9].*";
		boolean contraseñaValida = contraseña.matches(contraseñaLetRegex) && contraseña.matches(contraseñaLetRegex) && contraseña.length()>7;
		
		String respuesta = "";
		
		if (!mailPersonalCorrecto) {
			respuesta += "Verificar formato del correo personal, debe ser ejemplo@ejemplo.com\n";
		};
		
		if (!contraseñaValida) {
			respuesta += "Verificar que la contraseña contenga letras, números y al menos 8 caracteres.";
		};
		
		if (mailPersonalCorrecto && contraseñaValida) {
			System.out.println("A IMPLEMENTAR");
			//IMPLEMENTAR
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
