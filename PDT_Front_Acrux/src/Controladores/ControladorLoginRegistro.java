package Controladores;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.service.AnalistaBeanRemote;
import com.service.EstudianteBeanRemote;
import com.service.TutorBeanRemote;
import com.service.UsuarioBeanRemote;

import Clases.Itr;

public class ControladorLoginRegistro {
	
	public static String login(String nombreUsuario, String contraseña) throws NamingException {
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
		List<Usuario> usuarios =usuarioBean.login(nombreUsuario,contraseña);
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equals(nombreUsuario) && 
				u.getContraseña().equals(contraseña) &&
				u.getEstado().equals("VALIDADO")
			) {
				return u.getTipoUsuario();
			};
		};
		
		return "NO VALIDADO";

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
		boolean mailUtec = emailInstitucional.contains("@utec.edu.uy");
		
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
			
			Usuario usuario = new Usuario();
			usuario.setNombre(primerNombre);
			usuario.setNombre2(segundoNombre);
			usuario.setApellido(primerApellido);
			usuario.setApellido2(segundoApellido);
			usuario.setDocumento(cedula);
			usuario.setDepartamento("");
			usuario.setTelefono(telefono);
			usuario.setNombreUsuario(emailInstitucional);
			usuario.setCorreo(emailPersonal);
			usuario.setContraseña(contraseña);
			usuario.setFechaNacimiento(fecNacimiento);
			usuario.setGenero("");
			usuario.setLocalidad(locDepartamento);
			usuario.setTipoUsuario(tipoDeUsuario);
			usuario.setOtroTipoUsuario("");
			usuario.setEstado("NO VALIDADO"); 
			
			Long idItr = null;
			UsuarioBeanRemote usuarioBean;
			
			try {
				idItr = ControladorListarItrs.obtenerId(itr);
			} catch (NamingException e) {
				mensaje += "No se obtuvo id del Itr";
				e.printStackTrace();
			}
			try {
				usuarioBean = (UsuarioBeanRemote)
						InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
				Usuario u = usuarioBean.crear(usuario,idItr);
				Long idU = u.getId();
				switch (tipoDeUsuario) {
					case "ANALISTA": 
						AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
						InitialContext.doLookup("PDT1erAño/AnalistaBean!com.service.AnalistaBeanRemote");
						Analista a = analistaBean.crear(idU);
					case "TUTOR": 
						TutorBeanRemote tutorBean = (TutorBeanRemote)
						InitialContext.doLookup("PDT1erAño/TutorBean!com.service.TutorBeanRemote");
						Tutor tutor = tutorBean.crear(idU, area, rol);
					case "ESTUDIANTE": 
						EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
						Estudiante e = estudianteBean.crear(idU, añoIngreso,"1");
				};
				
				mensaje += "La solicitud será revisada antes de estar activa";
				
			} catch (NamingException e) {
				mensaje += "No se accedió al bean de usuario";
				e.printStackTrace();
			} catch (ServiciosException e) {
				mensaje += "No se pudo crear el usuario";
				e.printStackTrace();
			}
		};
		
		return mensaje;
	}
	
	public static LinkedList<String> getItrs() throws NamingException {
		
		LinkedList<Itr> itrs = ControladorListarItrs.getItrs();
		
		LinkedList<String> itrsNombres = new LinkedList<String>();
		
		for (Itr i : itrs) {
			if (i.getEstado().equals("ACTIVO")) {
				itrsNombres.add(i.getNombre());
			};
		};
		
		return itrsNombres;
	}
	
	public static LinkedList<String> getTipoDeUsuarios() {

		LinkedList<String> usuarios = new LinkedList<String>();
		usuarios.add("ESTUDIANTE");
		usuarios.add("ANALISTA");
		usuarios.add("TUTOR");
		return usuarios;
		
	}
}
