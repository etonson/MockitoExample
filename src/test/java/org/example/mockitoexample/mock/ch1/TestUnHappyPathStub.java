package org.example.mockitoexample.mock.ch1;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mockitoexample.basic.stub.CountryDao;
import org.example.mockitoexample.basic.stub.QueryCountryRequest;
import org.example.mockitoexample.basic.stub.SortColumn;
import org.example.mockitoexample.basic.stub.SortOrder;
import org.example.mockitoexample.controllers.AjaxController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-14 下午 10:54
*/
@ExtendWith(MockitoExtension.class)
public class TestUnHappyPathStub {

    @Mock
    HttpServletRequest request;

    @Mock
    CountryDao countryDao;

    AjaxController ajaxController;

    @BeforeEach
    public void setUp() {
        ajaxController = new AjaxController(countryDao);
    }

    @Test
    public void shouldGetReponseWhenCountryDaoRetrieveFailed() {
        when(request.getParameter(anyString())).thenReturn(
                "1",
                "2",
                SortOrder.DESC.name(),
                SortColumn.ISO.name());

        when(countryDao.retrieve(isA(QueryCountryRequest.class)))
                .thenThrow(new RuntimeException("Data Exception"));

        assertThrows(RuntimeException.class,()-> ajaxController.retrieve(request));
    }


}
