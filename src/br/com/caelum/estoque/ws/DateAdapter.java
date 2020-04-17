package br.com.caelum.estoque.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * @author Edson Cavalcanti
 * - Objetivo de classe é a criação de um Adapter ou seja "Adaptação" no qual recebemos uma data que pode ser no formato String ou Date.
 * - A partir desse Adapter o JAX-B quando ele encontrar o valor do atributo dateValidade no formado de dd/MM/yyyy, esse valor deve ser convertido em um date (unmarshal) 
 *
 */
public class DateAdapter extends XmlAdapter<String, Date>{ // Precisamos extender essa classe abstrata para informarmos ao JAX-B que essa classe é um Adpter

	private String pattern = "dd/MM/yyyy";
	
	// Convert uma string em Date
	public Date unmarshal(String dateString) throws Exception { 
		return new SimpleDateFormat(pattern).parse(dateString);
	}
	
	// Convert um Date em String
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(pattern).format(date);
	}
	
}
