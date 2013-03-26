/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

/**
 *
 * @author Erickson
 */
public class CampoInteiro  extends Campo{
	public CampoInteiro(){
		super(new ValidadorInteiro());
		super.addFocusListener(this);
	}
}
