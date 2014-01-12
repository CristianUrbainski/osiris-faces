package com.osiris.component.event;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

import com.osiris.component.listener.CloseListener;

/**
 * 
 * Classe que representa o evento de close de um modal.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
public class CloseEvent extends FacesEvent {

	/**
    * SerialVersion.
    */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Valor informado no componente em tela.
	 */
	private final String value;
	
	/**
	 * Construtor.
	 * 
	 * @param component o componente que disparou o evento
	 * @param value valor informado
	 */
	public CloseEvent(UIComponent component, String value) {
		super(component);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
			
	@Override
	public boolean isAppropriateListener(FacesListener facesListener) {
		return facesListener instanceof CloseListener;
	}

	@Override
	public void processListener(FacesListener facesListener) {
		((CloseListener) facesListener).close(this);
	}
	
}
