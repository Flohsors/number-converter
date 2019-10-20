package de.flohsors.number_converter.rest.controller;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberConversionControllerIT {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void requestConversion_returnsCorrectlyConvertedNumber_whenParametersAreProvided() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter").contentType(
                                                   "application/json").content("101100")).andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_OK);
    }

    @Test
    public void requestConversion_resultsInException_onIncompatibleInput() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter").contentType(
                    "application/json").content("TEST")).andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_BAD_REQUEST);
    }
}
