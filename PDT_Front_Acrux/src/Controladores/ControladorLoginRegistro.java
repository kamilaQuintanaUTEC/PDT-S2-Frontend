package Controladores;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorLoginRegistro {
	
	public static String login(String nombreUsuario, String contraseña) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		//según tipo de usuario:
//		return "NO VALIDADO";
		return "ESTUDIANTE";
//		return "TUTOR";
//		return "ANALISTA";
	}
	
	public static String registro(
			String primerNombre,
			String segundoNombre,
			String primerApellido,
			String segundoApellido,
			String cedula,
			String fecNacimiento,
			String emailPersonal,
			String telefono,
			String locDepartamento,
			String emailInstitucional,
			String contraseña,
			String itr,
			String tipoDeUsuario,
			String añoIngreso,
			String area,
			String rol
	) {
		
		//controlar formato de mail personal
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailPersonal);
		boolean mailPersonalCorrecto = matcher.find();

		//controlar email académico pertenezca al dominio utec.edu.uy
		boolean mailUtec = emailInstitucional.contains("utec.edu.uy");
		
		//controlar que contraseña contenga letras y números, al menos 8 caracteres
		String contraseñaLetRegex = ".*[a-zA-Z].*";
		String contraseñaNumRegex = ".*[0-9].*";
		boolean contraseñaValida = contraseña.matches(contraseñaLetRegex) && contraseña.matches(contraseñaLetRegex) && contraseña.length()>7;
		
		String mensaje = "";
		
		if (!mailPersonalCorrecto) {
			mensaje += "Verificar formato del correo personal, debe ser ejemplo@ejemplo.com\n";
		};
		
		if (!mailUtec) {
			mensaje += "Verificar que el correo institucional sea del dominio utec.edu.uy\n";
		};
		
		if (!contraseñaValida) {
			mensaje += "Verificar que la contraseña contenga letras, números y al menos 8 caracteres.";
		};
		
		if (mailPersonalCorrecto && mailUtec && contraseñaValida) {
			System.out.println("A IMPLEMENTAR");
			//IMPLEMENTAR
			mensaje += "La solicitud será revisada antes de estar activa";
		};
		
		return mensaje;
	}
	
	public static LinkedList<String> getItrs() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<String> itrs = new LinkedList<String>();
		itrs.add("Centro-Sur");
		itrs.add("Fray Bentos");
		return itrs;
	}
	
	public static LinkedList<String> getTipoDeUsuarios() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<String> usuarios = new LinkedList<String>();
		usuarios.add("Estudiante");
		usuarios.add("Analista");
		usuarios.add("Tutor");
		return usuarios;
	}
}
