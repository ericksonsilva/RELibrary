package scb.validators;

public class ValidadorCep implements ValidadorCampo{
	
	public boolean validar(CampoValidar campo) {
		if(campo.getValueString() == null) return false;
		return campo.getValueString().matches("\\d{5}-\\d{3}");
	}


    @Override
    public String getValueString() {
        return "Validador Cep";
    }

}
