package org.example.mockitoexample.mock.powermock;

import org.example.mockitoexample.powermock.fstatics.SuppressSuperConstructor;
import org.junit.jupiter.api.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    @Author: Eton.lin
    @Description: 你想要測試 如何抑制副類別在建構時呼叫父類別建構子（super()）的行為。這類需求通常出現在：
               1. 父類別建構子有副作用（像是啟動連線、拋出異常、寫檔）
               2. 測試中不想真正執行這些副作用
    @Date: 2025/5/14 下午 11:33
    * */
public class SuppressSuperConstructorTest {
    @Test
    public void testBypassSuperConstructor() throws Exception {
        Objenesis objenesis = new ObjenesisStd();

        // 建立 SuppressSuperConstructor 實例，但不執行 constructor
        SuppressSuperConstructor obj = objenesis.newInstance(SuppressSuperConstructor.class);

        System.out.println("Instance created: " + obj);
    }


    @Test
    void testCreateInstanceWithoutConstructor() throws Exception {
        Constructor<SuppressSuperConstructor> constructor = SuppressSuperConstructor.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        SuppressSuperConstructor obj = (SuppressSuperConstructor) sun.reflect.ReflectionFactory
                .getReflectionFactory()
                .newConstructorForSerialization(SuppressSuperConstructor.class, Object.class.getDeclaredConstructor())
                .newInstance();

        assertNotNull(obj);
        assertEquals(0, obj.getSomeInt());
        assertFalse(obj.isSomeBoolean());
    }
}
