/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

/**
 *
 * @author Erickson
 */
public class CampoEmail extends Campo{
	public CampoEmail(){
		super(new ValidadorEmail());
		super.addFocusListener(this);
	}
}
