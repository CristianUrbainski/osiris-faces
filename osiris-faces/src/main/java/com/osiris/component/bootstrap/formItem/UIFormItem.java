package com.osiris.component.bootstrap.formItem;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Classe que representa o componente de formItem.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 14/11/2012
 * @version 1.0
 *
 */
@ResourceDependencies({
	@ResourceDependency(library = "bootstrap", name = "css/bootstrap.min.css")
})
@FacesComponent(value = UIFormItem.COMPONENT_TYPE)
public class UIFormItem extends UIPanel {

	/**
	 * Tipo do componente.
	 */
	public static final String COMPONENT_TYPE = "com.osiris.component.bootstrap.FormItem";
	
	/**
	 * Familia do componente.
	 */
	public static final String COMPONENT_FAMILY = "com.osiris.component.bootstrap";
	
	/**
	 * Renderizador padrão do componente.
	 */
	public static final String DEFAULT_RENDERER = "com.osiris.component.bootstrap.FormItemRenderer";
	
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
		 * Label para do componente.
		 */
		label,
		/**
		 * Label para o componente.
		 */
		labelFor,
		/**
		 * Classe de estilo para o label.
		 */
		labelClass,
		/**
		 * Classe de estilo para o div controls.
		 */
		controlClass,
		/**
		 * Posição do label.
		 */
		labelPosition,
		/**
		 * Style extra para o componente.
		 */
		style;
		
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
	 * Enum para o posicionamento do label do componente.
	 * 
	 * @author Cristian Urbainski <cristianurbainskips@gmail.com>
	 * @since 27/02/2015
	 * @version 1.0
	 *
	 */
	public enum PositionLabel {
		
		/**
		 * Label Top.
		 */
		top("top"),
		
		/**
		 * Label Left.
		 */
		left("left");
		
		/**
		 * Valor.
		 */
		private String value;
		
		/**
		 * Construtor default do componente.
		 * @param position posicao do label
		 */
		private PositionLabel(String position) {
			this.value = position;
		}
		
		public String getValue() {
			return value;
		}
		
		/**
		 * Método que retorna o toString da string interna.
		 * @return toString da string interna
		 */
		public String toString() {
			return value;
		}
		
	}
	
	/**
	 * Construtor default do componente.
	 */
	public UIFormItem() {
		setRendererType(DEFAULT_RENDERER);
	}
	
	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	
	public java.lang.String getLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.label, "");
	}
	
	/**
	 * Set do label.
	 * @param label
	 */
	public void setLabel(java.lang.String label) {
		getStateHelper().put(PropertyKeys.label, label);
		handleAttribute("label", label);
	}
	
	public java.lang.String getLabelFor() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.labelFor, "");
	}
	
	/**
	 * Set do label.
	 * @param label
	 */
	public void setLabelFor(java.lang.String labelFor) {
		getStateHelper().put(PropertyKeys.labelFor, labelFor);
		handleAttribute("labelFor", labelFor);
	}
	
	public java.lang.String getLabelClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.labelClass, "");
	}
	
	/**
	 * Set do labelClass.
	 * @param labelClass
	 */
	public void setaLbelClass(java.lang.String labelClass) {
		getStateHelper().put(PropertyKeys.labelClass, labelClass);
		handleAttribute("labelClass", labelClass);
	}
	
	public java.lang.String getControlClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.controlClass, "col-sm-5");
	}
	
	/**
	 * Set do controlClass.
	 * @param controlClass
	 */
	public void setControlClass(java.lang.String controlClass) {
		getStateHelper().put(PropertyKeys.controlClass, controlClass);
		handleAttribute("controlClass", controlClass);
	}
	
	public java.lang.String getLabelPosition() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.labelPosition, "left");
	}
	
	/**
	 * Set do labelPosition.
	 * @param labelPosition
	 */
	public void setLabelPosition(java.lang.String labelPosition) {
		getStateHelper().put(PropertyKeys.labelPosition, labelPosition);
		handleAttribute("labelPosition", labelPosition);
	}
	
	public java.lang.String getStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.style, "");
	}
	
	/**
	 * Set do style.
	 * @param style 
	 */
	public void setStyle(java.lang.String style) {
		getStateHelper().put(PropertyKeys.style, style);
		handleAttribute("style", style);
	}
	
	/**
	 * Método handleAttributes.
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