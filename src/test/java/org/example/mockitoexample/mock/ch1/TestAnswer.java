package org.example.mockitoexample.mock.ch1;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mockitoexample.basic.stub.CountryDao;
import org.example.mockitoexample.basic.stub.JsonDataWrapper;
import org.example.mockitoexample.basic.stub.QueryCountryRequest;
import org.example.mockitoexample.basic.stub.SortColumn;
import org.example.mockitoexample.basic.stub.SortOrder;
import org.example.mockitoexample.controllers.AjaxController;
import org.example.mockitoexample.entitiea.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-23 上午 12:04
*/
@ExtendWith(MockitoExtension.class)
public class TestAnswer {
    @Mock
    HttpServletRequest request;
    @Mock
    CountryDao countryDao;

    AjaxController ajaxController;
    List<Country> countryList;


    @BeforeEach
    public void setUp() {
        ajaxController = new AjaxController(countryDao);
        countryList = new ArrayList<>();
        Country country = new Country();
        country.setIso("US");
        country.setIso("IN");
        countryList.add(country);
    }

    @Test
    public  void shouldGetResultWhenRequestISOColumnDescAndP1From2Page(){
        when(request.getParameter(anyString()))
                //request 第1次呼叫
                .thenReturn("1")
                //request 第2次呼叫
                .thenReturn("2")
                //request 第3次呼叫
                .thenReturn(SortOrder.DESC.name())
                //request 第4次呼叫
                .thenReturn(SortColumn.ISO.name());

        when(countryDao.retrieve(isA(QueryCountryRequest.class)))
                .thenAnswer(new SortAnswer());

        JsonDataWrapper<Country> response = ajaxController.retrieve(request);
        assertEquals(2, response.getRows().size());
        assertEquals("US", response.getRows().get(0).getIso());
        assertEquals("IN", response.getRows().get(1).getIso());
    }
}
