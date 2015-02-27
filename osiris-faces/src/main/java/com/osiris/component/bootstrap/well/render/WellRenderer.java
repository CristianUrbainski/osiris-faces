package com.osiris.component.bootstrap.well.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.well.UIWell;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;
import com.osiris.component.util.StringUtils;

/**
 * Classe que renderiza o componente well.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 28/12/2013
 * @version 1.0 
 *
 */
@FacesRenderer(componentFamily = UIWell.COMPONENT_FAMILY, rendererType = WellRenderer.DEFAULT_RENDERER)
public class WellRenderer extends CoreRenderer {
	
	/**
	 * Renderizador padrão do componente.
	 */
	public static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.WellRenderer";
	
	/**
	 * Classe de estylo padrão do componente.
	 */
	private static final String COMPONENT_STYLE_CLASS = "well";

	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIWell well = (UIWell) component;
		encodeMarkup(context, well);
	}
	
	/**
	 * Método responsável por fazer a construção do html para o componente.
	 * 
	 * @param context do jsf
	 * @param alert componente a ser transcrito para html
	 * @throws IOException excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UIWell well) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement(HTML.DIV_ELEM, null);
		writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, well.getId(), null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, COMPONENT_STYLE_CLASS + " " + well.getStyleClass(), null);
		
		if (StringUtils.isNotNullAndNotEmpty(well.getStyle())) {
			writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, well.getStyle(), null);
		}
		
		renderChildren(context, well);
		
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