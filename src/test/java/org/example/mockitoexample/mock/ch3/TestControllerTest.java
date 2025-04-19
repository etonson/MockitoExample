package org.example.mockitoexample.mock.ch3;

import org.example.mockitoexample.ch3.TestController;
import org.example.mockitoexample.ch3.ThresholdService;
import org.example.mockitoexample.ch3.ThresholdServiceImpl;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
    @author: Eton.lin
    @date 2025-04-16 上午 12:32
*/
@ExtendWith(MockitoExtension.class)
public class TestControllerTest {

    @Mock
    ThresholdService thresholdService;

    @InjectMocks
    TestController testController;

    @Test
    void testController_shouldReturnValue_whenNoException()  {
        // Arrange
        int input = 20;
        when(thresholdService.getValueIfAboveThreshold(input)).thenReturn("20");

        // Act
        JSONObject result = testController.testController(input);

        // Assert
        assertEquals("20", result.optString("i"));
    }

    @Test
    void testController_shouldReturnErrorMessage_whenExceptionThrown() {
        // Arrange
        int input = 5;
        when(thresholdService.getValueIfAboveThreshold(input)).thenThrow(new RuntimeException("Mock exception"));

        // Act
        JSONObject result = testController.testController(input);

        // Assert
        assertEquals("Mock exception", result.optString("i"));
    }

    /*
     * 直接呼叫實例，觀察 map 的變化
     * */
    @Test
    void doSomething_shouldThrowRuntimeException_whenDependencyFails() {
        // Arrange
        ThresholdServiceImpl testService = new ThresholdServiceImpl();
        int input = 15;

        // Act
        testService.updateMapIfAboveThreshold(input);

        // Assert
        assertEquals("15", testService.valueMap.get("15"));
    }

    /*
    * mock ThresholdService 並用 doNothing()，無法觀察原本的 map，因為 mock 會取代原邏輯，map 不會被真正操作。
    * 測試該方法僅被執行一次
    * */
    @Test
    void doSomething_shouldPutToMap_whenInputGreaterThan10() {
        // Arrange
        int input = 5;
        doNothing().when(thresholdService).updateMapIfAboveThreshold(input);

        // Act
        thresholdService.updateMapIfAboveThreshold(input);

        // Assert
        verify(thresholdService).updateMapIfAboveThreshold(input);
    }
}