package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.EstadoReclamo;
import com.exception.ServiciosException;
import com.service.modulo2.EstadoReclamoBeanRemote;

import Clases.Estado;

public class ControladorListarEstados {

	public static LinkedList<Estado> getEstados() throws NamingException {
		
		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		
		LinkedList<Estado> estados = new LinkedList<Estado>();
		
		List<EstadoReclamo> estadosBack = estadoBean.obtenerTodos();
		
		for (EstadoReclamo est : estadosBack) {
			Estado estado = new Estado(est.getNombre(),est.getEstado());
			estados.add(estado);
		};
		
		return estados;
	};
	
	public static boolean agregar (String nombre) throws NamingException {
		
		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		EstadoReclamo estadoReclamo = new EstadoReclamo();
		estadoReclamo.setNombre(nombre);
		estadoReclamo.setEstado("ACTIVO");
		
		try {
			EstadoReclamo e = estadoBean.crear(estadoReclamo);
		} catch (ServiciosException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	};
	
	public static boolean modificar (Estado estado, String nombre) throws NamingException {

		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		
		try {
			List<EstadoReclamo> estadosBack = estadoBean.obtenerTodos();
			for (EstadoReclamo estReclamo : estadosBack) {
				if (estReclamo.getNombre().equals(nombre)) {
					Long idEstReclamo = estReclamo.getId();
					estadoBean.actualizar(idEstReclamo, nombre);
					estadoBean.modificarEstado(idEstReclamo, "ACTIVO");
					return true;
				};
			};
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	public static boolean eliminar (Estado estado) throws NamingException {

		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		
		try {
			List<EstadoReclamo> estadosBack = estadoBean.obtenerTodos();
			for (EstadoReclamo estReclamo : estadosBack) {
				if (estReclamo.getNombre().equals(estado.getNombre())) {
					Long idEstReclamo = estReclamo.getId();
					estadoBean.modificarEstado(idEstReclamo, "ELIMINADO");
					return true;
				};
			};
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	
	public static boolean activar (Estado estado) throws NamingException {

		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		
		try {
			
			List<EstadoReclamo> estadosBack = estadoBean.obtenerTodos();
			for (EstadoReclamo estReclamo : estadosBack) {
				if (estReclamo.getNombre().equals(estado.getNombre())) {
					Long idEstReclamo = estReclamo.getId();
					estadoBean.modificarEstado(idEstReclamo, "ACTIVO");
					return true;
				};
			};
			
			
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	
	public static Long obtenerId (String nombre) throws NamingException {

		EstadoReclamoBeanRemote estadoBean = (EstadoReclamoBeanRemote)
				InitialContext.doLookup("PDT1erAño/EstadoReclamoBean!com.service.modulo2.EstadoReclamoBeanRemote");
		
		List<EstadoReclamo> estadosBack = estadoBean.obtenerTodos();
		for (EstadoReclamo estReclamo : estadosBack) {
			if (estReclamo.getNombre().equals(nombre)) {
				Long idEstReclamo = estReclamo.getId();
				return idEstReclamo;
			}
		};;
		
		return null;
	};
}
