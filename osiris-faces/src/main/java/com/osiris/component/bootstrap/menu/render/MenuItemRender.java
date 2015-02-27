package com.osiris.component.bootstrap.menu.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.menu.UIMenuItem;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza um item do menu.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIMenuItem.COMPONENT_FAMILY, rendererType = MenuItemRender.RENDERER_TYPE)
public class MenuItemRender extends CoreRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.MenuItemRenderer";
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIMenuItem menuItem = (UIMenuItem) component;
        encodeMarkup(context, menuItem);
    }
	
    /**
     * Método responsável por fazer a construção do html para o componente.
     * 
     * @param context do jsf
     * @param menuItem componente a ser transcrito para html
     * @throws IOException excecao que pode ocorrer
     */
	 protected void encodeMarkup(FacesContext context, UIMenuItem menuItem) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = menuItem.getClientId(context);
        String style = menuItem.getStyle();
        String styleClass = "";
        
        if (menuItem.isActive()) {
        	styleClass = "active";
        }
        
        if (menuItem.getStyleClass() != null) {
        	styleClass += " " + menuItem.getStyleClass(); 
        }
        
        writer.startElement(HTML.LI_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        
        if (styleClass.length() > 0) {
        	writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        }
        
        if (style != null) {
            writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
        }
        
        writer.startElement(HTML.A_ELEM, null);
        writer.writeAttribute(HtmlConstants.HREF_ATTR, menuItem.getLocation(), null);
        writer.writeText(menuItem.getLabel(), null);
        writer.endElement(HTML.A_ELEM);
        
        writer.endElement(HTML.LI_ELEM);
    }

}