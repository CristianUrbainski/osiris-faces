package com.osiris.component.bootstrap.menu;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * 
 * Classe que representa um component menu.
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
	@ResourceDependency(library = "css", 			name = "bootstrap.min.css"),
	@ResourceDependency(library = "css", 			name = "menu.css")
})
@FacesComponent(value = UIMenu.COMPONENT_TYPE)
public class UIMenu extends UIPanel {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.Menu";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrão do componente.
	 */
	private static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.MenuRenderer";
	
	/**
	 * Pacote otimizado do componente.
	 */
	private static final String OPTIMIZED_PACKAGE = "com.osiris.component.bootstrap.";
	
	/**
	 * Classe interna para defini��o dos parametros da classe.
	 * 
	 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
	 * @since 18/07/2013
	 * @version 1.0
	 *
	 */
	protected enum PropertyKeys {
		/**
		 * Label do componente, mostrado para o usuário.
		 */
		label,
		
		/**
		 * Estilo css do componente.
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
	 * Construtor default do componente de menu.
	 */
	public UIMenu() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	/**
	 * Set do label.
	 * @param label 
	 */
	public void setLabel(java.lang.String label) {
		getStateHelper().put(PropertyKeys.label, label);
		handleAttribute("label", label);
	}
	
	public java.lang.String getLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.label, null);
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