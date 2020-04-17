package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/***
 * 
 * @author Edson Cavalcanti
 * - O objetivo dessa classe � de embrulhar a nossa lista de itens e gerar uma lista item a item que ser� exposta no XML SOAP.
 * - Traduzindo: ele vai embrulhar a lista original;
 * - @XmlElement serve para redifinir o nome do elemento no XML (entre outras fun��es);
 */

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD) // Reconfigura��o ser� feito direto pelos atributos e n�o pelos gets e sets que � o padr�o do JAX-B
public class ListaItens {            // Fazendo dessa forma eu n�o preciso gerar um getter e um setter para serializa��o do JAX-B

	@XmlElement(name = "item") // Cada elemento dessa lista � um item que ser� exposto no XML SOAP
	private List<Item> itens;

	
	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}
	
	
	public List<Item> getItens() {
		return itens;
	}
	
}
