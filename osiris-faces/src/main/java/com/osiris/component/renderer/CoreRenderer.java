package com.osiris.component.renderer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.apache.commons.fileupload.RequestContext;

import com.osiris.component.util.WidgetBuilder;

/**
 * Renderer base do projeto.
 * 
 * @author Cristian Urbainski <cristianurbainskips@gmail.com>
 * @since 26/02/2015
 * @version 1.0
 *
 */
public class CoreRenderer extends Renderer {

	/**
	 * Renderizar os itens filhos.
	 * 
	 * @param context
	 *            - contexto jsf
	 * @param component
	 *            - compoente
	 * @throws IOException
	 *             - exceção
	 */
	protected void renderChildren(FacesContext context, UIComponent component)
			throws IOException {

		for (Iterator<UIComponent> iterator = component.getChildren()
				.iterator(); iterator.hasNext();) {
			UIComponent child = iterator.next();
			renderChild(context, child);
		}
	}

	/**
	 * Renderiza o componente filho.
	 * 
	 * @param context - contexto jsf
	 * @param child - componente filho
	 * 
	 * @throws IOException - exceção
	 */
	protected void renderChild(FacesContext context, UIComponent child)
			throws IOException {

		if (!child.isRendered()) {
			return;
		}
		
		child.encodeBegin(context);
		
		if (child.getRendersChildren()) {
			child.encodeChildren(context);
		} else {
			renderChildren(context, child);
		}
		
		child.encodeEnd(context);
	}

	/**
	 * Método responsável por renderizar os argumentos com o PassThruAttributes.
	 * 
	 * @param context
	 *            - contexto do jsf
	 * @param component
	 *            - componente
	 * @param attrs
	 *            - atributos
	 * @throws IOException
	 *             - exceção
	 */
	protected void renderPassThruAttributes(FacesContext context,
			UIComponent component, String[] attrs) throws IOException {
		ResponseWriter writer = context.getResponseWriter();

		// pre-defined attributes
		if (attrs != null && attrs.length > 0) {
			for (String attribute : attrs) {
				Object value = component.getAttributes().get(attribute);

				if (shouldRenderAttribute(value))
					writer.writeAttribute(attribute, value.toString(),
							attribute);
			}
		}
	}

	/**
	 * Renderizar atributos.
	 * 
	 * @param value
	 *            - valor
	 * 
	 * @return true or false
	 */
	protected boolean shouldRenderAttribute(Object value) {
		if (value == null)
			return false;

		if (value instanceof Boolean) {
			return ((Boolean) value).booleanValue();
		} else if (value instanceof Number) {
			Number number = (Number) value;

			if (value instanceof Integer)
				return number.intValue() != Integer.MIN_VALUE;
			else if (value instanceof Double)
				return number.doubleValue() != Double.MIN_VALUE;
			else if (value instanceof Long)
				return number.longValue() != Long.MIN_VALUE;
			else if (value instanceof Byte)
				return number.byteValue() != Byte.MIN_VALUE;
			else if (value instanceof Float)
				return number.floatValue() != Float.MIN_VALUE;
			else if (value instanceof Short)
				return number.shortValue() != Short.MIN_VALUE;
		}

		return true;
	}

	/**
	 * Método responsável por fazer o decode do eventos.
	 * 
	 * @param context
	 *            - contexto jsf
	 * @param component
	 *            - componente
	 */
	protected void decodeBehaviors(FacesContext context, UIComponent component) {
		if (!(component instanceof ClientBehaviorHolder)) {
			return;
		}

		Map<String, List<ClientBehavior>> behaviors = ((ClientBehaviorHolder) component)
				.getClientBehaviors();
		if (behaviors.isEmpty()) {
			return;
		}

		Map<String, String> params = context.getExternalContext()
				.getRequestParameterMap();
		String behaviorEvent = params.get("javax.faces.behavior.event");

		if (null != behaviorEvent) {
			List<ClientBehavior> behaviorsForEvent = behaviors
					.get(behaviorEvent);

			if (behaviorsForEvent != null && !behaviorsForEvent.isEmpty()) {
				String behaviorSource = params.get("javax.faces.source");
				String clientId = component.getClientId();

				if (behaviorSource != null && clientId.equals(behaviorSource)) {
					for (ClientBehavior behavior : behaviorsForEvent) {
						behavior.decode(context, component);
					}
				}
			}
		}
	}

	protected WidgetBuilder getWidgetBuilder(FacesContext context) {
        return new WidgetBuilder();
    }
	
}