package Controladores;

import java.util.LinkedList;

import Clases.Estado;

public class ControladorListarEstados {

	public static LinkedList<Estado> getEstados() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<Estado> estados = new LinkedList<Estado>();
		
		Estado i1 = new Estado("ACTIVO", "ACTIVO");
		Estado i2 = new Estado("SIN RESOLVER", "ELIMINADO");
		
		estados.add(i1);
		estados.add(i2);
		
		return estados;
	};
	
	public static boolean agregar (String nombre) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
	
	public static boolean modificar (Estado estado, String nombre) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
	
	public static boolean eliminar (Estado estado) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
}
