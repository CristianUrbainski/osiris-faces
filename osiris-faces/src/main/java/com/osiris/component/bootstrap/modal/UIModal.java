package com.osiris.component.bootstrap.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UIPanel;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;

import com.osiris.component.api.Widget;
import com.osiris.component.event.CloseEvent;
import com.osiris.component.util.Constantes;

/**
 * 
 * Classe que representa um component modal.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@ResourceDependencies({
	@ResourceDependency(library = "javax.faces", 	name = "jsf.js"),
	@ResourceDependency(library = "primefaces", 	name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", 	name = "primefaces.js"),
	@ResourceDependency(library = "js", 			name = "bootstrap.min.js"),
	@ResourceDependency(library = "modal", 			name = "modal.js"),
	@ResourceDependency(library = "css", 			name = "bootstrap.min.css")
})
@FacesComponent(value = UIModal.COMPONENT_TYPE)
public class UIModal extends UIPanel implements Widget, ClientBehaviorHolder {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.Modal";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrão do componente.
	 */
	private static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.ModalRenderer";
	
	/**
	 * Pacote otimizado do componente.
	 */
	private static final String OPTIMIZED_PACKAGE = "com.osiris.component.bootstrap.";
	
	/**
	 * Identificador do evento de close do modal.
	 */
	public static final String CLOSE_EVENT_NAME = "close";
	
	/**
	 * Efeito padrão do componente modal.
	 */
	private static final String EFFECT_DEFAULT = "fade"; 

	/**
	 * Nome dos eventos.
	 */
    private static final Collection<String> EVENT_NAMES = 
    		Collections.unmodifiableCollection(Arrays.asList("close"));
	
	/**
	 * Classe interna para definição dos parametros da classe.
	 * 
	 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
	 * @since 18/07/2013
	 * @version 1.0
	 *
	 */
	protected enum PropertyKeys {
		/**
		 * Se é ou não permitido fechar o modal.
		 */
		closeable,
		/**
		 * Efeito da janla modal.
		 */
		effect,
		/**
		 * Titulo da janela.
		 */
		title,
		/**
		 * Largura da janela.
		 */
		width,
		/**
		 * Largura minima da janela.
		 */
		minWidth,
		/**
		 * Altura minima da janela.
		 */
		minHeight,
		/**
		 * Estilo extra do compoente.
		 */
		style,
		/**
		 * Classe de estilo extra do componente.
		 */
		styleClass,
		/**
		 * Identifica se o modal esta visivel ou n�o.
		 */
		visible,
		/**
		 * Identificado do objeto javascript correspondente ao componente.
		 */
		widgetVar,
		/**
		 * Funcao javascript que sera chamada quando o modal for aberto. 
		 */
		onOpen,
		/**
		 * Funcao javascript que sera chamada quando o modal for fechado. 
		 */
		onClose;
		
		/**
		 * Valor que será retornado.
		 */
		private String toString;

		/**
		 * Construtor default do componente.
		 * @param toString valor da string
		 */
		PropertyKeys(String toString) {
			this.toString = toString;
		}

		/**
		 * Construtor default do componente.
		 */
		PropertyKeys() { }

		/**
		 * Metodo que retorna o toString da string interna.
		 * @return toString da string interna
		 */
		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}
	
	/**
	 * Construtor default do componente.
	 */
	public UIModal() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public java.lang.String getOnOpen() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onOpen, null);
	}
	
	/**
	 * Set do onOpen.
	 * @param onOpen 
	 */
	public void setOnOpen(java.lang.String onOpen) {
		getStateHelper().put(PropertyKeys.onOpen, onOpen);
		handleAttribute("onOpen", onOpen);
	}
	
	public java.lang.String getOnClose() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onClose, null);
	}
	
	/**
	 * Set do onClose.
	 * @param onClose 
	 */
	public void setOnClose(java.lang.String onClose) {
		getStateHelper().put(PropertyKeys.onClose, onClose);
		handleAttribute("onClose", onClose);
	}
	
	public boolean isVisible() {
		return (Boolean) getStateHelper().eval(PropertyKeys.visible, false);
	}
	
	/**
	 * Set do visible.
	 * @param visible 
	 */
	public void setVisible(boolean visible) {
		getStateHelper().put(PropertyKeys.visible, visible);
		handleAttribute("visible", visible);
	}
	
	public java.lang.String getEffect() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.effect, EFFECT_DEFAULT);
	}
	
	/**
	 * Set do effect.
	 * @param effect 
	 */
	public void setEffect(java.lang.String effect) {
		getStateHelper().put(PropertyKeys.effect, effect);
		handleAttribute("effect", effect);
	}
	
	public java.lang.String getTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.title, null);
	}
	
	/**
	 * Set do title.
	 * @param title 
	 */
	public void setTitle(java.lang.String title) {
		getStateHelper().put(PropertyKeys.title, title);
		handleAttribute("title", title);
	}
	
    public boolean isCloseable() {
    	return (Boolean) getStateHelper().eval(PropertyKeys.closeable, true);
    }

    /**
     * Set do closeable.
     * @param closeable 
     */
    public void setCloseable(boolean closeable) {
    	getStateHelper().put(PropertyKeys.closeable, closeable);
    	handleAttribute("closeable", closeable);
    }

	public java.lang.String getWidth() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.width, null);
	}
	
	/**
	 * Set do width.
	 * @param width 
	 */
	public void setWidth(java.lang.String width) {
		getStateHelper().put(PropertyKeys.width, width);
		handleAttribute("width", width);
	}

	public int getMinWidth() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minWidth, java.lang.Integer.MIN_VALUE);
	}
	
	/**
	 * Set do minWidth.
	 * @param minWidth 
	 */
	public void setMinWidth(int minWidth) {
		getStateHelper().put(PropertyKeys.minWidth, minWidth);
		handleAttribute("minWidth", minWidth);
	}

	public int getMinHeight() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.minHeight, java.lang.Integer.MIN_VALUE);
	}
	
	/**
	 * Set do minHeight.
	 * @param minHeight 
	 */
	public void setMinHeight(int minHeight) {
		getStateHelper().put(PropertyKeys.minHeight, minHeight);
		handleAttribute("minHeight", minHeight);
	}
	
	public java.lang.String getStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.style, null);
	}
	
	/**
	 * Set do style.
	 * @param style 
	 */
	public void setStyle(java.lang.String style) {
		getStateHelper().put(PropertyKeys.style, style);
		handleAttribute("style", style);
	}

	public java.lang.String getStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass, null);
	}
	
	/**
	 * Set do styleClass.
	 * @param styleClass 
	 */
	public void setStyleClass(java.lang.String styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, styleClass);
		handleAttribute("styleClass", styleClass);
	}
	
	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	
	/**
	 * Set do widgetVar.
	 * @param widgetVar 
	 */
	public void setWidgetVar(java.lang.String widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, widgetVar);
		handleAttribute("widgetVar", widgetVar);
	}
	
    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    @Override
    public String getDefaultEventName() {
        return new ArrayList<String>(EVENT_NAMES).get(0);
    }
    
    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = getFacesContext();

        if (isRequestSource(context) && event instanceof AjaxBehaviorEvent) {
            String eventName = context.getExternalContext()
            		.getRequestParameterMap().get(Constantes.PARTIAL_BEHAVIOR_EVENT_PARAM);

            if (eventName.equals("close")) {
                CloseEvent closeEvent = new CloseEvent(this, ((AjaxBehaviorEvent) event).getBehavior());
                closeEvent.setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
                super.queueEvent(closeEvent);
                context.renderResponse(); // just process the close event and skip to response
            } else {
                super.queueEvent(event);
            }
        } else {
            super.queueEvent(event);
        }
    }

    /**
     * Request é de source.
     * 
     * @param context do jsf
     * @return true ou false
     */
    private boolean isRequestSource(FacesContext context) {
        return this.getClientId(context).equals(
        		context.getExternalContext().getRequestParameterMap().get(Constantes.PARTIAL_SOURCE_PARAM));
    }
    
    /**
     * Método capaz de resolver o nome do widget.
     * @return nome do widget
     */
	public String resolveWidgetVar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if (userWidgetVar != null) {
			return userWidgetVar;
		} else {
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
		}
	}
	
	/**
	 * Método hanfleAttributes copiado do primefaces.
	 * 
	 * @param name nome 
	 * @param value objeto
	 */
	@SuppressWarnings("unchecked")
	public void handleAttribute(String name, Object value) {
		List<String> setAttributes = (List<String>) 
				this.getAttributes().get("javax.faces.component.UIComponentBase.attributesThatAreSet");
		
		if (setAttributes == null) {
			String cname = this.getClass().getName();
			if (cname != null && cname.startsWith(OPTIMIZED_PACKAGE)) {
				setAttributes = new ArrayList<String>(Integer.parseInt("6"));
				this.getAttributes().put("javax.faces.component.UIComponentBase.attributesThatAreSet", setAttributes);
			}
		}
		if (setAttributes != null) {
			if (value == null) {
				ValueExpression ve = getValueExpression(name);
				if (ve == null) {
					setAttributes.remove(name);
				} else if (!setAttributes.contains(name)) {
					setAttributes.add(name);
				}
			}
		}
	}

}