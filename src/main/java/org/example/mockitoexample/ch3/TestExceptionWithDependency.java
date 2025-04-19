package org.example.mockitoexample.ch3;

/*
    @author: Eton.lin
    @date 2025-04-15 下午 11:58
*/
public class TestExceptionWithDependency {

    private final DependencyService dependencyService;

    public TestExceptionWithDependency(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }

    public void doSomething() {
        dependencyService.doWork(); // 這裡可能會拋出 RuntimeException
    }
}