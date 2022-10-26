package Principal;

import javax.swing.JOptionPane;

import Interfaces.LoginRegistro;

public class Principal {

	public static void main(String[] args) {
		
        try {  
        	
            LoginRegistro form = new LoginRegistro();
    		
        } catch(Exception e) {
        	
        	e.printStackTrace();
        	System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR");  
            
        } 
        
	}

}