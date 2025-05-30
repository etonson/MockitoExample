package org.example.mockitoexample.mock.powermock;


import org.example.mockitoexample.powermock.fstatics.FinalMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FinalMethodTest {

    @Test
    void testFinalMethodWithMock() {
        // Arrange
        FinalMethod mock = mock(FinalMethod.class);

        // Mock final method
        when(mock.getValue()).thenReturn("mocked value");

        // Act
        String result = mock.getValue();

        // Assert
        Assertions.assertEquals("mocked value", result);
    }
}