package org.example.mockitoexample.repostory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Setter;
import org.springframework.stereotype.Repository;

/*
    @author : Eton.lin
    @description EntityManager基本設定
    @date 2025-02-28 下午 03:33
*/
@Repository
@Setter
public class BasicEntityManager {

    @PersistenceContext
    public EntityManager entityManager;
}
