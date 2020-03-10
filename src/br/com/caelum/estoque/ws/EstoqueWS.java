package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

/***
 * 
 * @author Edson Cavalcanti
 * - Classe que representa a implementa��o do servi�o web;
 * - @WebService essa anota��o indica a cria��o do servi�o e ao chamar  o m�todo devemos usar o HTTP e XML;
 * - @WebMethod defino o nome do m�todo que ser� exibido no WSDL fica bem expressivo;
 * - @WebResult defino o nome do retorno do m�todo que ser� exibido no XML;
 * - Por debaixo dos panos o java ee utiliza o jax-b para serializa��o dos elementos;
 * - Por padr�o o JAX-B n�o conhece a interface List, por isso ele substitui por um nome gen�rico (return).
 * - @WebParam � para inserir o nome do filtro no XML deixando o mdesmo expressivo.
 * - @ResponseWrapper por padr�o o SOAP usa o padr�o Wrapped (embrulhado) essa para � para indicar qual m�todo veio essa resposta.
 * - @RequestWrapper mesmo caso do item acima, por�m consigo mudar no request o nome
 */

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName = "todosOsItens") // Essa anota��o � opcional, no entanto, somente � utilizo para personalizar seu retorno no XML SOAP.
	@ResponseWrapper(localName = "itens") // Tag que envolve a lista de itens vai na resposta
	@WebResult(name = "itens") // Anota��o para personalizar a requisi��o
	@RequestWrapper(localName="listagemItens") // Ser� enviado no request 
	public ListaItens getItens(@WebParam(name = "filtros" ) Filtros filtros) {
		
		System.out.println("Chamando getItens()");
		
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado  = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);
	}
	
	@WebMethod(exclude = true) // Excluir um m�todo do contrato wsdl
	public void outroMetodo() {
		
	}
}
