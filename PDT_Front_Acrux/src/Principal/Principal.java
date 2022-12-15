package Principal;

import javax.swing.JOptionPane;

import Controladores.ControladorListarEstados;
import Controladores.ControladorListarItrs;
import Controladores.ControladorLoginRegistro;
import Controladores.ControladorModificarUsuario;
import Interfaces.LoginRegistro;

public class Principal {

	public static void main(String[] args) {
		
        try {
        	
        	///ITRs
        	ControladorListarItrs.agregar("Centro-Sur");
        	ControladorListarItrs.agregar("Fray Bentos");
//        	///
//        	
//        	///USUARIOS
        	ControladorLoginRegistro.registro("Luis", "Axel", "González", "Rojas", "1.111.111-1", "01/01/1997", "luis.gonzalez@mail.com", "999999999", "Montevideo", "luis.gonzalez@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorLoginRegistro.registro("Mia", "Luciana", "Rodríguez", "Rojas", "1.111.111-2", "01/01/1997", "mia.rodriguez@mail.com", "999999999", "Montevideo", "mia.rodriguez@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorLoginRegistro.registro("Juan", "Santiago", "Gómez", "Acosta", "1.111.111-3", "01/01/1997", "juan.gomez@mail.com", "999999999", "Durazno", "juan.gomez@utec.edu.uy", "12345aaa", "Centro-Sur", "TUTOR", " ", "LTI", "ENCARGADO");
        	ControladorLoginRegistro.registro("Alessia", "Aitana", "Fernández", "Álvarez", "1.111.111-4", "01/01/1997", "alessia.fernandez@mail.com", "999999999", "Fray Bentos", "alessia.fernandez@utec.edu.uy", "12345aaa", "Fray Bentos", "ANALISTA", " ", " ", " ");
        	ControladorModificarUsuario.activarEstado("alessia.fernandez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Axel", "Lucas", "López", "Flores", "1.111.111-5", "01/01/1997", "axel.lopez@mail.com", "999999999", "Cerro Largo", "axel.lopez@utec.edu.uy", "12345aaa", "Centro-Sur", "ANALISTA", " ", " ", " ");
        	ControladorModificarUsuario.activarEstado("axel.lopez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Camila", "María", "Martínez", "Ruiz", "1.111.111-6", "01/01/1997", "camila.martinez@mail.com", "999999999", "Soriano", "camila.martinez@utec.edu.uy", "12345aaa", "Fray Bentos", "ANALISTA", " ", " ", " ");
        	ControladorModificarUsuario.activarEstado("camila.martinez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Ian", "Carlos", "Diaz", "Torres", "1.111.111-7", "01/01/1997", "ian.diaz@mail.com", "999999999", "Flores", "ian.diaz@utec.edu.uy", "12345aaa", "Centro-Sur", "TUTOR", " ", "MECÁNICA", "ENCARGADO");
        	ControladorModificarUsuario.activarEstado("ian.diaz@utec.edu.uy");
        	ControladorLoginRegistro.registro("Danna", "Brianna", "Pérez", "Ramírez", "1.111.111-8", "01/01/1997", "danna.perez@mail.com", "999999999", "Lavalleja", "danna.perez@utec.edu.uy", "12345aaa", "Fray Bentos", "TUTOR", " ", "AMBIENTAL", "TUTOR");
        	ControladorModificarUsuario.activarEstado("danna.perez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Ángel", "Liam", "Sánchez", "Benítez", "1.111.111-9", "01/01/1997", "angel.sanchez@mail.com", "999999999", "Salto", "angel.sanchez@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("angel.sanchez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Zoe", "Luz", "Romero", "Sosa", "1.111.112-1", "01/01/1997", "zoe.romero@mail.com", "999999999", "Paysandú", "zoe.romero@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("zoe.romero@utec.edu.uy");
        	ControladorLoginRegistro.registro("Santiago", "Diego", "García", "Romero", "1.111.112-2", "01/01/1997", "santiago.garcia@mail.com", "999999999", "Durazno", "santiago.garcia@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("santiago.garcia@utec.edu.uy");
        	ControladorLoginRegistro.registro("Ariana", "Ana", "Sosa", "García", "1.111.112-3", "01/01/1997", "ariana.sosa@mail.com", "999999999", "Lavalleja", "ariana.sosa@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("ariana.sosa@utec.edu.uy");
        	ControladorLoginRegistro.registro("Lucas", "Sebastián", "Benítez", "Sánchez", "1.111.112-4", "01/01/1997", "lucas.benitez@mail.com", "999999999", "Rocha", "lucas.benitez@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("lucas.benitez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Valentina", "Kiara", "Ramírez", "Pérez", "1.111.112-5", "01/01/1997", "valentina.ramirez@mail.com", "999999999", "Maldonado", "valentina.ramirez@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("valentina.ramirez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Carlos", "Mathías", "Torres", "Diaz", "1.111.112-6", "01/01/1997", "carlos.torres@mail.com", "999999999", "Canelones", "carlos.torres@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("carlos.torres@utec.edu.uy");
        	ControladorLoginRegistro.registro("Luana", "Lia", "Ruiz", "Martínez", "1.111.112-7", "01/01/1997", "luana.ruiz@mail.com", "999999999", "Soriano", "luana.ruiz@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("luana.ruiz@utec.edu.uy");
        	ControladorLoginRegistro.registro("José", "Gabriel", "Flores", "López", "1.111.112-8", "01/01/1997", "jose.flores@mail.com", "999999999", "Durazno", "jose.flores@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("jose.flores@utec.edu.uy");
        	ControladorLoginRegistro.registro("Sofía", "Emily", "Álvarez", "Fernández", "1.111.112-9", "01/01/1997", "sofia.alvarez@mail.com", "999999999", "Young", "sofia.alvarez@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("sofia.alvarez@utec.edu.uy");
        	ControladorLoginRegistro.registro("Iker", "Mario", "Acosta", "Gómez", "1.111.113-1", "01/01/1997", "iker.acosta@mail.com", "999999999", "Rivera", "iker.acosta@utec.edu.uy", "12345aaa", "Centro-Sur", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("iker.acosta@utec.edu.uy");
        	ControladorLoginRegistro.registro("Emma", "Antonella", "Rojas", "Rodríguez", "1.111.113-2", "01/01/1997", "emma.rojas@mail.com", "999999999", "San José", "emma.rojas@utec.edu.uy", "12345aaa", "Fray Bentos", "ESTUDIANTE", "2022", " ", " ");
        	ControladorModificarUsuario.activarEstado("emma.rojas@utec.edu.uy");
//        	////
//        	
//        	///ESTADOS INICIALES: INGRESADO || EN PROCESO || FINALIZADO
        	ControladorListarEstados.agregar("INGRESADO");
        	ControladorListarEstados.agregar("EN PROCESO");
        	ControladorListarEstados.agregar("FINALIZADO");
        	////
        	
            LoginRegistro form = new LoginRegistro();
    		
        } catch(Exception e) {
        	
        	e.printStackTrace();
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR");  
            
        } 
        
	}

}