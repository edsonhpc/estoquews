package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * 
 * @author Edson Cavalcanti
 * - Executando um cliente dinâmico
 * - Há uma variação para criar um serviço web usando diretamente a classe Service do JAX-WS, mas devemos passar o URL e o namespace do serviço.
 * - Com esse código tem uma vantagem, a url do serviço é apenas uma strine pode ser alterado dinamicamente, isso pode ser útil quando queremos
 * 	 mudar de ambiente de homologação de ambiente de produção, nessa caso poderíamos configurar a URL em um arquivo externo e entre os ambientes 
 *   é trocado o arquivo.
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
