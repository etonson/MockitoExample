package org.example.mockitoexample.basic.stub;

import org.example.mockitoexample.entitiea.Country;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-02-28 下午 10:18
*/
@Component
public interface CountryDao
{
    List<Country> retrieve(QueryCountryRequest commond);
}
