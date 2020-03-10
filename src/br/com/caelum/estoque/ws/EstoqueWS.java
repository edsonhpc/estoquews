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
 * - Classe que representa a implementação do serviço web;
 * - @WebService essa anotação indica a criação do serviço e ao chamar  o método devemos usar o HTTP e XML;
 * - @WebMethod defino o nome do método que será exibido no WSDL fica bem expressivo;
 * - @WebResult defino o nome do retorno do método que será exibido no XML;
 * - Por debaixo dos panos o java ee utiliza o jax-b para serialização dos elementos;
 * - Por padrão o JAX-B não conhece a interface List, por isso ele substitui por um nome genérico (return).
 * - @WebParam é para inserir o nome do filtro no XML deixando o mdesmo expressivo.
 * - @ResponseWrapper por padrão o SOAP usa o padrão Wrapped (embrulhado) essa para é para indicar qual método veio essa resposta.
 * - @RequestWrapper mesmo caso do item acima, porém consigo mudar no request o nome
 */

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName = "todosOsItens") // Essa anotação é opcional, no entanto, somente à utilizo para personalizar seu retorno no XML SOAP.
	@ResponseWrapper(localName = "itens") // Tag que envolve a lista de itens vai na resposta
	@WebResult(name = "itens") // Anotação para personalizar a requisição
	@RequestWrapper(localName="listagemItens") // Será enviado no request 
	public ListaItens getItens(@WebParam(name = "filtros" ) Filtros filtros) {
		
		System.out.println("Chamando getItens()");
		
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado  = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);
	}
	
	@WebMethod(exclude = true) // Excluir um método do contrato wsdl
	public void outroMetodo() {
		
	}
}
