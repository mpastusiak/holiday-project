
package com.kodilla.holiday.domain.flight.skyscanner.places;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kodilla.holiday.domain.flight.skyscanner.places.places package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeoCatalog_QNAME = new QName("", "GeoCatalog");
    private final static QName _CountryTypeRegionsRegion_QNAME = new QName("", "Region");
    private final static QName _CitiesTypeCity_QNAME = new QName("", "City");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kodilla.holiday.domain.flight.skyscanner.places.places
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountryType }
     * 
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link GeoCatalogType }
     * 
     */
    public GeoCatalogType createGeoCatalogType() {
        return new GeoCatalogType();
    }

    /**
     * Create an instance of {@link AirportType }
     * 
     */
    public AirportType createAirportType() {
        return new AirportType();
    }

    /**
     * Create an instance of {@link ContinentsType }
     * 
     */
    public ContinentsType createContinentsType() {
        return new ContinentsType();
    }

    /**
     * Create an instance of {@link RegionType }
     * 
     */
    public RegionType createRegionType() {
        return new RegionType();
    }

    /**
     * Create an instance of {@link CityType }
     * 
     */
    public CityType createCityType() {
        return new CityType();
    }

    /**
     * Create an instance of {@link CitiesType }
     * 
     */
    public CitiesType createCitiesType() {
        return new CitiesType();
    }

    /**
     * Create an instance of {@link AirportsType }
     * 
     */
    public AirportsType createAirportsType() {
        return new AirportsType();
    }

    /**
     * Create an instance of {@link ContinentType }
     * 
     */
    public ContinentType createContinentType() {
        return new ContinentType();
    }

    /**
     * Create an instance of {@link CountriesType }
     * 
     */
    public CountriesType createCountriesType() {
        return new CountriesType();
    }

    /**
     * Create an instance of {@link RegionsType }
     * 
     */
    public RegionsType createRegionsType() {
        return new RegionsType();
    }

    /**
     * Create an instance of {@link CountryType.Regions }
     * 
     */
    public CountryType.Regions createCountryTypeRegions() {
        return new CountryType.Regions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCatalogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GeoCatalog")
    public JAXBElement<GeoCatalogType> createGeoCatalog(GeoCatalogType value) {
        return new JAXBElement<GeoCatalogType>(_GeoCatalog_QNAME, GeoCatalogType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Region", scope = CountryType.Regions.class)
    public JAXBElement<RegionType> createCountryTypeRegionsRegion(RegionType value) {
        return new JAXBElement<RegionType>(_CountryTypeRegionsRegion_QNAME, RegionType.class, CountryType.Regions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "City", scope = CitiesType.class)
    public JAXBElement<CityType> createCitiesTypeCity(CityType value) {
        return new JAXBElement<CityType>(_CitiesTypeCity_QNAME, CityType.class, CitiesType.class, value);
    }

}
