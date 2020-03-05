package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

/***
 * 
 * @author Edson Cavalcanti
 * - Como n�o utilizamos um servidor normal, � preciso dessa classe para publicar o servi�o programaticamente.
 * - No mundo de servi�os web isso � chamado de publicar o Endpoint.
 * - O Endpoint � o endere�o concreto do servi�o, essa classe por sua vez tem o papel de associar a implementa��o com a url;
 * - WSDL significa Web Service Description Language e n�o � nada mais do que um XML que descreve o servi�o.
 * - Na cria��o do servi�o usando o SoapUI ir� interpretar o WSDL e vai gerar um cliente que sabe usar o nosso servi�o;
 * - Url: ttp://localhost:8090/estoquews?wsdl
 * - Ao confirmar a requisi��o SOAP, � feito uma requisi��o HTTP POST que envia XML, esse XML � a mensagem SOAP;
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
