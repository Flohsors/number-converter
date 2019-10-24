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

import com.fasterxml.jackson.databind.ObjectMapper;

import de.flohsors.number_converter.backend.entity.NumberType;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberConversionControllerIT {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void requestConversion_returnsCorrectlyConvertedNumber_whenParametersAreProvided() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter/convertNumber").contentType(
                                                   "application/json").content(
                                                   objectMapper.writeValueAsString(anyConvertibleNumber())))
                                           .andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_OK);
    }

    @Test
    public void requestConversion_returns400_whenTheInputNumberIsInconvertible() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter/convertNumber").contentType(
                                                   "application/json").content(
                                                   objectMapper.writeValueAsString(anyUnknownMess()))).andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_BAD_REQUEST);
    }

    @Test
    public void requestConversion_returns400_onWrongInput() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter/convertNumber").contentType(
                                                   "application/json").content("TEST")).andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_BAD_REQUEST);
    }

    @Test
    public void requestConversion_resultsInException_onEmptyInput() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/converter/convertNumber").contentType(
                                                   "application/json").content(
                                                   objectMapper.writeValueAsString(emptyConvertibleNummber())))
                                           .andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(SC_BAD_REQUEST);
    }

    private ConvertibleNumber anyConvertibleNumber() {
        final ConvertibleNumber convertibleNumber = new ConvertibleNumber("101100");
        convertibleNumber.setNumberType(NumberType.BINARY);
        return convertibleNumber;
    }

    private ConvertibleNumber anyUnknownMess() {
        return new ConvertibleNumber("E3G7A");
    }

    private ConvertibleNumber emptyConvertibleNummber() {
        return new ConvertibleNumber("");
    }
}
