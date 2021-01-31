package org.pk.springboot.rest.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryService.class)
public class CountryServiceTest {


    @MockBean
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    private List<Country> countries;


    @Before
    public void setup() {
        countries = new ArrayList<>(3);
        countries.add(new Country(1, "IND", "India", "INR"));
        countries.add(new Country(2, "USA", "United States Of America", "DOLLAR"));
        countries.add(new Country(3, "UK", "United Kindom", "EURO"));
    }

    @Test
    public void getAllServices() throws Exception {
        given(countryRepository.findAll()).willReturn(countries);
        Assertions.assertThat(countryService.findAll().size()).isEqualTo(3);
    }
}
