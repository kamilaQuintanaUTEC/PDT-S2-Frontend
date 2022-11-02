package Controladores;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.exception.ServiciosException;
import com.service.EstudianteBeanRemote;
import com.service.ITRBeanRemote;
import com.service.TutorBeanRemote;
import com.service.UsuarioBeanRemote;

import Clases.Itr;
import Clases.Usuario;

public class ControladorModificarDatosPropios {
	
	public static Usuario getUsuario(String nombreUsuario) throws NamingException {
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
		List<com.entities.Usuario> usuariosBack = usuarioBean.obtenerTodos();
		for (com.entities.Usuario u : usuariosBack) {
			if (u.getNombreUsuario().equals(nombreUsuario)) {
				Itr itr = new Itr(u.getItr().getNombre(),u.getItr().getEstado());
				String area = "";
				String rol = "";
				String añoIngreso = "";
				switch (u.getTipoUsuario()) {
					case "TUTOR":
						TutorBeanRemote tutorBean = (TutorBeanRemote)
						InitialContext.doLookup("PDT1erAño/TutorBean!com.service.TutorBeanRemote");
						List<Tutor> tutores = tutorBean.obtenerTodos();
						for (Tutor t : tutores) {
							if (t.getUsuario().getId().equals(u.getId())) {
								area = t.getArea();
								rol = t.getTipoTutor();
							};
						};
						break;
					case "ESTUDIANTE":
						EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
						List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
						for (Estudiante e : estudiantesBack) {
							if (e.getUsuario().getId().equals(u.getId())) {
								añoIngreso = e.getGeneracion();
							};
						};
						break;
				};
				Usuario usuario = new Usuario(
						u.getNombre(),
						u.getNombre2(),
						u.getApellido(),
						u.getApellido2(),
						u.getDocumento(),
						u.getFechaNacimiento(),
						u.getCorreo(),
						u.getTelefono(),
						u.getLocalidad(),
						nombreUsuario,
						u.getContraseña(),
						itr,
						u.getTipoUsuario(),
						añoIngreso,
						area,
						rol,
						u.getEstado()
				);
				return usuario;
			};
		};
		return null;
	}
	
	public static String modificar(
			String emailInstitucional,
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
			
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma los cambios?");
	        // 0=yes, 1=no, 2=cancel
	        if (confirmacion == 0) {
	        	
	        	UsuarioBeanRemote usuarioBean;
				try {
					usuarioBean = (UsuarioBeanRemote)
							InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
		        	List<com.entities.Usuario> uList = usuarioBean.obtenerTodos();
		    		for (com.entities.Usuario u : uList) {
		    			if (u.getNombreUsuario().equals(emailInstitucional)) {
		    				u.setNombre(primerNombre);
		    				u.setNombre2(segundoNombre);
		    				u.setApellido(primerApellido);
		    				u.setApellido2(segundoApellido);
		    				u.setDocumento(cedula);
		    				u.setTelefono(telefono);
		    				u.setCorreo(emailPersonal);
		    				u.setFechaNacimiento(fecNacimiento);
		    				u.setLocalidad(locDepartamento);
		    				u.setContraseña(contraseña);
		    				///ITR
		    				ITRBeanRemote itrBean = (ITRBeanRemote)
		    		    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
		    				List<ITR> itrsBack = itrBean.obtenerTodos();
		    				for (ITR i : itrsBack) {
		    					if (i.getNombre().equals(itr)) {
		    						u.setItr(i);
		    					}
		    				};
		    				///
		    				switch (u.getTipoUsuario()) {
		    					case "TUTOR":
		    						TutorBeanRemote tutorBean = (TutorBeanRemote)
		    						InitialContext.doLookup("PDT1erAño/TutorBean!com.service.TutorBeanRemote");
		    						List<Tutor> tutores = tutorBean.obtenerTodos();
		    						for (Tutor t: tutores) {
		    							if (t.getUsuario().getId().equals(u.getId())) {
		    								tutorBean.modificarTutor(area, rol, t.getId());
				    						break;
		    							};
		    						};
		    					case "ESTUDIANTE":
		    						EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
		    						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		    						List<Estudiante> estudiantes = estudianteBean.obtenerGeneracionSemestre();
		    						for (Estudiante e: estudiantes) {
		    							if (e.getUsuario().getId().equals(u.getId())) {
		    								estudianteBean.modificarEstudiante(añoIngreso, "", e.getId());
				    						break;
		    							};
		    						};
		    				};
		    				usuarioBean.actualizarUsuarioAuto(u.getId(),u);
		    				respuesta +="Cambios hechos.";
		    			};
		    		}
				} catch (NamingException e) {
					respuesta +="Error al buscar los beans.";
					e.printStackTrace();
				} catch (ServiciosException e) {
					respuesta +="Error.";
					e.printStackTrace();
				};
	        };
		};
		
		return respuesta;

	};
	
}
