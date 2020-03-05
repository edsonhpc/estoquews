package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

/***
 * 
 * @author Edson Cavalcanti
 * - Como não utilizamos um servidor normal, é preciso dessa classe para publicar o serviço programaticamente.
 * - No mundo de serviços web isso é chamado de publicar o Endpoint.
 * - O Endpoint é o endereço concreto do serviço, essa classe por sua vez tem o papel de associar a implementação com a url;
 * - WSDL significa Web Service Description Language e não é nada mais do que um XML que descreve o serviço.
 * - Na criação do serviço usando o SoapUI irá interpretar o WSDL e vai gerar um cliente que sabe usar o nosso serviço;
 * - Url: ttp://localhost:8090/estoquews?wsdl
 * - Ao confirmar a requisição SOAP, é feito uma requisição HTTP POST que envia XML, esse XML é a mensagem SOAP;
 * - 
 */

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8090/estoquews";
		
		System.out.println("EstoqueWS rodando: " + URL +"?wsdl"  );
		
		Endpoint.publish(URL, implementacaoWS);
	}
}
