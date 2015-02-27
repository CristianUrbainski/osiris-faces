package com.osiris.component.bootstrap.alert.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.alert.UIAlert;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;


/**
 * Classe responsavel por renderizar o alert do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 23/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIAlert.COMPONENT_FAMILY, rendererType = AlertRender.RENDERER_TYPE)
public class AlertRender extends CoreRenderer {
	
	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.AlertRenderer";
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIAlert alert = (UIAlert) component;
		encodeMarkup(context, alert);
	}
	
	/**
	 * Método responsável por fazer a construção do html para o componente.
	 * 
	 * @param context
	 *            do jsf
	 * @param alert
	 *            componente a ser transcrito para html
	 * @throws IOException
	 *             excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UIAlert alert) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        String clientId = alert.getClientId(context);
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "alert alert-" + alert.getSeverity(), null);
        
        encodeCloseButton(context, alert, writer);
        encodeTitle(context, alert, writer);
        encodeMessage(context, alert, writer);
        
        writer.endElement(HTML.DIV_ELEM);
	}
	
	/**
	 * Método responsável por escrever o botão de fechar da mensagem.
	 * 
	 * @param context do jsf
	 * @param alert componente a ser usado
	 * @param writer de texto
	 * @throws IOException 
	 */
    protected void encodeCloseButton(FacesContext context, UIAlert alert, ResponseWriter writer) throws IOException {
    	if (alert.isCloseable()) {
    		writer.startElement(HTML.BUTTON_ELEM, null);
        	writer.writeAttribute(HtmlConstants.TYPE_ATTR, "button", null);
        	writer.writeAttribute(HtmlConstants.CLASS_ATTR, "close", null);
        	writer.writeAttribute("data-dismiss", "alert", null);
        	writer.writeText("\u00D7", null);
        	writer.endElement(HTML.BUTTON_ELEM);
        }
    }
    
    /**
     * Método responsável por escrever o titulo da caixa de mensagem.
     * 
     * @param context do jsf
     * @param alert componente a ser usado
     * @param writer de texto
     * @throws IOException 
     */
    protected void encodeTitle(FacesContext context, UIAlert alert, ResponseWriter writer) throws IOException {
    	if (alert.getTitle() != null && !alert.getTitle().isEmpty()) {
        	writer.startElement(HTML.H4_ELEM, null);
        	writer.writeText(alert.getTitle(), null);
        	writer.endElement(HTML.H4_ELEM);
        }
    }
    
    /**
     * Método responsável por escrever a mensagem na caixa da mensagem.
     * 
     * @param context do jsf
     * @param alert componente a ser usado
     * @param writer de texto
     * @throws IOException 
     */
    protected void encodeMessage(FacesContext context, UIAlert alert, ResponseWriter writer) throws IOException {
    	writer.writeText(alert.getMessage(), null);
    }

}