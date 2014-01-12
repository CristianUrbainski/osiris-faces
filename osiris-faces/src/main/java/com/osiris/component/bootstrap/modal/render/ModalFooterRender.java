package com.osiris.component.bootstrap.modal.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.renderkit.CoreRenderer;

import com.osiris.component.bootstrap.modal.UIModalFooter;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza o rodape de um componente modal.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIModalFooter.COMPONENT_FAMILY, rendererType = ModalFooterRender.RENDERER_TYPE)
public class ModalFooterRender extends CoreRenderer {
	
	/**
	 * Renderizador padrão do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.ModalFooterRenderer";

	@Override
    public void decode(FacesContext context, UIComponent component) {
        super.decodeBehaviors(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
    	UIModalFooter footer = (UIModalFooter) component;
        encodeMarkup(context, footer);
    }
    
    /**
     * M�todo responsável por escrever o html do componente.
     * 
     * @param context do jsf
     * @param footer componente a ser convertido para o html
     * @throws IOException 
     */
    protected void encodeMarkup(FacesContext context, UIModalFooter footer) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = footer.getClientId(context);
        String style = footer.getStyle();
        String styleClass = "modal-footer";
        
        if (footer.getStyleClass() != null) {
        	styleClass += " " + footer.getStyleClass(); 
        }
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        
        if (style != null) {
            writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
        }
        
        renderChildren(context, footer);
        
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