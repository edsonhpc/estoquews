package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Edson Cavalcanti
 * - Objetivo dessa classe é de personalizar o detail no retorno de exceção Fault para o cliente SOAP
 * - Especificação JAX-WS: https://download.oracle.com/otndocs/jcp/jaxws-2_2a-mrel4-eval-spec/
 * - Elementos principais de um Fault
 *   - faulcode - Server ou Client para indicar onde ocorreu o problema, mas existem outros como VersionMissmatch
 *   - faulstring - uma explicação do Fault legível para humanos
 *   - detail - mais informações sobre o Fault, nomralmente específicas da aplicação
 *   - faulcode - e faulstring são obrigatórios.
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
