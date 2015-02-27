package com.osiris.component.bootstrap.formItem.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.formItem.UIFormItem;
import com.osiris.component.bootstrap.formItem.UIFormItem.PositionLabel;
import com.osiris.component.renderer.CoreRenderer;
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
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "form-group", null);
		
		String style = formItem.getStyle();
		if (!style.isEmpty()) {
			writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
		}
		
		PositionLabel positionLabel = PositionLabel.valueOf(formItem.getLabelPosition());
		if (!formItem.getLabel().isEmpty()) {
			
			writer.startElement(HTML.LABEL_ELEM, null);
			
			if (PositionLabel.left.equals(positionLabel)) {
				writer.writeAttribute(HtmlConstants.CLASS_ATTR, "col-sm-2 control-label " + formItem.getLabelClass(), null);
			} else if (!formItem.getLabelClass().isEmpty()) {
				writer.writeAttribute(HtmlConstants.CLASS_ATTR, formItem.getLabelClass(), null);
			}
			
			if (!formItem.getLabelFor().isEmpty()) {
				writer.writeAttribute(HtmlConstants.FOR_ATTR, formItem.getLabelFor(), null);
			}
			writer.writeText(formItem.getLabel(), null);
			writer.endElement(HTML.LABEL_ELEM);
		}
		
		if (PositionLabel.left.equals(positionLabel)) {
			writer.startElement(HTML.DIV_ELEM, null);
			writer.writeAttribute(HtmlConstants.CLASS_ATTR, formItem.getControlClass(), null);
		}
		
		renderChildren(context, formItem);
		
		if (PositionLabel.left.equals(positionLabel)) {
			writer.endElement(HTML.DIV_ELEM);
		}
		writer.endElement(HTML.DIV_ELEM);
	}
	
    
    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}