package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.ws.WebFault;

/**
 * @author Edson Cavalcanti
 * - Objetivo dessa classe é lançar uma exceção do tipo fault no mundo soap.
 * - @WebFault é uma anotação no qual personalizar o nosso retorno fault para um cliente soap
 * - No mundo java as exceções são mapeadas para faults, onde o JAX-WS define duas categorias ou tipo:
 *   - Modeled (Modelado) -> para mapear explicitamente a partir da logica de negocios no codigo Java. As definições desse Fault estão no arquivo WSDL, as falhas SOAP são previstas no WSDL.
 *   - Ummodeled (Não Modelado) -> para mapear uma exceção (normalmente do tipo RuntimeException) que acontecerá em tempos de execução de alguma lógica falha, neste caso são representados como falha SOAP generico. 
 *
 */

@WebFault(name = "AutorizacaoFault", messageName = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 1L;


	public AutorizacaoException(String msg) {
		super(msg);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token invalido", new Date());
	}

}
