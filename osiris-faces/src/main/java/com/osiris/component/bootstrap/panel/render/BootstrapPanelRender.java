package com.osiris.component.bootstrap.panel.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.renderkit.CoreRenderer;

import com.osiris.component.bootstrap.panel.UIBootstrapPanel;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * Classe responsavel por renderizar o panel do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 24/02/2015
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIBootstrapPanel.COMPONENT_FAMILY, rendererType = BootstrapPanelRender.RENDERER_TYPE)
public class BootstrapPanelRender extends CoreRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.PanelRenderer";
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIBootstrapPanel panel = (UIBootstrapPanel) component;
		
		if (panel.isRendered()) {
			encodeMarkup(context, panel);
		}
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
	protected void encodeMarkup(FacesContext context, UIBootstrapPanel panel) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        String clientId = panel.getClientId(context);
        
        String styleClass = "panel panel-" + panel.getSeverity();
        if (panel.getStyleClass() != null) {
        	styleClass += " " + panel.getStyleClass();
        }
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        
        if (panel.getStyle() != null) {
        	writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, panel.getStyle(), null);
        }
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "panel-heading", null);
        writer.writeText(panel.getTitle(), null);
        writer.endElement(HTML.DIV_ELEM);
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "panel-body", null);
        
        renderChildren(context, panel);
        
        writer.endElement(HTML.DIV_ELEM);
        
        writer.endElement(HTML.DIV_ELEM);
	}
	
    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        //Rendering happens on encodeEnd
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
    
	
}