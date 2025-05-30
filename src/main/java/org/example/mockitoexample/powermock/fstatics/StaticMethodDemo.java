package org.example.mockitoexample.powermock.fstatics;

import java.util.Random;


public class StaticMethodDemo {
    public static int staticGenerateId(){
        return new Random().nextInt();
    }
    public int generateId(){
        return new Random().nextInt();
    }
}
