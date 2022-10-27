package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.exception.ServiciosException;
import com.service.UsuarioBeanRemote;

import Clases.Itr;
import Clases.Usuario;

public class ControladorListarUsuarios {

	public static LinkedList<Usuario> getUsuarios() throws NamingException {
		
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
		List<com.entities.Usuario> uList = usuarioBean.obtenerTodos();
		for (com.entities.Usuario u : uList) {
			Itr nuevoI = new Itr(u.getItr().getNombre(),u.getItr().getEstado());
			Usuario nuevoU = new Usuario(
					u.getNombre(),
					u.getNombre2(),
					u.getApellido(),
					u.getApellido2(),
					u.getDocumento(),
					u.getFechaNacimiento(),
					u.getCorreo(),
					u.getTelefono(),
					u.getLocalidad(),
					u.getNombreUsuario(),
					u.getContraseña(),
					nuevoI,
					u.getTipoUsuario(),
					"",
					"",
					"",
					u.getEstado()
			);
			usuarios.add(nuevoU);
		};
		
		return usuarios;
	};
	
	
	public static LinkedList<Usuario> filtrar(LinkedList<Usuario> usuarios, String tipoDeUsuario, String itr, String añoIngreso, String estado) {
		
		int i = 0;
		while (usuarios.size()>0 && i<usuarios.size()) {
			
			if (!tipoDeUsuario.isBlank() && !usuarios.get(i).getTipoDeUsuario().equals(tipoDeUsuario)) {
				usuarios.remove(i);
			} else if (!itr.isBlank() && !usuarios.get(i).getItr().getNombre().equals(itr)) {
				usuarios.remove(i);
			} else if (!añoIngreso.isBlank() && !usuarios.get(i).getAñoIngreso().equals(añoIngreso) && usuarios.get(i).getTipoDeUsuario().equals("Estudiante")) {
				usuarios.remove(i);
			} else if (!estado.isBlank() && !usuarios.get(i).getEstado().equals(estado)) {
				usuarios.remove(i);
			} else {
				i = i + 1;
			};
			
		}

		return usuarios;
	};
	
	
	public static LinkedList<String> getEstados() {
		
		LinkedList<String> estados = new LinkedList<String>();
		estados.add("NO VALIDADO");
		estados.add("VALIDADO");
		estados.add("ELIMINADO");
		return estados;
		
	};
	
	
	public static boolean eliminar(String cedula) throws NamingException, ServiciosException {
		
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma la eliminación?");
        // 0=yes, 1=no, 2=cancel
        if (confirmacion == 0) {
        	
        	UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
    				InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
        	List<com.entities.Usuario> uList = usuarioBean.obtenerTodos();
    		for (com.entities.Usuario u : uList) {
    			if (u.getDocumento().equals(cedula)) {
    				usuarioBean.actualizarEstado(u.getId(),"ELIMINADO");
    				return true;
    			};
    		};

        }
        
		return false;
	};
	
	
	public static boolean reactivar(String cedula) throws NamingException, ServiciosException {
		
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma la reactivación?");
        // 0=yes, 1=no, 2=cancel
        if (confirmacion == 0) {
        	
        	UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
    				InitialContext.doLookup("PDT1erAño/UsuarioBean!com.service.UsuarioBeanRemote");
        	List<com.entities.Usuario> uList = usuarioBean.obtenerTodos();
    		for (com.entities.Usuario u : uList) {
    			if (u.getDocumento().equals(cedula)) {
    				usuarioBean.actualizarEstado(u.getId(),"VALIDADO");
    				return true;
    			};
    		};

        }
        
		return false;
	}
}
