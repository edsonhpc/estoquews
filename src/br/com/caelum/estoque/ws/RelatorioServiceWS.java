package br.com.caelum.estoque.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RelatorioServiceWS {

	@Oneway
	@WebMethod(operationName = "GerarRelatorio")
	public void gerarRelatorio() {
		
		System.out.println("Enviado com sucesso...");
	}
}
