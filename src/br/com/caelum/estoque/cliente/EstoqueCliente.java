package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * 
 * @author Edson Cavalcanti
 * - Executando um cliente din�mico
 * - H� uma varia��o para criar um servi�o web usando diretamente a classe Service do JAX-WS, mas devemos passar o URL e o namespace do servi�o.
 * - Com esse c�digo tem uma vantagem, a url do servi�o � apenas uma strine pode ser alterado dinamicamente, isso pode ser �til quando queremos
 * 	 mudar de ambiente de homologa��o de ambiente de produ��o, nessa caso poder�amos configurar a URL em um arquivo externo e entre os ambientes 
 *   � trocado o arquivo.
 *
 */
public class EstoqueCliente {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8080/estoque-web/EstoqueWS?wsdl");    // Url
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS"); // Namespace 

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);

		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		
		ListaItens lista = cliente.todosOsItens(filtros);
		
		for (Item item : lista.item ) {
			System.out.println(
					String.format("%s %s %s %s", item.codigo, item.nome, item.quantidade, item.tipo)
			 );
		}
	}
}
