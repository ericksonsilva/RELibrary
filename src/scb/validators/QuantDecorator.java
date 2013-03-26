package scb.validators;

public class QuantDecorator extends ValidadorDecorator{

	private int quantidadeMax = 99999;
	private int quantidadeMin = 0;
	
	public QuantDecorator(ValidadorCampo comp) {
		super(comp);
	}
	
	public QuantDecorator(ValidadorCampo comp, int quantidadeMin, int quantidadeMax){
		super(comp);
		this.quantidadeMax = quantidadeMax;
		this.quantidadeMin = quantidadeMin;
	}
	
	public boolean validar(String valor){
		if(!super.validar(valor)) return false;
		if(valor == null || !(valor.matches("\\d\\d*"))) return false;
		return Integer.parseInt(valor) >= this.quantidadeMin && Integer.parseInt(valor) <= this.quantidadeMax;
			
	}


}
