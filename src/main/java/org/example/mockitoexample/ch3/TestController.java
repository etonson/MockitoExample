package org.example.mockitoexample.ch3;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    @author : Eton.lin
    @description 測試用控制器
    @date 2025-04-16 上午 12:16
*/
@Component
public class TestController {
    @Autowired
    ThresholdService thresholdService;
    public JSONObject testController(int i) {
        JSONObject result = new JSONObject();
        try {
            result.put("i", thresholdService.getValueIfAboveThreshold(i));
        }catch (Exception e) {
            result.put("i",e.getMessage());
        }
        return result;
    }
}
