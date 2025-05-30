package org.example.mockitoexample.mock.powermock;


import org.example.mockitoexample.powermock.fstatics.PrivateMethodDemo;
import org.example.mockitoexample.powermock.fstatics.PrivateMethodDemo2;
import org.example.mockitoexample.powermock.fstatics.ValueProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
    @Author: Eton.lin
    @Description: 測試或動態替換 setValue() 行為，改為 protected 或用 strategy pattern 等方式設計可測試/覆寫的結構。
    @Date: 2025/5/14 下午 11:33
    * */
public class PrivateMethodTest {
    @Test
    void test_mock_private_method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrivateMethodDemo demo = new PrivateMethodDemo() {
            @Override
            protected String setValue() {
                return "123"; // 模擬 private 方法回傳值
            }
        };

        String result = demo.exposeSecretValue();
        assertEquals("123", result);
    }
    @Test
    void testExposeSecretValue_WithMockProvider() {
        ValueProvider mockProvider = mock(ValueProvider.class);
        when(mockProvider.getValue()).thenReturn("123");

        PrivateMethodDemo2 demo = new PrivateMethodDemo2(mockProvider);
        String result = demo.exposeSecretValue();

        Assertions.assertEquals("123", result);
    }
}
