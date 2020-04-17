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
 * - Classe que representa a implementação do serviço web;
 * - Essa classe é apenas uma implementação que atende as requisições, nada mais.
 * - @WebService essa anotação indica a criação do serviço e ao chamar  o método devemos usar o HTTP e XML;
 * - @WebMethod defino o nome do método que será exibido no WSDL fica bem expressivo;
 * - @WebResult defino o nome do retorno do método que será exibido no XML;
 * - Por debaixo dos panos o java ee utiliza o jax-b para serialização dos elementos;
 * - Por padrão o JAX-B não conhece a interface List, por isso ele substitui por um nome genérico (return).
 * - @WebParam é para inserir o nome do filtro no XML deixando o mesmo expressivo.
 * - @ResponseWrapper por padrão o SOAP usa o padrão Wrapped (embrulhado) essa para é para indicar qual método veio essa resposta.
 * - @RequestWrapper mesmo caso do item acima, porém consigo mudar no request o nome
 * - header e body - podemos separar as meta-informações dos dados principais.
 *    - body é onde fica os dados principais da mensagem soap
 *    - header colocamos informações de autenticação/autorização, validade da mensagem, tempos minimos de resposta ou dados sobre a transação entre outras possiblidades.
 * - NODE (nó) - em ambiente SOAP é comum trabalharmos com alguns intermediários entre cliente e server que validam os Headers e até os manipulam
 *   - Poderíamos ter um intermediário que verifica os dados de autenticação/autorização antes da mensagem chegar no servidor final.
 *   - Um outro poderia fazer uma auditoria para logar informações importantes do está sendo feito.
 *   - Esses intermediários o que são chamados de nó.
 *   - Cliente SOAP (sender) <->  SOAP NODE <-> SOAP NODE <-> Servidor SOAP (receiver)    
 */

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	
	@WebMethod(operationName = "TodosOsItens") // Essa anotação é opcional, no entanto, somente à utilizo para personalizar seu retorno no XML SOAP.
	@ResponseWrapper(localName = "itens") // Tag que envolve a lista de itens vai na resposta
	@WebResult(name = "itens") // Anotação para personalizar a requisição
	@RequestWrapper(localName="listaitens") // Será enviado no request 
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
	
	
	@WebMethod(exclude = true) // Excluir um método do contrato wsdl
	public void outroMetodo() {
		
	}
}
