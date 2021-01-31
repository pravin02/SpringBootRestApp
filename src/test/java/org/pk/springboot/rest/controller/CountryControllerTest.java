package org.pk.springboot.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.pk.springboot.rest.domian.Country;

import org.pk.springboot.rest.other.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.hamcrest.core.Is;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pravin P Patil
 * <p>
 * document reffered - https://www.blazemeter.com/blog/spring-boot-rest-api-unit-testing-with-junit
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CountryController countryController;
    private List<Country> countries;
    Response response;

    @Before
    public void setup() {
        countries = new ArrayList<>(3);
        countries.add(new Country(1, "IND", "India", "INR"));
        countries.add(new Country(2, "USA", "United States Of America", "DOLLAR"));
        countries.add(new Country(3, "UK", "United Kindom", "EURO"));

        response = new Response(true, countries, "");
    }

    @Test
    public void getCountriesListSuccessTest() throws Exception {
        ResponseEntity<Response> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        given(countryController.findAll()).willReturn(responseResponseEntity);

        mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data", hasSize(3)))
                .andExpect(jsonPath("data[1].countryCode", Is.is(countries.get(1).getCountryCode())))
        ;
    }

    @Test
    public void getCountriesListFailureTest() throws Exception {
        response = new Response(false, null, "No Countries not found");
        ResponseEntity<Response> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        given(countryController.findAll()).willReturn(responseResponseEntity);

        mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(response.getMessage())));
    }
}
