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
        	
        	///ITR INICIAL
        	ControladorListarItrs.agregar("Inicial");
        	///
        	
        	///USUARIO ADMIN: admin@utec.edu.uy || 12345aaa
        	ControladorLoginRegistro.registro("Admin", " ", " ", " ", " ", "01/01/1111", "admin@admin.com", " ", " ", "admin@utec.edu.uy", "12345aaa", "Inicial", "ANALISTA", " ", " ", " ");
        	ControladorModificarUsuario.activarEstado("admin@utec.edu.uy");
        	////
        	
        	///ESTADOS INICIALES: INGRESADO || EN PROCESO || FINALIZADO
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