package Principal;

import javax.swing.JOptionPane;

import Controladores.ControladorListarItrs;
import Controladores.ControladorLoginRegistro;
import Interfaces.LoginRegistro;

public class Principal {

	public static void main(String[] args) {
		
        try {
        	
        	///ITR INICIAL
        	ControladorListarItrs.agregar("Inicial");
        	///
        	
        	///USUARIO ADMIN
        	ControladorLoginRegistro.registro("Admin", "", "", "", "", "01/01/1111", "admin@admin.com", "", "", "admin@utec.edu.uy", "11111aA!", "Inicial", "ANALISTA", "", "", "");
        	////
        	
            LoginRegistro form = new LoginRegistro();
    		
        } catch(Exception e) {
        	
        	e.printStackTrace();
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR");  
            
        } 
        
	}

}