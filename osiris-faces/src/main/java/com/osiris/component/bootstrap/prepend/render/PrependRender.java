package com.osiris.component.bootstrap.prepend.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.prepend.UIPrepend;
import com.osiris.component.bootstrap.prepend.UIPrepend.PrependPosition;
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
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "input-group", null);
        
        if (prepend.getStyle() != null && !prepend.getStyle().isEmpty()) {
        	writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, prepend.getStyle(), null);
        }
        
        renderPassThruAttributes(context, prepend);
        
        PrependPosition position = PrependPosition.valueOf(prepend.getPosition());
        if (PrependPosition.left.equals(position)) {
        	renderPrepend(prepend, writer);
        }
        
        renderChildren(context, prepend);

        if (PrependPosition.right.equals(position)) {
        	renderPrepend(prepend, writer);
        }
        
        writer.endElement(HTML.DIV_ELEM);
	}

	/**
	 * Método que renderiza a parte de destaque do campo.
	 * 
	 * @param prepend - componente
	 * @param writer - objeto para excrever na página
	 * 
	 * @throws IOException - exceção
	 */
	private void renderPrepend(UIPrepend prepend, ResponseWriter writer)
			throws IOException {
		writer.startElement(HTML.SPAN_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "input-group-addon", null);
        
        if (prepend.getIcon() != null) {
	        writer.startElement(HTML.SPAN_ELEM, null);
	        writer.writeAttribute(HtmlConstants.CLASS_ATTR, prepend.getIcon(), null);
	        writer.endElement(HTML.SPAN_ELEM);
        }
        
        if (prepend.getPrependText() != null) {
        	writer.writeText(prepend.getPrependText(), null);
        }
        
        writer.endElement(HTML.SPAN_ELEM);
	}
	
   @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

}