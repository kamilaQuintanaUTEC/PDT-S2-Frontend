package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.Estudiante;
import com.service.EstudianteBeanRemote;
import com.service.modulo2.ReclamoBeanRemote;

import Clases.Estado;
import Clases.Reclamo;

public class ControladorListarReclamosA {

	public static LinkedList<Reclamo> getReclamos(String nombreUsuario, String estadoNombre) throws NamingException {

		ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		
		LinkedList<Reclamo> reclamos = new LinkedList<Reclamo>();
		
		if (!nombreUsuario.equals("")) {
			List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
			for (Estudiante e : estudiantesBack) {
				if (e.getUsuario().getNombreUsuario().equals(nombreUsuario)) {
					Long idEstudiante = e.getId();
					List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerReclamosEstudiante(idEstudiante);
					for (com.entities.Reclamo r : reclamosBack) {
						Estado e1 = new Estado(r.getEstado().getNombre(),r.getEstado().getEstado());
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
								"",
								"",
								""
						);
						reclamos.add(reclamo);
					};
				};
			};
		} else {
			List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerTodos();
			for (com.entities.Reclamo r : reclamosBack) {
				Estado e1 = new Estado(r.getEstado().getNombre(),r.getEstado().getEstado());
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
						"",
						"",
						""
				);
				reclamos.add(reclamo);
			};
		};
		
		if (!estadoNombre.equals("")) {
			for (Reclamo r : reclamos) {
				if (!r.getEstado().getNombre().equals(estadoNombre)) {
					reclamos.remove(r);
				};
			};
		};

		return reclamos;
	};
	
	public static LinkedList<Estado> getEstados() throws NamingException {
		return ControladorListarEstados.getEstados();
	};
	
}
