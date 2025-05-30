package org.example.mockitoexample.mock.powermock;


import org.example.mockitoexample.powermock.fstatics.StaticInitDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StaticInitDemoTest {

    @Test
    void test_static_variables() {
        // 讀取靜態變數
        Assertions.assertEquals(1, StaticInitDemo.value);

        // 修改 static 非 final 欄位
        StaticInitDemo.value = 42;
        Assertions.assertEquals(42, StaticInitDemo.value);

        // 驗證 static final Map 的內容
        Assertions.assertEquals("honey", StaticInitDemo.map.get("a"));

        // 修改 map 的內容（注意：map 是 final，但內容可變）
        StaticInitDemo.map.put("a", "updated");
        Assertions.assertEquals("updated", StaticInitDemo.map.get("a"));
    }
}