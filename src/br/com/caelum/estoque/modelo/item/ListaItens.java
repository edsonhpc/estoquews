package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/***
 * 
 * @author Edson Cavalcanti
 * - O objetivo dessa classe é de embrulhar a nossa lista de itens e gerar uma lista item a item que será exposta no XML SOAP.
 * - Traduzindo: ele vai embrulhar a lista original;
 * - @XmlElement serve para redifinir o nome do elemento no XML (entre outras funções);
 */

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD) // Reconfiguração será feito direto pelos atributos e não pelos gets e sets que é o padrão do JAX-B
public class ListaItens {            // Fazendo dessa forma eu não preciso gerar um getter e um setter para serialização do JAX-B

	@XmlElement(name = "item") // Cada elemento dessa lista é um item que será exposto no XML SOAP
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
