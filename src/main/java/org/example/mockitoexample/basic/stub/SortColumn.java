package org.example.mockitoexample.basic.stub;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-02-28 下午 10:37
*/public enum SortColumn
{
    ISO,NAME,PRINTABLE_NAME,ISO3,COUNTRY_CODE;

    public static SortColumn convert (String name){
        for(SortColumn sortColumn : SortColumn.values()){
            if(sortColumn.name().equalsIgnoreCase(name)){
                return sortColumn;
            }
        }
        return null;
    }
}
