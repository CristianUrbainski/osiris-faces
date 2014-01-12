package com.osiris.component.bootstrap.modal.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.renderkit.CoreRenderer;

import com.osiris.component.bootstrap.modal.UIModalBody;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza o corpo de um componente modal.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIModalBody.COMPONENT_FAMILY, rendererType = ModalBodyRenderer.RENDERER_TYPE)
public class ModalBodyRenderer extends CoreRenderer {

	/**
	 * Renderizador padrão do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.ModalBodyRenderer";
	
	@Override
    public void decode(FacesContext context, UIComponent component) {
        super.decodeBehaviors(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
    	UIModalBody body = (UIModalBody) component;
        encodeMarkup(context, body);
    }
    
    /**
     * Método responsável pela escrita do html do componente.
     * 
     * @param context do jsf
     * @param body componente a ser escrito o html
     * @throws IOException 
     */
    protected void encodeMarkup(FacesContext context, UIModalBody body) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = body.getClientId(context);
        String style = body.getStyle();
        String styleClass = "modal-body";
        
        if (body.getStyleClass() != null) {
        	styleClass += " " + body.getStyleClass(); 
        }
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        
        if (style != null) {
            writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
        }
        
        renderChildren(context, body);
        
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