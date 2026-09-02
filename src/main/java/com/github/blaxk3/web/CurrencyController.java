package com.github.blaxk3.web;

import com.github.blaxk3.api.CurrencyRateAPI;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyRateAPI currencyRateAPI = new CurrencyRateAPI();

    @GetMapping("/currencies")
    public String[] getCurrencies() throws Exception {
        return currencyRateAPI.getCurrencyCode();
    }

    @GetMapping("/convert")
    public String convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount) throws Exception {

        return currencyRateAPI.convert(from, to, amount);
    }
}
