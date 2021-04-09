package org.pk.springboot.rest.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.domian.State;

import org.pk.springboot.rest.exception.StateNotFoundException;
import org.pk.springboot.rest.repository.CountryRepository;
import org.pk.springboot.rest.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(StateService.class)
public class StateServiceTest {

    @MockBean
    private StateRepository stateRepository;

    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private StateService stateService;

    private List<State> states;
    private Country country;


    @Before
    public void setup() {
        country = new Country(1, "IND", "India", "INR");

        states = new ArrayList<>(2);
        states.add(new State(1, "MH", "Maharashtra", country));
        states.add(new State(2, "MP", "Madya Pradesh", country));
    }

    @Test
    public void getAllStates() throws Exception {
        given(stateRepository.findAllByCountry(country)).willReturn(states);
        given(countryRepository.getOne(1)).willReturn(country);
        Assertions.assertThat(stateService.findByCountryId(1).size()).isEqualTo(2);
    }

    @Test(expected = StateNotFoundException.class)
    public void getAllStatesError() throws Exception {
        given(stateRepository.findAllByCountry(country)).willReturn(states);
        given(countryRepository.getOne(1)).willReturn(country);
        Assertions.assertThat(stateService.findByCountryId(2).size()).isZero();
    }
}
