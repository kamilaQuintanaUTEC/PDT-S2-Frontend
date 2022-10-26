package Controladores;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ITR;
import com.exception.ServiciosException;
import com.service.ITRBeanRemote;

import Clases.Itr;

public class ControladorListarItrs {

	public static LinkedList<Itr> getItrs() throws NamingException {
		
		ITRBeanRemote itrBean = (ITRBeanRemote)
				InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
		
		LinkedList<Itr> itrs = new LinkedList<Itr>();
		
		List<ITR> itrsBack = itrBean.obtenerTodos();
		
		for (ITR i : itrsBack) {
			Itr itr = new Itr(i.getNombre(),i.getEstado());
			itrs.add(itr);
		};
		
		return itrs;
	};
	
	public static boolean agregar (String nombre) throws NamingException {
		
		ITRBeanRemote itrBean = (ITRBeanRemote)
    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
    	ITR itr = new ITR();
		
		itr.setNombre(nombre);
		itr.setDepartamento("");
		itr.setEstado("ACTIVO");
		
		try {
			ITR i = itrBean.crear(itr);
		} catch (ServiciosException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	};
	
	public static boolean modificar (Itr itr, String nombre) throws NamingException {

		ITRBeanRemote itrBean = (ITRBeanRemote)
    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
    	
		try {
			
			List<ITR> itrsBack = itrBean.obtenerTodos();
			for (ITR i : itrsBack) {
				if (i.getNombre().equals(itr.getNombre())) {
					Long idITR = i.getId();
					itrBean.actualizar(idITR, nombre, "", "ACTIVO");
					return true;
				}
			};
			
			
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	public static boolean eliminar (Itr itr) throws NamingException {
		
		ITRBeanRemote itrBean = (ITRBeanRemote)
    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
    	
		try {
			
			List<ITR> itrsBack = itrBean.obtenerTodos();
			for (ITR i : itrsBack) {
				if (i.getNombre().equals(itr.getNombre())) {
					Long idITR = i.getId();
					itrBean.actualizar(idITR, i.getNombre(), "", "ELIMINADO");
					return true;
				}
			};
			
			
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	public static boolean activar (Itr itr) throws NamingException {

		ITRBeanRemote itrBean = (ITRBeanRemote)
    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
    	
		try {
			
			List<ITR> itrsBack = itrBean.obtenerTodos();
			for (ITR i : itrsBack) {
				if (i.getNombre().equals(itr.getNombre())) {
					Long idITR = i.getId();
					itrBean.actualizar(idITR, i.getNombre(), "", "ACTIVO");
					return true;
				}
			};
			
			
		} catch (ServiciosException e) {
			e.printStackTrace();
		};
		
		return false;
	};
	
	public static Long obtenerId (String nombre) throws NamingException {

		ITRBeanRemote itrBean = (ITRBeanRemote)
    			InitialContext.doLookup("PDT1erAño/ITRBean!com.service.ITRBeanRemote");
    	
		List<ITR> itrsBack = itrBean.obtenerTodos();
		for (ITR i : itrsBack) {
			if (i.getNombre().equals(nombre)) {
				Long idITR = i.getId();
				return idITR;
			}
		};;
		
		return null;
	};
}
