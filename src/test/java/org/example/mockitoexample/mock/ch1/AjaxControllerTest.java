package org.example.mockitoexample.mock.ch1;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mockitoexample.basic.stub.CountryDao;
import org.example.mockitoexample.basic.stub.QueryCountryRequest;
import org.example.mockitoexample.entitiea.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-04 下午 11:27
*/
@ExtendWith(MockitoExtension.class)
public class AjaxControllerTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private CountryDao  countryDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void souuld_get_empty_country_list_when_stub() {
        when(countryDao.retrieve(isA(QueryCountryRequest.class))).thenReturn(Collections.emptyList());

        List<Country> countryList = countryDao.retrieve(new QueryCountryRequest());
        System.out.println(countryList.size());
        assertEquals(0,countryList.size());
    }
}
