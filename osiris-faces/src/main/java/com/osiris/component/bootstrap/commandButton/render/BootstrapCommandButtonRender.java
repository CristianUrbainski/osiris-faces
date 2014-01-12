package com.osiris.component.bootstrap.commandButton.render;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.commandbutton.CommandButtonRenderer;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;
import org.primefaces.util.WidgetBuilder;

import com.osiris.component.bootstrap.commandButton.UIBootstrapCommandButton;

import static com.osiris.component.util.HTML.SPAN_ELEM;
import static com.osiris.component.util.HTML.BUTTON_ELEM;
import static com.osiris.component.util.HtmlConstants.CLASS_ATTR;
import static com.osiris.component.util.HtmlConstants.ID_ATTRIBUTE;
import static com.osiris.component.util.HtmlConstants.NAME_ATTR;
import static com.osiris.component.util.HtmlConstants.VALUE_ATTR;
import static com.osiris.component.util.HtmlConstants.DISABLED_ATTR;
import static com.osiris.component.util.HtmlConstants.READONLY_ATTR;

/**
 * Classe responsável por renderizar o componente Commandbutton do primefaces com a personalização
 * do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 18/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIBootstrapCommandButton.COMPONENT_FAMILY, 
				rendererType = BootstrapCommandButtonRender.RENDERER_TYPE)
public class BootstrapCommandButtonRender extends CommandButtonRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.CommandButtonRenderer";
	
	@Override
	protected void encodeMarkup(FacesContext context, CommandButton button) throws IOException {
		UIBootstrapCommandButton commandButton = (UIBootstrapCommandButton) button;
		
		ResponseWriter writer = context.getResponseWriter();
		String clientId = button.getClientId(context);
		String type = button.getType();
        Object value = button.getValue();
        String icon = button.resolveIcon();
        
        StringBuilder onclick = new StringBuilder();
        if (button.getOnclick() != null) {
            onclick.append(button.getOnclick()).append(";");
        }
        
        String styleClass = "btn";
        
        if (commandButton.getScale() != null) {
        	styleClass += " btn-" + commandButton.getScale();
        }
        
        if (commandButton.getSeverity() != null && commandButton.getSeverity().length() > 0) {
        	styleClass += " btn-" + commandButton.getSeverity();
        }
        
        if (commandButton.getStyleClass() != null && commandButton.getStyleClass().length() > 0) {
        	styleClass += " " + commandButton.getStyleClass(); 
        }
        
		writer.startElement(BUTTON_ELEM, button);
		writer.writeAttribute(ID_ATTRIBUTE, clientId, ID_ATTRIBUTE);
		writer.writeAttribute(NAME_ATTR, clientId, NAME_ATTR);
        writer.writeAttribute(CLASS_ATTR, styleClass, CLASS_ATTR);
        
        if (!type.equals("reset") && !type.equals("button")) {
            String request;
			
            if (button.isAjax()) {
                 request = buildAjaxRequest(context, button, null);
            } else {
                UIComponent form = ComponentUtils.findParentForm(context, button);
              
                if (form == null) {
                    throw new FacesException("CommandButton : \"" + clientId + "\" must be inside a form element");
                }
                
                request = buildNonAjaxRequest(context, button, form, null, false);
            }
			
            onclick.append(request);
		}
        
        String onclickBehaviors = getOnclickBehaviors(context, button);
        
        if (onclickBehaviors != null) {
            onclick.append(onclickBehaviors).append(";");
        }

		if (onclick.length() > 0) {
			writer.writeAttribute("onclick", onclick.toString(), "onclick");
		}
		
		renderPassThruAttributes(context, button, HTML.BUTTON_ATTRS, HTML.CLICK_EVENT);

        if (button.isDisabled()) {
        	writer.writeAttribute(DISABLED_ATTR, DISABLED_ATTR, DISABLED_ATTR);
        }
        
        if (button.isReadonly()) {
        	writer.writeAttribute(READONLY_ATTR, READONLY_ATTR, READONLY_ATTR);
        }
		
        //icon
        if (icon != null) {
            writer.startElement(SPAN_ELEM, null);
            writer.writeAttribute(CLASS_ATTR, icon, null);
            writer.endElement(SPAN_ELEM);
            
            //adicionase o \n antes do valor no casso ter um icone para dar um espaço 
            //entre o icone e o texto, assim eles não ficam colados
            value = "\n" + value;
        }
        
        if (button.isEscape()) {
            writer.writeText(value, VALUE_ATTR);
        } else {
            writer.write(value.toString());
        }
        
		writer.endElement(BUTTON_ELEM);
	}
	
	@Override
	protected void encodeScript(FacesContext context, CommandButton button) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = button.getClientId(context);
        WidgetBuilder wb = getWidgetBuilder(context);
        wb.widget("BootstrapCommandButton", button.resolveWidgetVar(), clientId, false);
		
        startScript(writer, clientId);
        writer.write(wb.build());
		endScript(writer);
	}
	
}