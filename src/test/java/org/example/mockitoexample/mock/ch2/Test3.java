package org.example.mockitoexample.mock.ch2;

import jakarta.persistence.EntityManager;
import org.example.mockitoexample.entitiea.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/*
    @author : Eton.lin
    @description TODO
    @date 2025-04-04 下午 04:39
*/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test3 {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldRetrieveRealDataFromDatabase() throws Exception {
        // 測試真正的 SQL 查詢
        Main m =entityManager.find(Main.class, 1);
    }
}
