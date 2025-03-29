package org.example.mockitoexample.mock.ch2;

import jakarta.persistence.EntityManager;
import org.example.mockitoexample.basic.stub.QueryContext;
import org.example.mockitoexample.entitiea.Country;
import org.example.mockitoexample.repostory.maintain.MaintainCountryDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    @author : Eton.lin
    @description 透過SpringBootTest載入整個 Spring Boot 應用，用於更完整的測試
    @date 2025-03-29 上午 02:17
*/
@ExtendWith(SpringExtension.class)
@SpringBootTest
// 確保測試結束後數據回滾
@Transactional
public class MaintainCountryDaoTest {

    @Autowired
    private MaintainCountryDao maintainCountryDao;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldRetrieveRealDataFromDatabase() {
        // 先插入測試資料
        Country country1 = new Country();
        country1.setIso("US");
        country1.setName("United States");
        entityManager.persist(country1);

        Country country2 = new Country();
        country2.setIso("JP");
        country2.setName("Japan");
        entityManager.persist(country2);

        entityManager.flush(); // 強制寫入資料庫

        QueryContext queryContext = new QueryContext();
        queryContext.setSorts(Map.of("iso", "asc"));

        // 測試真正的 SQL 查詢
        var result = maintainCountryDao.retrieve(queryContext);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
    }
}