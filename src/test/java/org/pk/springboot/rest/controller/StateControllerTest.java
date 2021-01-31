package org.pk.springboot.rest.controller;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.domian.State;
import org.pk.springboot.rest.other.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(StateController.class)
public class StateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StateController controller;

    private List<State> states;
    private Country country = new Country(1, "IND", "India", "INR");
    Response response;

    @Before
    public void setup() {
        states = new ArrayList<>(3);
        states.add(new State(1, "MH", "Maharashtra", country));
        states.add(new State(2, "MP", "Madya Pradesh", country));

        response = new Response(true, states, "");
    }

    @Test
    public void getAllStatesByCountryIdSuccessTest() throws Exception {
        ResponseEntity<Response> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        given(controller.findByCountryId(country.getCountryId())).willReturn(responseResponseEntity);

        mockMvc.perform(get("/api/states/" + country.getCountryId()))
                .andExpect(header().string("content-type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data", hasSize(2)))
                .andExpect(jsonPath("data[0].stateName", Is.is(states.get(0).getStateName())));
    }

    @Test
    public void getAllStatesByCountryIdFailuresTest() throws Exception {
        response = new Response(false, null, "States not found by " + country.getCountryId());
        ResponseEntity<Response> responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        given(controller.findByCountryId(country.getCountryId())).willReturn(responseResponseEntity);

        mockMvc.perform(get("/api/states/" + country.getCountryId()))
                .andExpect(header().string("content-type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status", Is.is(false)))
                .andExpect(jsonPath("message", Is.is(response.getMessage())));
    }

}
