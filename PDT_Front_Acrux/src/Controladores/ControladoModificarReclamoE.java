package Controladores;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Estudiante;
import com.entities.Reclamo;
import com.exception.ServiciosException;
import com.service.EstudianteBeanRemote;
import com.service.modulo2.ReclamoBeanRemote;

public class ControladoModificarReclamoE {

	public static boolean modificar(String nombreUsuario, String tituloInicial, String titulo, String descripcion, String nombreEventoVME, String nombreActividadAPE, int semestre, String fecha, String docente, int creditos) throws NamingException, ServiciosException {
		
		Long idEstudiante;
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
		for (Estudiante e : estudiantesBack) {
			if (e.getUsuario().getNombreUsuario().equals(nombreUsuario)) {
				idEstudiante = e.getId();
				
				ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
				List<Reclamo> reclamos = reclamoBean.obtenerReclamosEstudiante(idEstudiante);
				for (Reclamo r : reclamos) {
					if (r.getTitulo().equals(tituloInicial)) {
						r.setTitulo(titulo);
						r.setDescripcion(descripcion);
						r.setNombreEvento(nombreEventoVME);
						r.setNombreActividad(nombreActividadAPE);
						r.setSemestre(Integer.valueOf(semestre).toString());
						r.setFechaEvento(fecha);
						r.setDocente(docente);
						r.setCreditos(Integer.valueOf(creditos).toString());
						reclamoBean.actualizarReclamo(r.getId(), r);
						return true;
					};
				};
			};
		};
		
		return false;
	};
}
