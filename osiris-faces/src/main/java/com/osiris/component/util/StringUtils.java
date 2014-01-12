package com.osiris.component.util;

/**
 * Classe utilitario para a classe String.
 * 
 * @author Cristian Urbainski<cristianurbainskips@gmail.com>
 * @since 28/12/2013
 * @version 1.0
 *
 */
public class StringUtils {

	/**
	 * Método responsavel por verificar se um string é
	 * null ou vazia.
	 * 
	 * @param str - string a ser comparada
	 * 
	 * @return <b>true</b> se a string for null ou fazia e <b>false</b>
	 * se a string tiver valor 
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	/**
	 * Método responsavel por verificar se um string não é
	 * null ou vazia.
	 * 
	 * @param str - string a ser comparada
	 * 
	 * @return <b>true</b> se a string não for null ou fazia e <b>false</b>
	 * se a string tiver valor 
	 */
	public static boolean isNotNullAndNotEmpty(String str) {
		return str != null && str.length() > 0;
	}
	
}
