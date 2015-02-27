package com.osiris.component.bootstrap.prepend.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.sun.faces.facelets.el.TagValueExpression;
import com.osiris.component.bootstrap.prepend.UIPrepend;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * Classe responsavel por renderizar o input-prepend do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 23/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIPrepend.COMPONENT_FAMILY, rendererType = PrependRender.RENDERER_TYPE)
public class PrependRender extends CoreRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.PrependRenderer";
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIPrepend prepend = (UIPrepend) component;
		encodeMarkup(context, prepend);
	}
	
	/**
	 * Método constroi o html do componete.
	 * 
	 * @param context do jsf
	 * @param prepend componente a ser descrito para html
	 * @throws IOException 
	 */
	protected void encodeMarkup(FacesContext context, UIPrepend prepend) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        String clientId = prepend.getClientId(context);
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "input-group", null);
        
        if (prepend.getStyle() != null && !prepend.getStyle().isEmpty()) {
        	writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, prepend.getStyle(), null);
        }
        
        rendererPassThroughAttributes(context, writer, prepend);
        
        writer.startElement(HTML.SPAN_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "input-group-addon", null);
        
        writer.startElement(HTML.SPAN_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, prepend.getIcon(), null);
        writer.endElement(HTML.SPAN_ELEM);
        
        writer.endElement(HTML.SPAN_ELEM);
        
        renderChildren(context, prepend);
        
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

    /**
     * Método para escrever atributos extras do componente.
     * 
     * @param context do jsf
     * @param writer de texto
     * @param prepend componente
     * @throws IOException 
     */
    private void rendererPassThroughAttributes(FacesContext context, ResponseWriter writer, UIPrepend prepend) 
    		throws IOException {
    	for (String key : prepend.getPassThroughAttributes().keySet()) {
    		Object object = prepend.getPassThroughAttributes().get(key);
    		
    		if (object instanceof TagValueExpression) {
    			object = ((TagValueExpression) object).getValue(context.getELContext());
    		}
    		
    		writer.writeAttribute(key, object, key);
    	}
    }
}