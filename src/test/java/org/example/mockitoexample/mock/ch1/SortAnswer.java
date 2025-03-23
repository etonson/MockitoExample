package org.example.mockitoexample.mock.ch1;

import org.example.mockitoexample.basic.stub.QueryCountryRequest;
import org.example.mockitoexample.basic.stub.SortColumn;
import org.example.mockitoexample.basic.stub.SortOrder;
import org.example.mockitoexample.entitiea.Country;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-22 下午 11:24
*/
public class SortAnswer implements Answer<List<Country>> {
    @Override
    public List<Country> answer(InvocationOnMock invocation) throws Throwable {
        QueryCountryRequest request = (QueryCountryRequest) invocation.getArguments()[0];
        int order = request.getSortOrder().equals(SortOrder.ASC) ? 1 : -1;
        SortColumn col = request.getSortColumn();
        List<Country> countries = new ArrayList<>();
        Collections.sort(countries,(c1,c2)->{
            if(SortColumn.ISO.equals(col))
                return order*c1.getIso().compareTo(c2.getIso());
            return order*c1.getName().compareToIgnoreCase(c2.getName());
        });
        return countries;
    }
}
