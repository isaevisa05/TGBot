package io.github.isaevisa05.TGBot.controllers;

import io.github.isaevisa05.TGBot.dto.ValuteCursOnDate;
import io.github.isaevisa05.TGBot.service.CentralRussianBankService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;

    @GetMapping("/getCurrencies")
    @ApiOperation(value = "Получения курса всех валют на текущий день")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrency/{code}")
    @ApiOperation(value = "Получить курс определённой валюты на текущий день")
    public ValuteCursOnDate getCourseForCurrency(@PathVariable String code) throws DatatypeConfigurationException {
        return centralRussianBankService.getCourseForCurrency(code);
    }
}
