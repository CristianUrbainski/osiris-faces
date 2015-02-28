package com.osiris.component.bootstrap.alert;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Componente que constroi um alert como do bootstrap para ser usado no jsf.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 23/07/2013
 * @version 1.0
 *
 */
@ResourceDependencies({
	@ResourceDependency(library = "bootstrap", name = "css/bootstrap.css"),
	@ResourceDependency(library = "bootstrap", name = "js/bootstrap.js")
})
@FacesComponent(value = UIAlert.COMPONENT_TYPE)
public class UIAlert extends UIPanel {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.Alert";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrão do componente.
	 */
	private static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.AlertRenderer";
	
	/**
	 * Pacote otimizado do componente.
	 */
	private static final String OPTIMIZED_PACKAGE = "com.osiris.component.bootstrap.";

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
		 * Se é ou não permitido fechar o alerta.
		 */
		closeable,
		/**
		 * A classe css de estilo final do componente.
		 */
		severity,
		/**
		 * O titulo do alerta.
		 */
		title,
		/**
		 * A mensagem de alerta para o usuario.
		 */
		message;
		
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
		 * Método que retorna o toString da string interna.
		 * @return toString da string interna
		 */
		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

	/**
	 * Construtor padrão do componente.
	 */
	public UIAlert() {
		setRendererType(DEFAULT_RENDERER);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
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
    
	public java.lang.String getSeverity() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.severity, null);
	}
	
    /**
     * Set do severity.
     * @param severity 
     */
	public void setSeverity(java.lang.String severity) {
		getStateHelper().put(PropertyKeys.severity, severity);
		handleAttribute("severity", severity);
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
	
	public java.lang.String getMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.message, null);
	}
	
	/**
	 * Set da message.
	 * @param message 
	 */
	public void setMessage(java.lang.String message) {
		getStateHelper().put(PropertyKeys.message, message);
		handleAttribute("message", message);
	}
	
	/**
	 * Método handleAttributes copiado do primefaces.
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