package Shop.Week8_Home_Task.services.impl;

import Shop.Week8_Home_Task.entities.Country;
import Shop.Week8_Home_Task.repositories.CountryRepository;
import Shop.Week8_Home_Task.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }
}
