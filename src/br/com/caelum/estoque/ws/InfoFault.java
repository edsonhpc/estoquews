package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Edson Cavalcanti
 * - Objetivo dessa classe � de personalizar o detail no retorno de exce��o Fault para o cliente SOAP
 * - Especifica��o JAX-WS: https://download.oracle.com/otndocs/jcp/jaxws-2_2a-mrel4-eval-spec/
 * - Elementos principais de um Fault
 *   - faulcode - Server ou Client para indicar onde ocorreu o problema, mas existem outros como VersionMissmatch
 *   - faulstring - uma explica��o do Fault leg�vel para humanos
 *   - detail - mais informa��es sobre o Fault, nomralmente espec�ficas da aplica��o
 *   - faulcode - e faulstring s�o obrigat�rios.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	
	private Date dataErro;
	private String mensagem;
	
	public InfoFault(String mensagem, Date dataErro) {
		this.mensagem = mensagem;
		this.dataErro = dataErro;
	}
	
	public InfoFault() {
		
	}

}
