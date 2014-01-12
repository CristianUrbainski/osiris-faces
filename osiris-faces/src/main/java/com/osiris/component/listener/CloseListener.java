package com.osiris.component.listener;

import javax.faces.event.FacesListener;

import com.osiris.component.event.CloseEvent;

/**
 * 
 * Listener do evento close.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
public interface CloseListener extends FacesListener {

	/**
	 * Método que dispara evento de close.
	 * @param closeEvent 
	 */
	void close(CloseEvent closeEvent);
	
}
