package org.example.mockitoexample.repostory.repositories;

import org.example.mockitoexample.basic.stub.QueryContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-26 下午 11:40
*/
@Component
public interface ICountryDao<T> {
    Page<T> retrieve(QueryContext context);
}
