/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scb.validators;

/**
 *
 * @author Erickson
 */
public class CampoTexto extends Campo{
	public CampoTexto(){
		super(new ValidadorTexto());
		super.addFocusListener(this);
	}
}

