package com.kodilla.holiday.service.flight.skyscanner;

import com.kodilla.holiday.domain.flight.skyscanner.places.CityType;
import com.kodilla.holiday.domain.flight.skyscanner.places.CountryType;
import com.kodilla.holiday.domain.flight.skyscanner.places.GeoCatalogType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeoCatalogService {

    public GeoCatalogType getGeoCatalog() {
        GeoCatalogType geoCatalog = new GeoCatalogType();
        try {
            JAXBContext jc = JAXBContext.newInstance(GeoCatalogType.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Source source = new StreamSource("src/main/resources/places_list.xml");
            JAXBElement<GeoCatalogType> root = unmarshaller.unmarshal(source, GeoCatalogType.class);
            geoCatalog = root.getValue();
        } catch (Exception e) {

        }
        return geoCatalog;
    }

    public List<CountryType> getCountries() {
        return getGeoCatalog().getContinents().getContinent().stream()
                .flatMap(c -> c.getCountries().getCountry().stream())
                .collect(Collectors.toList());
    }

    public List<Serializable> getContents(List<CountryType> countries) {
        return countries.stream()
                .flatMap(c -> c.getCities().getContent().stream())
                .collect(Collectors.toList());
    }

    public List<CityType> getCities(List<Serializable> cities) {
        return cities.stream()
                .filter(c -> c instanceof JAXBElement)
                .map(c -> ((JAXBElement<CityType>) c).getValue())
                .collect(Collectors.toList());
    }

    public Optional<CountryType> findCountryByString(String query) {
        return getCountries().stream()
                .filter(c -> c.getName().equalsIgnoreCase(query))
                .findAny();
    }

    public CityType findCityByString(String query) {
        return getCities(getContents(getCountries())).stream()
                .filter(k -> k.getName().equalsIgnoreCase(query))
                .findAny()
                        .orElseGet(() -> {
                            return getCities(getContents(getCountries())).stream()
                                    .filter(g -> StringUtils.containsIgnoreCase(g.getName(), query))
                                    .findAny()
                                    .orElseGet(() -> {return new CityType(); });
                        });
    }

    public String findPlaceName(String query) {
        final CountryType country = findCountryByString(query).orElse(null);
        if(country != null) {
            return country.getName();
        } else if (!findCityByString(query).getName().isEmpty()) {
                return findCityByString(query).getName();
        } else {
            return "PLACE NOT FOUND!";
        }
    }

    public String findPlaceIata(String query) {
        final CountryType country = findCountryByString(query).orElse(null);
        if (country != null) {
            return country.getId();
        } else if (!findCityByString(query).getIataCode().isEmpty()) {
            return findCityByString(query).getIataCode();
        } else {
            return "ERR";
        }
    }

}