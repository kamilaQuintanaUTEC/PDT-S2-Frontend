package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Estudiante;
import com.exception.ServiciosException;
import com.service.EstudianteBeanRemote;
import com.service.modulo2.ReclamoBeanRemote;

import Clases.Estado;
import Clases.Reclamo;

public class ControladorListarReclamosE {

	public static LinkedList<Reclamo> getReclamos(String nombreUsuario, String estadoNombre) throws NamingException {
		
		LinkedList<Reclamo> reclamos = new LinkedList<Reclamo>();
		
		Long idEstudiante;
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
		for (Estudiante e : estudiantesBack) {
			if (e.getUsuario().getNombreUsuario().equals(nombreUsuario)) {
				idEstudiante = e.getId();
				
				ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
				
				List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerReclamosEstudiante(idEstudiante);
				
				for (com.entities.Reclamo r : reclamosBack) {
					Estado e1 = new Estado(r.getEstado().getNombre(),r.getEstado().getEstado());
					if (!estadoNombre.equals("") && e1.getNombre().equals(estadoNombre)) {
						Reclamo reclamo = new Reclamo(
								r.getTitulo(),
								r.getDescripcion(),
								r.getFechaReclamo().toString(),
								r.getNombreEvento(),
								r.getNombreActividad(),
								Integer.valueOf(r.getSemestre()),
								r.getFechaEvento().toString(),
								r.getDocente(),
								Integer.valueOf(r.getCreditos()),
								e1,
								"","",""
						);
						reclamos.add(reclamo);
					} else if (estadoNombre.equals("")) {
						Reclamo reclamo = new Reclamo(
								r.getTitulo(),
								r.getDescripcion(),
								r.getFechaReclamo().toString(),
								r.getNombreEvento(),
								r.getNombreActividad(),
								Integer.valueOf(r.getSemestre()),
								r.getFechaEvento().toString(),
								r.getDocente(),
								Integer.valueOf(r.getCreditos()),
								e1,
								"","",""
						);
						reclamos.add(reclamo);
					};
				};
			};
		};
		
		return reclamos;
	};
	
	public static LinkedList<Estado> getEstados() throws NamingException {
		return ControladorListarEstados.getEstados();
	};
	
	public static boolean eliminar(Reclamo reclamo) throws NamingException, ServiciosException {
		
		ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
		
		List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerTodos();
		for (com.entities.Reclamo r : reclamosBack) {
			if (r.getTitulo().equals(reclamo.getTitulo()) && r.getDescripcion().equals(reclamo.getDescripcion())) {
				reclamoBean.deleteReclamo(r.getId());
				return true;
			};
		};
		
		return false;
	}
}
