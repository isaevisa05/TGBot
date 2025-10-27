package io.github.isaevisa05.TGBot.controllers;

import io.github.isaevisa05.TGBot.service.CentralRussianBankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CentralRussianBankService centralRussianBankService;

    @Test
    public void testWhenAskAboutAllCurrencies() throws Exception {
        mockMvc.perform(get("/getCurrencies"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testWhenAskAboutOneCurrency() throws Exception {
        mockMvc.perform(get("/getCurrency/USD"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}