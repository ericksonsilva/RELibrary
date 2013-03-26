/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

/**
 *
 * @author Erickson
 */
public class ValidadorTexto implements ValidadorCampo{

	@Override
	public boolean validar(CampoValidar campo) {	
		if(campo.getValueString() == null) return false;
                return campo.getValueString().matches("\\w*\\D*");
		
        }

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return "Validador Nome";
	}

}

