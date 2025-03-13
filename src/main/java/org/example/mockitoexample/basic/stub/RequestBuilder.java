package org.example.mockitoexample.basic.stub;

import jakarta.servlet.http.HttpServletRequest;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-03 下午 11:40
*/
public class RequestBuilder {
    public static QueryCountryRequest builder(HttpServletRequest request) {
        QueryCountryRequest queryCountryRequest = new QueryCountryRequest();
        queryCountryRequest.setPage(getInt(request.getParameter("page")));
        queryCountryRequest.setRowerPerPage(getInt(request.getParameter("rp")));
        queryCountryRequest.setSortOrder(SortOrder.convert(request.getParameter("sortorder")));
        queryCountryRequest.setSortColumn(SortColumn.convert(request.getParameter("sortname")));
        queryCountryRequest.setSerachQuery(request.getParameter("qtype"));
        return queryCountryRequest;

    }
    private static Integer getInt(String val) {
        Integer result = null;
        try {
            result = Integer.parseInt(val);
        }catch(NumberFormatException e) {
            e.addSuppressed(new IllegalStateException(val));
        }
        return result;
    }
}
