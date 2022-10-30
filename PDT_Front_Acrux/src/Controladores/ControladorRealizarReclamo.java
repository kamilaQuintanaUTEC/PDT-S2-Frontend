package Controladores;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Estudiante;
import com.entities.Reclamo;
import com.exception.ServiciosException;
import com.service.EstudianteBeanRemote;
import com.service.modulo2.ReclamoBeanRemote;

public class ControladorRealizarReclamo {

	public static String agregar (
			String nombreUsuario,
			String titulo,
			String descripcion,
			String nombreEventoVME,
			String nombreActividadAPE,
			int semestre,
			String fecha,
			String docente,
			int creditos
	) throws NamingException, ServiciosException {

		Reclamo reclamo = new Reclamo();
		reclamo.setTitulo(titulo);
		reclamo.setDescripcion(descripcion);
		reclamo.setNombreEvento(nombreEventoVME);
		reclamo.setNombreActividad(nombreActividadAPE);
		reclamo.setSemestre(Integer.valueOf(semestre).toString());
		reclamo.setFechaEvento(fecha);
		reclamo.setDocente(docente);
		reclamo.setCreditos(Integer.valueOf(creditos).toString());
		
		String respuesta = "";
		
		Long idEstudiante;
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote)
						InitialContext.doLookup("PDT1erAño/EstudianteBean!com.service.EstudianteBeanRemote");
		List<Estudiante> estudiantesBack = estudianteBean.obtenerGeneracionSemestre();
		for (Estudiante e : estudiantesBack) {
			if (e.getUsuario().getNombreUsuario().equals(nombreUsuario)) {
				idEstudiante = e.getId();
				Long idEstado = ControladorListarEstados.obtenerId("INGRESADO");
				ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
				reclamoBean.crear(reclamo, idEstudiante, idEstado);
				
				return respuesta+="Reclamo enviado";
			};
		};
		
		return respuesta+="No se pudo enviar el reclamo";

	};
}
