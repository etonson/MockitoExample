package org.example.mockitoexample.repostory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/*
    @author : Eton.lin
    @description EntityManager基本設定
    @date 2025-02-28 下午 03:33
*/
@Repository
public class BasicEntityManager {

    @PersistenceContext
    protected EntityManager entityManager;
}
