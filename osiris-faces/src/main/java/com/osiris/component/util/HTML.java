package com.osiris.component.util;

import org.primefaces.util.ArrayUtils;

/**
 * Interface utilitária para manter constantes de tags html.
 * 
 * @author dirvan.vargas
 */
public final class HTML {
	
	/**
	 * Construtor default.
	 */
	private HTML() { }

	/**
	 * Elemento strong do HTML.
	 */
	public static final String STRONG_ELEM = "strong";
	/**
	 * Elemento span.
	 */
	public static final String SPAN_ELEM = "span";
	/**
	 * Elemnto div.
	 */
	public static final String DIV_ELEM = "div";
	
	/**
	 * Elemnto label.
	 */
	public static final String LABEL_ELEM = "label";

	/**
	 * Elementos de lista.
	 */
	public static final String UL_ELEM = "ul";

	/**
	 * Elementos list item.
	 */
	public static final String LI_ELEM = "li";

	/**
	 * Elementos link.
	 */
	public static final String A_ELEM = "a";
	
	/**
	 * Elementos b.
	 */
	public static final String B_ELEM = "b";

	/**
	 * Elemento script.
	 */
	public static final String SCRIPT_ELEM = "script";

	/**
	 * Elemento script.
	 */
	public static final String BUTTON_ELEM = "button";

	/**
	 * Elemento H3.
	 */
	public static final String H3_ELEM = "h3";
	
	/**
	 * Elemento H4.
	 */
	public static final String H4_ELEM = "h4";
	
	/**
	 * Elemento tabela.
	 */
	public static final String TABLE_ELEM = "table";
	
	/**
	 * Elemento tr (linha).
	 */
	public static final String TR_ELEM = "tr";
	
	/**
	 * Elemento th (cabeçalho coluna).
	 */
	public static final String TH_ELEM = "th";
	
	/**
	 * Elemento td (coluna).
	 */
	public static final String TD_ELEM = "td";
	
	/**
	 * Elemento thead (cabeçalho tabela).
	 */
	public static final String THEAD_ELEM = "thead";
	
	/**
	 * Elemento tfoot (rodapé tabela).
	 */
	public static final String TFOOT_ELEM = "tfoot";
	
	/**
	 * Elemento tbody (corpo tabela).
	 */
	public static final String TBODY_ELEM = "tbody";
	
	/**
	 * Elemento input.
	 */
	public static final String INPUT_ELEM = "input";
	
	/**
	 * Atributos com eventos para um input.
	 */
	public static final String[] INPUT_TEXT_ATTRS_WITHOUT_EVENTS = {
		"accesskey",
		"alt",
        "autocomplete",
		"dir",
		"lang",
		"maxlength",
		"size",
		"tabindex",
		"title"
	};
	
	/**
	 * Eventos comuns ao componentes html.
	 */
	public static final String[] COMMON_EVENTS = {
		"onclick",
		"ondblclick",
		"onkeydown",
		"onkeypress",
		"onkeyup",
		"onmousedown",
		"onmousemove",
		"onmouseout",
		"onmouseover",
		"onmouseup"
	};
	
	/**
	 * Mudança de valor componente select.
	 */
	public static final String[] CHANGE_SELECT_EVENTS = {
		"onchange",
		"onselect"
	};
	
	/**
	 * Evento de focos.
	 */
	public static final String[] BLUR_FOCUS_EVENTS = {
		"onblur",
		"onfocus"
	};
	
	/**
	 * Atributos do input text do html.
	 */
	public static final String[] INPUT_TEXT_ATTRS = ArrayUtils.concat(
			INPUT_TEXT_ATTRS_WITHOUT_EVENTS, COMMON_EVENTS, CHANGE_SELECT_EVENTS, BLUR_FOCUS_EVENTS);
	
}