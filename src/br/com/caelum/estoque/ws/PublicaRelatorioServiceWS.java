package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaRelatorioServiceWS {

	public static void main(String[] args) {
		
		RelatorioServiceWS implementacaoWS = new RelatorioServiceWS();
		String URL = "http://localhost:8090/relatoriows";
		
		System.out.println("RelatorioWS rodando: " + URL+"?wsdl" );
		
		Endpoint.publish(URL, implementacaoWS);
	}
}
