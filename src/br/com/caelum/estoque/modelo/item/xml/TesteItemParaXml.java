package br.com.caelum.estoque.modelo.item.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.caelum.estoque.modelo.item.Item;

/**
 * 
 * @author edson.h.cavalcanti
 * - SCHEMA -> JAXB mapped classes   [bind]   SCHEMAS <- JAXB mapped classes
 * 
 *  ^follows                                   ^ instances of 
 *    
 * - DOCUMENT -> unmarshal (validade)          OBJECTS    
 */
public class TesteItemParaXml {

	
	public static void main(String[] args) throws JAXBException {
		
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();
		
		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(item, new File("item.xml")); // Gerando o arquivo xml
		marshaller.marshal(item, System.out); // Escrevendo na tela o conteúdo xml
	}
	
}
