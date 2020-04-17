package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.estoque.ws.DateAdapter;


/**
 * 
 * @author edson.h.cavalcanti
 * - @XmlAccessorType e @XmlElement s�o da especifica��o JAX-B que � utilizado pelo JAX-WS para gerar e ler o XSD/XML
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class TokenUsuario {

	@XmlElement(required = true) // Tornando o atributo obrigat�rio no servi�o SOAP
	private String token;
	
	@XmlJavaTypeAdapter(DateAdapter.class) // Anota��o para utilizar a nossa classe de Adpter para formata��o da Data String ou Date.
	@XmlElement(required = true) 
	private Date dataValidade;
	
	//JAX-B precisa desse construtor
	TokenUsuario() {
	}

	public TokenUsuario(String token, Date dataValidade) {
		this.token = token;
		this.dataValidade = dataValidade;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenUsuario other = (TokenUsuario) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenUsuario [token=" + token + ", dataValidade=" + dataValidade + "]";
	}
}
