/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

/**
 *
 * @author Erickson
 */
public class CampoCep extends Campo{
	public CampoCep(){
		super(new ValidadorCep());
		super.addFocusListener(this);
	}
}
    

