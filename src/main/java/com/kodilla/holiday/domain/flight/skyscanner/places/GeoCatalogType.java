
package com.kodilla.holiday.domain.flight.skyscanner.places;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for GeoCatalogType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoCatalogType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Continents" type="{}ContinentsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoCatalogType", propOrder = {
    "continents"
})
public class GeoCatalogType {

    @XmlElement(name = "Continents", required = true)
    ContinentsType continents;

    /**
     * Gets the value of the continents property.
     * 
     * @return
     *     possible object is
     *     {@link ContinentsType }
     *     
     */
    public ContinentsType getContinents() {
        return continents;
    }

    /**
     * Sets the value of the continents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinentsType }
     *     
     */
    public void setContinents(ContinentsType value) {
        this.continents = value;
    }

}
