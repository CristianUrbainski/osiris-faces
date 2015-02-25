package com.osiris.component.bootstrap.panel;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Classe que representa um panel do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 13/07/2013
 * @version 1.0
 *
 */
@ResourceDependencies({
	@ResourceDependency(library = "bootstrap", name = "css/bootstrap.min.css")
})
@FacesComponent(value = UIBootstrapPanel.COMPONENT_TYPE)
public class UIBootstrapPanel extends UIPanel {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.Panel";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrÃ£o do componente.
	 */
	private static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.PanelRenderer";
	
	/**
	 * Pacote otimizado do componente.
	 */
	private static final String OPTIMIZED_PACKAGE = "com.osiris.component.bootstrap.";
	
	/**
	 * Classe interna para definição dos parametros da classe.
	 * 
	 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
	 * @since 24/02/2015
	 * @version 1.0
	 *
	 */
	protected enum PropertyKeys {
		
		/**
		 * O titulo do panel.
		 */
		title,
		
		/**
		 * A classe do panel, primary, warning, success, danger, etc...
		 */
		severity,
		
		/**
		 * Estilo extra do compoente.
		 */
		style,
		
		/**
		 * Classe de estilo extra do componente.
		 */
		styleClass;
		
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
	 * Construtor default do componente.
	 */
	public UIBootstrapPanel() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public java.lang.String getTitle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.title, null);
	}
	
	public java.lang.String getSeverity() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.severity, "default");
	}
	
	/**
	 * Set do severity.
	 * @param severity do componente
	 */
	public void setSeverity(java.lang.String severity) {
		getStateHelper().put(PropertyKeys.severity, severity);
		handleAttribute("severity", severity);
	}
	
    /**
     * Set do title.
     * @param title 
     */
	public void setTitle(java.lang.String title) {
		getStateHelper().put(PropertyKeys.title, title);
		handleAttribute("title", title);
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