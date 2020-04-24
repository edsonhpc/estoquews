package br.com.caelum.estoque.cliente;

/**
 * 
 * @author Edson Cavalcanti
 * - EstoqueWSService é uma classe de fábrica que devolve o objeto que se chama Port.
 * - Esse Port sabe gerar e receber a mensagem SOAP e encapsula toda comunicação remota.
 * - Print em cliente o JAX-WS menciona um Stub que é apenas um sinônimo para Port ou Remote Proxy. 
 * - O Port é o objeto que se comunica com o serviço remotamente, ele abstrai todos os detalhes como estabelecer a conexão http e gerar a mensagem soap.
 *   No mundo de padrões de projeto esse objeto também é chamado de Proxy ou Remote Proxy, vimos a definição do port no wsdl dentro de seção service.
 * 
 */
public class TesteClienteSoap {

	public static void main(String[] args) {
		
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();
		System.out.println("Resposta do Serviço" + cliente);
		
		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);
		
		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		
		ListaItens lista = cliente.todosOsItens(filtros);
		
		lista.item.forEach(item -> {
			System.out.println(
					String.format("%s %s %s %s", item.codigo, item.nome, item.quantidade, item.tipo)
			 );
		});
	}

}
