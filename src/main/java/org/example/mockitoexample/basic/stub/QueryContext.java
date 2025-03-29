package org.example.mockitoexample.basic.stub;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/*
  紀錄查詢相關資訊，跳頁資訊，查詢條件

 */
@Data
public class QueryContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    /**
     * 每頁筆數
     */
    private int size;

    /**
     * 頁碼
     */
    private int page;

    /**
     * 排序設定
     */
    private Map<String, String> sorts;

    /**
     * 查詢條件，key的規則為
     * 運算符號-Entity屬性名稱，相關運算符號請參閱com.ginmao.jpa.criteria.predicate，value的部份則會設定前比對對應的屬性型態再進行轉換並與rawConditions的條件合併
     */
    private Map<String, String> conditions;

    /**
     * 查詢條件，key的規則同conditions，但是value的部份就直接帶正確的型態，不進行額外的型態轉換
     */
    private Map<String, Object> rawConditions;

    /**
     * 需要額外加工的查詢條件
     */
    private Map<String, String> extConditions;

}
