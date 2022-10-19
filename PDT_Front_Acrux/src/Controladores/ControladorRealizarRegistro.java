package Controladores;

public class ControladorRealizarRegistro {

	public static String agregar (
			String titulo,
			String descripcion,
			String nombreEventoVME,
			String nombreActividadAPE,
			int semestre,
			String fecha,
			String docente,
			int creditos
	) {
		System.out.println("A IMPLEMENTAR");
		//IMPLEMENTAR
		boolean agregado = true;
		String respuesta = "";
		if (agregado) {
			respuesta+="Reclamo enviado";
		} else {
			respuesta+="No se pudo enviar el reclamo";
		};
		
		return respuesta;
	};
}
