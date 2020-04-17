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
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

/***
 * 
 * @author Edson Cavalcanti
 * - Classe que representa a implementa��o do servi�o web;
 * - Essa classe � apenas uma implementa��o que atende as requisi��es, nada mais.
 * - @WebService essa anota��o indica a cria��o do servi�o e ao chamar  o m�todo devemos usar o HTTP e XML;
 * - @WebMethod defino o nome do m�todo que ser� exibido no WSDL fica bem expressivo;
 * - @WebResult defino o nome do retorno do m�todo que ser� exibido no XML;
 * - Por debaixo dos panos o java ee utiliza o jax-b para serializa��o dos elementos;
 * - Por padr�o o JAX-B n�o conhece a interface List, por isso ele substitui por um nome gen�rico (return).
 * - @WebParam � para inserir o nome do filtro no XML deixando o mesmo expressivo.
 * - @ResponseWrapper por padr�o o SOAP usa o padr�o Wrapped (embrulhado) essa para � para indicar qual m�todo veio essa resposta.
 * - @RequestWrapper mesmo caso do item acima, por�m consigo mudar no request o nome
 * - header e body - podemos separar as meta-informa��es dos dados principais.
 *    - body � onde fica os dados principais da mensagem soap
 *    - header colocamos informa��es de autentica��o/autoriza��o, validade da mensagem, tempos minimos de resposta ou dados sobre a transa��o entre outras possiblidades.
 * - NODE (n�) - em ambiente SOAP � comum trabalharmos com alguns intermedi�rios entre cliente e server que validam os Headers e at� os manipulam
 *   - Poder�amos ter um intermedi�rio que verifica os dados de autentica��o/autoriza��o antes da mensagem chegar no servidor final.
 *   - Um outro poderia fazer uma auditoria para logar informa��es importantes do est� sendo feito.
 *   - Esses intermedi�rios o que s�o chamados de n�.
 *   - Cliente SOAP (sender) <->  SOAP NODE <-> SOAP NODE <-> Servidor SOAP (receiver)    
 */

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName = "TodosOsItens") // Essa anota��o � opcional, no entanto, somente � utilizo para personalizar seu retorno no XML SOAP.
	@ResponseWrapper(localName = "itens") // Tag que envolve a lista de itens vai na resposta
	@WebResult(name = "itens") // Anota��o para personalizar a requisi��o
	@RequestWrapper(localName="listaitens") // Ser� enviado no request 
	public ListaItens getItens(@WebParam(name = "filtros" ) Filtros filtros) {
		
		System.out.println("Chamando getItens()");
		
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado  = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);
	}
	
	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name="tokenUsuario" , header = true) TokenUsuario token, @WebParam(name = "item") Item item) throws AutorizacaoException {
		
		System.out.println("Cadastrando " + item + " , " + token);
		
		boolean valido = new TokenDao().ehValido(token);
		
		if(!valido) {
			throw new AutorizacaoException("Autorizacao falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		
		return item;
	}
	
	
	@WebMethod(exclude = true) // Excluir um m�todo do contrato wsdl
	public void outroMetodo() {
		
	}
}
