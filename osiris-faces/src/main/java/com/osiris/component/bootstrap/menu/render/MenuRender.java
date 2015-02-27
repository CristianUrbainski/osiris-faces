package com.osiris.component.bootstrap.menu.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.menu.UIMenu;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza um menu.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 * 
 */
@FacesRenderer(componentFamily = UIMenu.COMPONENT_FAMILY, rendererType = MenuRender.RENDERER_TYPE)
public class MenuRender extends CoreRenderer {
	
	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.MenuRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		UIMenu menu = (UIMenu) component;
		encodeMarkup(context, menu);
	}

	/**
	 * Método responsável por fazer a construção do html para o componente.
	 * 
	 * @param context
	 *            do jsf
	 * @param menu
	 *            componente a ser transcrito para html
	 * @throws IOException
	 *             excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UIMenu menu)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = menu.getClientId(context);
		String style = menu.getStyle();
		String styleClass = "dropdown";

		if (menu.getStyleClass() != null) {
			styleClass += " " + menu.getStyleClass();
		}

		writer.startElement(HTML.LI_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);

		if (style == null) {
			writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
		}

		writer.startElement(HTML.A_ELEM, null);
		writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "dropdown-toggle", null);
		writer.writeAttribute("role", "button", null);
		writer.writeAttribute("data-toggle", "dropdown", null);
		writer.writeAttribute("href", "#", null);
		writer.writeText(menu.getLabel(), null);

		writer.startElement(HTML.B_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "caret", null);
		writer.endElement(HTML.B_ELEM);

		writer.endElement(HTML.A_ELEM);

		writer.startElement(HTML.UL_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "dropdown-menu", null);
		writer.writeAttribute("role", "menu", null);
		writer.writeAttribute("aria-labelledby", clientId, null);

		renderChildren(context, menu);

		writer.endElement(HTML.UL_ELEM);

		writer.endElement(HTML.LI_ELEM);
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component)
			throws IOException {
		// Rendering happens on encodeEnd
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

}