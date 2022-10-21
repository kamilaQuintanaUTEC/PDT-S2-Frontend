package Controladores;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Clases.Estado;
import Clases.Reclamo;

public class ControladorListarReclamosA {

	public static LinkedList<Reclamo> getReclamos(String nombre, String estadoNombre) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		LinkedList<Reclamo> reclamos = new LinkedList<Reclamo>();
		
		Estado e1 = new Estado("INGRESADO","ACTIVO");
		
		Reclamo r1 = new Reclamo("Reclamo1", "", "20/01/2000 15:00", "nombreEventoVME", "nombreActividadAPE", 1, "20/01/2000", "Juan", 5, e1, "", "", "");
		
		Reclamo r2 = new Reclamo("Reclamo2", "", "20/02/2000 15:00", "nombreEventoVME", "nombreActividadAPE", 2, "20/01/2000", "Pedro", 7, e1, "", "", "");
		
		reclamos.add(r1);
		reclamos.add(r2);
		
		return reclamos;
	};
	
	public static LinkedList<Estado> getEstados() {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		
		LinkedList<Estado> estados = new LinkedList<Estado>();
		
		Estado e1 = new Estado("INGRESADO","ACTIVO");
		Estado e2 = new Estado("FINALIZADO","ACTIVO");
		
		estados.add(e1);
		estados.add(e2);
		
		return estados;
	};
	
}
