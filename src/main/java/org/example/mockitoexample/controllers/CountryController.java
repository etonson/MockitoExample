package org.example.mockitoexample.controllers;

import org.example.mockitoexample.basic.stub.QueryContext;
import org.example.mockitoexample.entitiea.Country;
import org.example.mockitoexample.repostory.repositories.ICountryDao;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
    @author : Eton.lin
    @description 測試用之controller
    @date 2025-03-27 下午 11:48
*/
@RestController
@RequestMapping(path = "test")
public class CountryController {
    @Autowired
    private ICountryDao<Country> countryImpl;

    @GetMapping(value = "/country/{iso}")
    public String getIso(@PathVariable String iso) {
        QueryContext queryContext = new QueryContext();
        Map<String, String> sort = Map.of("iso", iso);
        queryContext.setSorts(sort);
        Page<Country> countryList = countryImpl.retrieve(queryContext);
        JSONArray jsonArray = new JSONArray();
        countryList.stream().map(Country::getIso).forEach(jsonArray::put);
        return jsonArray.toString();
    }
}
