package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.ws.WebFault;

/**
 * @author Edson Cavalcanti
 * - Objetivo dessa classe � lan�ar uma exce��o do tipo fault no mundo soap.
 * - @WebFault � uma anota��o no qual personalizar o nosso retorno fault para um cliente soap
 * - No mundo java as exce��es s�o mapeadas para faults, onde o JAX-WS define duas categorias ou tipo:
 *   - Modeled (Modelado) -> para mapear explicitamente a partir da logica de negocios no codigo Java. As defini��es desse Fault est�o no arquivo WSDL, as falhas SOAP s�o previstas no WSDL.
 *   - Ummodeled (N�o Modelado) -> para mapear uma exce��o (normalmente do tipo RuntimeException) que acontecer� em tempos de execu��o de alguma l�gica falha, neste caso s�o representados como falha SOAP generico. 
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
