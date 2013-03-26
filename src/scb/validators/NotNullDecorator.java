package scb.validators;

public class NotNullDecorator extends ValidadorDecorator{

	public NotNullDecorator(ValidadorCampo validador){
		super(validador);
	}
	
	public boolean validar(String valor) {
		if(!super.validar(valor)) return false;
		return valor != null;
	}

}
