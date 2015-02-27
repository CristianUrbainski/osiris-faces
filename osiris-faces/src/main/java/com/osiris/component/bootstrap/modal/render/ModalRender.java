package com.osiris.component.bootstrap.modal.render;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseId;
import javax.faces.render.FacesRenderer;

//import org.primefaces.util.WidgetBuilder;

import com.osiris.component.bootstrap.modal.UIModal;
import com.osiris.component.event.CloseEvent;
import com.osiris.component.renderer.CoreRenderer;
import com.osiris.component.util.HTML;
import com.osiris.component.util.HtmlConstants;

/**
 * 
 * Classe que renderiza o componente modal.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@FacesRenderer(componentFamily = UIModal.COMPONENT_FAMILY, rendererType = ModalRender.RENDERER_TYPE)
public class ModalRender extends CoreRenderer {
	
	/**
	 * Renderizador padrão do componente.
	 */
	public static final String RENDERER_TYPE = "com.osiris.component.bootstrap.ModalRenderer";
	
	/**
	 * Identificador do parâmetro onde será trafegado o tipo de operação a ser realizada.
	 */
	private static final String EVENT_TYPE_PARAM = "javax.faces.behavior.event";

	@Override
    public void decode(FacesContext context, UIComponent component) {
		UIModal modal = (UIModal) component;
		
		if (!modal.isRendered()) {
			return;
		}
		
		super.decodeBehaviors(context, modal);
		
		Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
		
		if (requestParameterMap.get(modal.getClientId(context)) != null) {
			String eventTypeParam = requestParameterMap.get(EVENT_TYPE_PARAM);
			
			if (UIModal.CLOSE_EVENT_NAME.equals(eventTypeParam)) {
				final CloseEvent closeEvent = new CloseEvent(modal, null);
				closeEvent.setPhaseId(PhaseId.INVOKE_APPLICATION);
				closeEvent.queue();
			}
		}
    }
	
	@Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        UIModal modal = (UIModal) component;
        encodeMarkup(context, modal);
        encodeScript(context, modal);
    }
    
	/**
	 * Método responsável por escrever o script javascript do componente.
	 * 
	 * @param context do jsf
	 * @param modal a ter o javascript escrito
	 * @throws IOException 
	 */
    protected void encodeScript(FacesContext context, UIModal modal) throws IOException {
    	/*ResponseWriter writer = context.getResponseWriter();
    	String clientId = modal.getClientId(context);
        WidgetBuilder wb = getWidgetBuilder(context);
        wb.widget("Modal", modal.resolveWidgetVar(), clientId, true);

        wb.attr("width", modal.getWidth(), null)
	        .attr("minWidth", modal.getMinWidth(), Integer.MIN_VALUE)
	        .attr("minHeight", modal.getMinHeight(), Integer.MIN_VALUE)
	        .attr("visible", modal.isVisible())
	        .callback("onOpen", "function()", modal.getOnOpen())
	        .callback("onClose", "function()", modal.getOnClose());
        
    	encodeClientBehaviors(context, modal, wb);
    	
    	String aux = wb.build();

    	startScript(writer, clientId);
        writer.write(aux);
        endScript(writer);*/
    }

    /**
     * Método respons�vel por escrever o html do componente.
     * 
     * @param context do jsf
     * @param modal componente
     * @throws IOException 
     */
    protected void encodeMarkup(FacesContext context, UIModal modal) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = modal.getClientId(context);
        String style = modal.getStyle();
        String styleClass = "modal hide " + modal.getEffect();
        
        if (modal.getStyleClass() != null && modal.getStyleClass().length() > 0) {
        	styleClass += " " + modal.getStyleClass(); 
        }
        
        writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, clientId, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, styleClass, null);
        writer.writeAttribute("role", "dialog", null);
        writer.writeAttribute("aria-labelledby", "myModalLabel", null);
        writer.writeAttribute("data-backdrop", "static", null);
        
        if (modal.isCloseable()) {
        	writer.writeAttribute("tabindex", "-1", null);
        	writer.writeAttribute("data-keyboard", "true", null);
        }
        
        if (style != null && style.length() > 0) {
            writer.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, style, null);
        }
        
        encodeModalHeader(context, modal, writer);
        
        renderChildren(context, modal);
        
        writer.endElement(HTML.DIV_ELEM);
    }
    
    /**
     * Método respons�vel por escrever o cabeçalho do modal.
     * 
     * @param context do jsf
     * @param modal componente
     * @param writer de texto
     * @throws IOException 
     */
    protected void encodeModalHeader(FacesContext context, UIModal modal, ResponseWriter writer) throws IOException {
    	writer.startElement(HTML.DIV_ELEM, null);
        writer.writeAttribute(HtmlConstants.CLASS_ATTR, "modal-header", null);
        
        encodeCloseButton(context, modal, writer);
        encodeTitle(context, modal, writer);
        
        writer.endElement(HTML.DIV_ELEM);
    }
    
    /**
     * Método respons�vel por escrever o botão de fechamento do modal.
     * 
     * @param context do jsf
     * @param modal componente
     * @param writer de texto
     * @throws IOException 
     */
    protected void encodeCloseButton(FacesContext context, UIModal modal, ResponseWriter writer) throws IOException {
    	if (modal.isCloseable()) {
    		writer.startElement(HTML.BUTTON_ELEM, null);
        	writer.writeAttribute(HtmlConstants.TYPE_ATTR, "button", null);
        	writer.writeAttribute(HtmlConstants.CLASS_ATTR, "close", null);
        	writer.writeAttribute("data-dismiss", "modal", null);
        	writer.writeAttribute("aria-hidden", "true", null);
        	writer.writeText("\u00D7", null);
        	writer.endElement(HTML.BUTTON_ELEM);
        }
    }
    
    /**
     * Método responsável por escrever o titulo do modal.
     * 
     * @param context do jsf
     * @param modal componente
     * @param writer de texto
     * @throws IOException 
     */
    protected void encodeTitle(FacesContext context, UIModal modal, ResponseWriter writer) throws IOException {
    	writer.startElement(HTML.H3_ELEM, null);
    	writer.writeAttribute(HtmlConstants.ID_ATTRIBUTE, "myModalLabel", null);
        writer.writeText(modal.getTitle(), modal, null);
        writer.endElement(HTML.H3_ELEM);
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