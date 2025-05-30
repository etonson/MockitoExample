package org.example.mockitoexample.powermock.fstatics;

import java.util.HashMap;
import java.util.Map;

public class StaticInitDemo {
    public static int value = 1;
    public static final Map<String, String> map = new HashMap<>();

    static {
        map.put("a", "honey");
        map.put("b", "jelly");
        map.put("c", "beans");
    }
}
