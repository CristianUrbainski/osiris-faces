package com.osiris.component.bootstrap.formItem.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.renderkit.CoreRenderer;

import com.osiris.component.bootstrap.formItem.UIFormItem;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * Classe que renderiza o componente form item.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 14/11/2013
 * @version 1.0 
 *
 */
@FacesRenderer(componentFamily = UIFormItem.COMPONENT_FAMILY, rendererType = UIFormItem.DEFAULT_RENDERER)
public class FormItemRenderer extends CoreRenderer {
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		UIFormItem formItem = (UIFormItem) component;
		encodeMarkup(context, formItem);
	}
	
	/**
	 * Método responsável por fazer a construção do html para o componente.
	 * 
	 * @param context do jsf
	 * @param alert componente a ser transcrito para html
	 * @throws IOException excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UIFormItem formItem) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement(HTML.DIV_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "control-group " + formItem.getStyleClass(), null);
		
		String style = formItem.getStyle();
		if (!style.isEmpty()) {
			writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
		}
		
//		HtmlOutputLabel label = (HtmlOutputLabel) context.getApplication().createComponent(HtmlOutputLabel.COMPONENT_TYPE);
//		label.setLang(formItem.getLabel());
//		label.setFor(formItem.getLabelFor());
//		label.setStyleClass("control-label");
//		
//		label.encodeAll(context);
		
		writer.startElement(HTML.LABEL_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "control-label", null);
		writer.writeText(formItem.getLabel(), null);
		writer.endElement(HTML.LABEL_ELEM);
		
		writer.startElement(HTML.DIV_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "controls", null);
		
		renderChildren(context, formItem);
		
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