package org.example.mockitoexample.basic.stub;

import lombok.Getter;
import lombok.Setter;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-02-28 下午 10:21
*/
@Setter
@Getter
public class QueryCountryRequest {
    private int page;
    private int rowerPerPage;
    private SortColumn sortColumn;
    private SortOrder sortOrder;
    private String serachQuery;

}
