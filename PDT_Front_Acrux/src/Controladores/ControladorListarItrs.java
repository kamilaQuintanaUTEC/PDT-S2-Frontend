package Controladores;

import java.util.LinkedList;

import Clases.Itr;

public class ControladorListarItrs {

	public static LinkedList<Itr> getItrs() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<Itr> itrs = new LinkedList<Itr>();
		
		Itr i1 = new Itr("Fray Bentos", "ACTIVO");
		Itr i2 = new Itr("Centro-Sur", "ELIMINADO");
		
		itrs.add(i1);
		itrs.add(i2);
		
		return itrs;
	};
	
	public static boolean agregar (String nombre) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
	
	public static boolean modificar (Itr itr, String nombre) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
	
	public static boolean eliminar (Itr itr) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		return true;
	};
}
