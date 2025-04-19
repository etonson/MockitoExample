package org.example.mockitoexample.mock.ch3;

import org.example.mockitoexample.ch3.DependencyService;
import org.example.mockitoexample.ch3.TestExceptionWithDependency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;


@ExtendWith(MockitoExtension.class)
public class TestExceptionWithDependencyTest {

    @Mock
    DependencyService dependencyService;

    @InjectMocks
    TestExceptionWithDependency testExceptionWithDependency;

        /*
            @Author :Eton.lin
            @Description : 練習捕捉exception之方法
            @Date : 2025/4/20 上午 12:07
            * */
    @Test
    void doSomething_shouldThrowRuntimeException_whenDependencyFails() {
        // Arrange
        doThrow(new RuntimeException("Mock exception")).when(dependencyService).doWork();

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            testExceptionWithDependency.doSomething();
        });
    }
}