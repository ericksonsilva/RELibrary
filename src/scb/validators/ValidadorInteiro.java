package scb.validators;

public class ValidadorInteiro implements ValidadorCampo {
	
	public boolean validar(CampoValidar campo) {
			if(campo.getValueString() == null) return false;
			return campo.getValueString().matches("\\d\\d*");
		}

    @Override
    public String getValueString() {
        return "Validador Inteiro";
    }
}
