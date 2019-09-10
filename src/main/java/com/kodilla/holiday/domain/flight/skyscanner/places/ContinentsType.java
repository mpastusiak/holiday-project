
package com.kodilla.holiday.domain.flight.skyscanner.places;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContinentsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContinentsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Continent" type="{}ContinentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContinentsType", propOrder = {
    "continent"
})
public class ContinentsType {

    @XmlElement(name = "Continent")
    protected List<ContinentType> continent;

    /**
     * Gets the value of the continent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the continent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContinent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContinentType }
     * 
     * 
     */
    public List<ContinentType> getContinent() {
        if (continent == null) {
            continent = new ArrayList<ContinentType>();
        }
        return this.continent;
    }

}
