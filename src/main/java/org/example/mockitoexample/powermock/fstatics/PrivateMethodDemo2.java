package org.example.mockitoexample.powermock.fstatics;

/*
    @Author: Eton.Lin
    @Description: TODO
    @Date: 2025/5/20 上午 12:41
*/

public class PrivateMethodDemo2 {
    private final ValueProvider provider;

    public PrivateMethodDemo2(ValueProvider provider) {
        this.provider = provider;
    }

    public String exposeSecretValue() {
        return provider.getValue();
    }
}