package com.osiris.component.bootstrap.commandButton;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;

import org.primefaces.component.commandbutton.CommandButton;

/**
 * Classe que representa o componente button do html com o css do bootstrap.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 18/07/2013
 * @version 1.0
 *
 */
@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "primefaces.css"),
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "commandButton", name = "commandButton.js")
})
@FacesComponent(value = UIBootstrapCommandButton.COMPONENT_TYPE)
public class UIBootstrapCommandButton extends CommandButton {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.CommandButton";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrão do componente.
	 */
	private static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.CommandButtonRenderer";
	
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
		 * O tamanho do botao, small, mini e large.
		 */
		scale,
		/**
		 * A classe do botao, primery, warning, success, danger, etc...
		 */
		severity;
		
		/**
		 * Valor que ser� retornado.
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
	public UIBootstrapCommandButton() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public java.lang.String getSeverity() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.severity, null);
	}
	
	/**
	 * Set do severity.
	 * @param severity do componente
	 */
	public void setSeverity(java.lang.String severity) {
		getStateHelper().put(PropertyKeys.severity, severity);
		handleAttribute("severity", severity);
	}
	
	public java.lang.String getScale() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.scale, null);
	}
	
	/**
	 * Set do scale.
	 * @param scale scala do componente
	 */
	public void setScale(java.lang.String scale) {
		getStateHelper().put(PropertyKeys.scale, scale);
		handleAttribute("scale", scale);
	}
	
	@Override
	@Deprecated
	public String resolveStyleClass() {
		return "";
	}
	
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