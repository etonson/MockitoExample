package org.example.mockitoexample.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mockitoexample.basic.stub.CountryDao;
import org.example.mockitoexample.basic.stub.JsonDataWrapper;
import org.example.mockitoexample.basic.stub.QueryCountryRequest;
import org.example.mockitoexample.basic.stub.RequestBuilder;
import org.example.mockitoexample.entitiea.Country;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-02-28 下午 10:17
*/
@Controller
@Scope("session")
public class AjaxController {
    private final CountryDao countryDao;

    public AjaxController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @ResponseBody
    @PostMapping(value = "retrieveCountries")
    public JsonDataWrapper<Country> retrieve(HttpServletRequest httpRequest) {
        QueryCountryRequest daoRequest = RequestBuilder.builder(httpRequest);
        List<Country> countryList = countryDao.retrieve(daoRequest);
        int size = countryList.size();
        int page = daoRequest.getPage();
        int rowPerPage = daoRequest.getRowerPerPage();
        int startIndex = (page - 1) * rowPerPage;
        int endIndex = Math.min((startIndex + page), size);
        if(startIndex < endIndex) {
            countryList = countryList.subList(startIndex, endIndex);
        }
        return new JsonDataWrapper<>(page,size,countryList);
    }
}
