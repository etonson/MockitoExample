package org.example.mockitoexample.basic.stub;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-03-04 上午 12:15
*/
@Getter
@Setter
public class JsonDataWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int page;
    private int total;
    private List<T> rows;

    public JsonDataWrapper(int page, int total, List<T> rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }
}
