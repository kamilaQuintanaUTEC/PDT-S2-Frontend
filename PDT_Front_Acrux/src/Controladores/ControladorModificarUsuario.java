package Controladores;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.ITR;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.service.EstudianteBeanRemote;
import com.service.ITRBeanRemote;
import com.service.TutorBeanRemote;
import com.service.UsuarioBeanRemote;

public class ControladorModificarUsuario {

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
		    						tutorBean.modificarTutor(area, rol, u.getId());
		    						break;
		    					case "ESTUDIANTE":
		    						EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
		    						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		    						estudianteBean.modificarEstudiante(añoIngreso, "", u.getId());
		    						break;
		    				};
		    				u.setEstado(estado);
		    				usuarioBean.actualizarUsuarioAdministrador(u.getId(),u);
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
	
	public static void activarEstado(String nombreUsuario) {
		UsuarioBeanRemote usuarioBean;
		try {
			usuarioBean = (UsuarioBeanRemote)
					InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
        	List<com.entities.Usuario> uList = usuarioBean.obtenerTodos();
    		for (com.entities.Usuario u : uList) {
    			if (u.getNombreUsuario().equals(nombreUsuario)) {
    				usuarioBean.actualizarEstado(u.getId(), "VALIDADO");
    			};
    		};
    	} catch (NamingException e) {
    		JOptionPane.showMessageDialog(null, "Error al buscar los beans");
			e.printStackTrace();
		} catch (ServiciosException e) {
			JOptionPane.showMessageDialog(null, "Error al usar los servicios");
			e.printStackTrace();
		}; 
    				
	};
}
