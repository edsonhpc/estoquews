
package br.com.caelum.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cResultadoModal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cResultadoModal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServicosModal" type="{http://tempuri.org/}ArrayOfCModal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cResultadoModal", propOrder = {
    "servicosModal"
})
public class CResultadoModal {

    @XmlElement(name = "ServicosModal")
    protected ArrayOfCModal servicosModal;

    /**
     * Gets the value of the servicosModal property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCModal }
     *     
     */
    public ArrayOfCModal getServicosModal() {
        return servicosModal;
    }

    /**
     * Sets the value of the servicosModal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCModal }
     *     
     */
    public void setServicosModal(ArrayOfCModal value) {
        this.servicosModal = value;
    }

}
