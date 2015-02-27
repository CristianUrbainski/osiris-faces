package com.osiris.component.bootstrap.menu.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.menu.UIMenuBar;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza uma barra de menu.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIMenuBar.COMPONENT_FAMILY, rendererType = MenuBarRender.RENDERER_TYPE)
public class MenuBarRender extends CoreRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.MenuBarRenderer";
	
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        UIMenuBar menu = (UIMenuBar) component;
        encodeMarkup(context, menu);
    }
	
	/**
	 * M�todo responsável por fazer a construção do html para o componente.
	 * 
	 * @param context
	 *            do jsf
	 * @param menu
	 *            componente a ser transcrito para html
	 * @throws IOException
	 *             excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UIMenuBar menu) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = menu.getClientId(context);
        String style = menu.getStyle();
        String styleClass = "nav nav-pills";
        
        if (menu.getStyleClass() != null) {
        	styleClass += " " + menu.getStyleClass(); 
        }
        
        writer.startElement(HTML.UL_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        
        if (style != null) {
            writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
        }
        
        renderChildren(context, menu);
        
        writer.endElement(HTML.UL_ELEM);
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