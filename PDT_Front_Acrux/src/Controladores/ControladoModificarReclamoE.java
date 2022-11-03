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

	public static boolean modificar(String nombreUsuario, String tituloInicial, String titulo, String descripcion, String nombreEventoVME, String nombreActividadAPE, String semestre, String fecha, String docente, String creditos) throws NamingException, ServiciosException {
		
		Long idEstudiante;
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
		for (Estudiante e : estudiantesBack) {
			if (e.getUsuario().getNombreUsuario().equals(nombreUsuario)) {
				idEstudiante = e.getId();
				
				ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
				List<Reclamo> reclamos = reclamoBean.obtenerTodos();
				for (Reclamo r : reclamos) {
					if (r.getEstudiante().getId().equals(idEstudiante) && r.getTitulo().equals(tituloInicial)) {
						r.setTitulo(titulo);
						r.setDescripcion(descripcion);
						r.setNombreEvento(nombreEventoVME);
						r.setNombreActividad(nombreActividadAPE);
						r.setSemestre(semestre);
						r.setFechaEvento(fecha);
						r.setDocente(docente);
						r.setCreditos(creditos );
						reclamoBean.actualizarReclamo(r.getId(), r);
						return true;
					};
				};
			};
		};
		
		return false;
	};
}
