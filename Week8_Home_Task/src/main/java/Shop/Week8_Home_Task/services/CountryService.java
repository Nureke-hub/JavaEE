package Shop.Week8_Home_Task.services;

import Shop.Week8_Home_Task.entities.Country;

import java.util.List;

public interface CountryService {
    Country addCountry(Country country);
    Country saveCountry(Country country);
    List<Country> getAllCountries();
    Country getCountry(Long id);
    void deleteCountry(Country country);
}
