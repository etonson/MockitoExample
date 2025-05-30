package org.example.mockitoexample.mock.powermock;


import org.example.mockitoexample.powermock.fstatics.StaticMethodDemo;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class StaticMethodTest {
    @Test
    void show_stub_static_method() {
        // Mock 靜態方法
        try (MockedStatic<StaticMethodDemo> mockedStatic = mockStatic(StaticMethodDemo.class)) {
            mockedStatic.when(StaticMethodDemo::staticGenerateId).thenReturn(1);
            assertEquals(1, StaticMethodDemo.staticGenerateId());
        }

        // Mock 一般方法
        StaticMethodDemo demo = mock(StaticMethodDemo.class);
        when(demo.generateId()).thenReturn(2);
        assertEquals(2, demo.generateId());
    }
}