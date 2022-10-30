package Controladores;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.AccionReclamo;
import com.entities.Analista;
import com.exception.ServiciosException;
import com.service.AnalistaBeanRemote;
import com.service.modulo2.AccionReclamoBeanRemote;
import com.service.modulo2.ReclamoBeanRemote;

import Clases.Reclamo;

public class ControladorModificarReclamoA {

	public static boolean agregarAcción(String nombreUsuarioAnalista, String accion, Reclamo reclamo) throws NamingException, ServiciosException {
		
		AccionReclamoBeanRemote accionReclamoBean = (AccionReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/AccionReclamoBean!com.service.modulo2.AccionReclamoBeanRemote");
		AccionReclamo accionReclamo = new AccionReclamo();
		accionReclamo.setDetalle(accion);
		
		Long idAnalista;
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote)
				InitialContext.doLookup("PDT1erAño/AnalistaBean!com.service.AnalistaBeanRemote");
		List<Analista> analistasBack = analistaBean.obtenerTodos();
		for (Analista a : analistasBack) {
			if (a.getUsuario().getNombreUsuario().equals(nombreUsuarioAnalista)) {
				idAnalista = a.getId();
				
				ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
				List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerTodos();
				for (com.entities.Reclamo reclamoB : reclamosBack) {
					if (reclamoB.getTitulo().equals(reclamo.getTitulo()) && reclamoB.getDescripcion().equals(reclamo.getDescripcion())) {
						Long idReclamo = reclamoB.getId();
						
						accionReclamoBean.crear(accionReclamo, idAnalista, idReclamo);
						return true;
					};
				};
			};
		};
		
		return false;
	};
	
	public static boolean modificarEstado(Reclamo reclamo, String estado) throws NamingException, ServiciosException {
		
		ReclamoBeanRemote reclamoBean = (ReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/ReclamoBean!com.service.modulo2.ReclamoBeanRemote");
		List<com.entities.Reclamo> reclamosBack = reclamoBean.obtenerTodos();
		for (com.entities.Reclamo reclamoB : reclamosBack) {
			if (reclamoB.getTitulo().equals(reclamo.getTitulo()) && reclamoB.getDescripcion().equals(reclamo.getDescripcion())) {
				Long idReclamo = reclamoB.getId();
				Long idEstado = ControladorListarEstados.obtenerId(estado);
				
				AccionReclamoBeanRemote accionReclamoBean = (AccionReclamoBeanRemote)
						InitialContext.doLookup("PDT1erAño/AccionReclamoBean!com.service.modulo2.AccionReclamoBeanRemote");
				accionReclamoBean.actualizarEstado(idReclamo,idEstado);
				
				return true;
			};
		};
		
		return false;
	};
}
