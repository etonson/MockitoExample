package org.example.mockitoexample.ch3;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
    @author: Eton.lin
    @date 2025-04-16 上午 12:15
*/
@Component
@Setter
@Getter
public class ThresholdServiceImpl implements ThresholdService {
    public Map<String,String> valueMap  = new HashMap<>();
    @Override
        /*
            @Author :Eton.lin
            @Description : 輸入一數字 小於等於10便拋出exception
            @Date : 2025/4/19 下午 11:50
            * */
    public String getValueIfAboveThreshold(int i) {
        if(i>10){
            return String.valueOf(i);
        }else {
            throw new RuntimeException("Mock exception");
        }
    }

    /*
    @Author :Eton.lin
    @Description : 輸入一數字 小於等於10便拋出exception
                   大於10時則變更map裡的值
    @Date : 2025/4/19 下午 11:50
    * */
    @Override
    public void updateMapIfAboveThreshold(int i) {
        if(i>10){
            valueMap .put(String.valueOf(i),String.valueOf(i));
        }else {
            throw new RuntimeException("Mock exception");
        }
    }
}
