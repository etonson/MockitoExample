package org.example.mockitoexample.powermock.fstatics;

public class PrivateMethodDemo {
    protected  String setValue(){
        return "value";
    }

    public String exposeSecretValue(){
        return setValue();
    }
}
