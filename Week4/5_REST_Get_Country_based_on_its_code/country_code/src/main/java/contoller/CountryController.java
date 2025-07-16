package com.cognizant.country_code.contoller;

import com.cognizant.country_code.model.Country;
import com.cognizant.country_code.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code){
        return countryService.getCountry(code);
    }
}
