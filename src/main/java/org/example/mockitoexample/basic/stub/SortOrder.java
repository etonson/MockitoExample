package org.example.mockitoexample.basic.stub;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-02-28 下午 10:43
*/
public enum SortOrder {
    ASC ,DESC;

    public static SortOrder convert (String name){
        for(SortOrder sortOrder : SortOrder.values()){
            if(sortOrder.name().equalsIgnoreCase(name)){
                return sortOrder;
            }
        }
        return null;
    }
}
