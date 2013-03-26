package scb.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail implements ValidadorCampo{
	
	public boolean validar(CampoValidar campo) {
//		if(campo.getValueString() == null) return false;b
//		return campo.getValueString().matches("\\w*@.*");
            
        if(campo.getValueString() == null) return false;
        boolean emailValido = false;
		if((campo.getValueString() != null) && campo.getValueString().length() > 0){
			String expressao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expressao, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(campo.getValueString());
            if (matcher.matches()){
            	emailValido = true;
            }
		}
		return emailValido;
	
	}            
	

    @Override
    public String getValueString() {
        return "Validador Email";
    }

}
