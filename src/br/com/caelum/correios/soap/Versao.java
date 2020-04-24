
package br.com.caelum.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for versao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="versao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="versaoAtual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versao", propOrder = {
    "versaoAtual"
})
public class Versao {

    protected String versaoAtual;

    /**
     * Gets the value of the versaoAtual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersaoAtual() {
        return versaoAtual;
    }

    /**
     * Sets the value of the versaoAtual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersaoAtual(String value) {
        this.versaoAtual = value;
    }

}
