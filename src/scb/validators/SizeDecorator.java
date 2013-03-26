package scb.validators;

public class SizeDecorator extends ValidadorDecorator{

	private int min = 1;
	private int max = 40;
	
	public SizeDecorator(ValidadorCampo validador){
		super(validador);
	}
	
	public SizeDecorator(ValidadorCampo validador, int min, int max){
		super(validador);
		this.max = max;
		this.min = min;
	}
	
	public boolean validar(String valor){
		if(!super.validar(valor)) return false;
		return (valor.length() >= min) && (valor.length() <= max);
	}
}
