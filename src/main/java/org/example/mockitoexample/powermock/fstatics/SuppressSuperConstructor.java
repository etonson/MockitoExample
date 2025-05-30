package org.example.mockitoexample.powermock.fstatics;

import lombok.Getter;

@Getter
public class SuppressSuperConstructor extends DoNoExtendMe {
    private int someInt=100;
    private boolean someBoolean ;
    public SuppressSuperConstructor() {
        someInt = someInt/0;
        someBoolean = true;
    }
    public SuppressSuperConstructor(int val) {
        someBoolean = true;
        someInt = someInt/val;
    }
}
