
package com.kodilla.holiday.domain.flight.skyscanner.places;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Airports" type="{}AirportsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CountryId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Location" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IataCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SingleAirportCity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RegionId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityType", propOrder = {
    "airports"
})
public class CityType {

    @XmlElement(name = "Airports", required = true)
    protected AirportsType airports;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "CountryId")
    protected String countryId;
    @XmlAttribute(name = "Location")
    protected String location;
    @XmlAttribute(name = "IataCode")
    protected String iataCode;
    @XmlAttribute(name = "SingleAirportCity")
    protected String singleAirportCity;
    @XmlAttribute(name = "RegionId")
    protected String regionId;

    /**
     * Gets the value of the airports property.
     * 
     * @return
     *     possible object is
     *     {@link AirportsType }
     *     
     */
    public AirportsType getAirports() {
        return airports;
    }

    /**
     * Sets the value of the airports property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirportsType }
     *     
     */
    public void setAirports(AirportsType value) {
        this.airports = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryId(String value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the iataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIataCode() {
        return iataCode;
    }

    /**
     * Sets the value of the iataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIataCode(String value) {
        this.iataCode = value;
    }

    /**
     * Gets the value of the singleAirportCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleAirportCity() {
        return singleAirportCity;
    }

    /**
     * Sets the value of the singleAirportCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleAirportCity(String value) {
        this.singleAirportCity = value;
    }

    /**
     * Gets the value of the regionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * Sets the value of the regionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionId(String value) {
        this.regionId = value;
    }

}
