/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Erickson
 */
public class EmailDecorator extends ValidadorDecorator {
    
        private int min = 1;
	private int max = 30;

	public EmailDecorator(ValidadorCampo validador){
		super(validador);
	}
        
        public EmailDecorator(ValidadorCampo validador, int min, int max){
            super(validador);
            this.max = max;
            this.min = min;
    }
	
	public boolean validar(String email) {
		if(!super.validar(email)) return false;
		boolean emailValido = false;
		if((email != null) && email.length() > 0){
			String expressao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expressao, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
            	emailValido = true;
            }
		}
		return emailValido;
	
	}

}
