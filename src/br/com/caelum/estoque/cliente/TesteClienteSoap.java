package br.com.caelum.estoque.cliente;

/**
 * 
 * @author Edson Cavalcanti
 * - EstoqueWSService � uma classe de f�brica que devolve o objeto que se chama Port.
 * - Esse Port sabe gerar e receber a mensagem SOAP e encapsula toda comunica��o remota.
 * - Print em cliente o JAX-WS menciona um Stub que � apenas um sin�nimo para Port ou Remote Proxy. 
 * - O Port � o objeto que se comunica com o servi�o remotamente, ele abstrai todos os detalhes como estabelecer a conex�o http e gerar a mensagem soap.
 *   No mundo de padr�es de projeto esse objeto tamb�m � chamado de Proxy ou Remote Proxy, vimos a defini��o do port no wsdl dentro de se��o service.
 * 
 */
public class TesteClienteSoap {

	public static void main(String[] args) {
		
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();
		System.out.println("Resposta do Servi�o" + cliente);
		
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
