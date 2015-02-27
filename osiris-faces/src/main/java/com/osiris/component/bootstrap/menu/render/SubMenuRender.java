package com.osiris.component.bootstrap.menu.render;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.osiris.component.bootstrap.menu.UISubMenu;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza um sub-menu.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 * 
 */
@FacesRenderer(componentFamily = UISubMenu.COMPONENT_FAMILY, rendererType = SubMenuRender.RENDERER_TYPE)
public class SubMenuRender extends CoreRenderer {

	/**
	 * Tipo do renderizador do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.SubMenuRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		UISubMenu subMenu = (UISubMenu) component;
		encodeMarkup(context, subMenu);
	}

	/**
	 * Método responsável por fazer a construção do html para o componente.
	 * 
	 * @param context
	 *            do jsf
	 * @param subMenu
	 *            componente a ser transcrito para html
	 * @throws IOException
	 *             excecao que pode ocorrer
	 */
	protected void encodeMarkup(FacesContext context, UISubMenu subMenu)
			throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = subMenu.getClientId(context);
		String style = subMenu.getStyle();
		String styleClass = "dropdown-submenu";

		if (subMenu.getStyleClass() != null) {
			styleClass += " " + subMenu.getStyleClass();
		}

		writer.startElement(HTML.LI_ELEM, null);
		writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);

		if (style != null) {
			writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, styleClass,
					null);
		}

		writer.startElement(HTML.A_ELEM, null);
		writer.writeAttribute(HtmlConstants.HREF_ATTR, "#", null);
		writer.writeText(subMenu.getLabel(), null);
		writer.endElement(HTML.A_ELEM);

		writer.startElement(HTML.UL_ELEM, null);
		writer.writeAttribute(HtmlConstants.CLASS_ATTR, "dropdown-menu", null);

		renderChildren(context, subMenu);

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