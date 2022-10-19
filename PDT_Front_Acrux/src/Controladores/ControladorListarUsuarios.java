package Controladores;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Clases.Usuario;

public class ControladorListarUsuarios {

	public static LinkedList<Usuario> getUsuarios() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		
		Usuario s1 = new Usuario("Test1", "", "Test1", "", "12345678", "20/01/2000", "test1@test.com", "999999999", "Casa", "test1@utec.edu.uy", "testContraseña1", "Centro-Sur", "Estudiante", "2020", "", "", "VALIDADO");
		
		Usuario s2 = new Usuario("Test2", "", "Test2", "", "87654321", "20/02/2000", "test2@test.com", "888888888", "Patio", "test2@utec.edu.uy", "testContraseña2", "Fray Bentos", "Tutor", "", "Area", "Encargado", "SIN VALIDAR");
		
		usuarios.add(s1);
		usuarios.add(s2);
		
		return usuarios;
	};
	
	public static LinkedList<Usuario> filtrar(LinkedList<Usuario> usuarios, String tipoDeUsuario, String itr, String añoIngreso, String estado) {
		
		int i = 0;
		while (usuarios.size()>0 && i<usuarios.size()) {
			
			if (!tipoDeUsuario.isBlank() && !usuarios.get(i).getTipoDeUsuario().equals(tipoDeUsuario)) {
				usuarios.remove(i);
			} else if (!itr.isBlank() && !usuarios.get(i).getItr().equals(itr)) {
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
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<String> estados = new LinkedList<String>();
		estados.add("SIN VALIDAR");
		estados.add("VALIDADO");
		estados.add("ELIMINADO");
		return estados;
	}
	
	public static boolean eliminar(String cedula) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirma la eliminación?");
        // 0=yes, 1=no, 2=cancel
        if (confirmacion == 0) {
        	System.out.println("A IMPLEMENTAR");
			//IMPLEMENTAR
        	if (true) {
        		JOptionPane.showMessageDialog(null, "Usuario eliminado");
        		return true;
        	} else {
				JOptionPane.showMessageDialog(null, "Error");
			};
        }
        
		return false;
	}
}
