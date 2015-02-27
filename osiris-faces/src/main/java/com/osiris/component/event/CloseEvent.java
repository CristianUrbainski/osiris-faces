package com.osiris.component.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
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
	 * Evento.
	 */
	private final Behavior behavior;
	
	/**
	 * Construtor.
	 * 
	 * @param component o componente que disparou o evento
	 * @param value valor informado
	 */
	public CloseEvent(UIComponent component, Behavior behavior) {
		super(component);
		this.behavior = behavior;
	}
	
	public Behavior getBehaviorEvent() {
		return behavior;
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
