package org.example.mockitoexample.repostory.maintain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.example.mockitoexample.basic.stub.QueryContext;
import org.example.mockitoexample.entitiea.Country;
import org.example.mockitoexample.repostory.BasicEntityManager;
import org.example.mockitoexample.repostory.repositories.ICountryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
    @author : Eton.lin
    @description 測試用之service
    @date 2025-03-27 下午 11:23
*/
@Slf4j
@Service
public class MaintainCountryDao extends BasicEntityManager implements ICountryDao<Country> {
    @Override
    public Page<Country> retrieve(QueryContext context) {
        Map<String,String> params = context.getSorts();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> sqlQueue = cb.createQuery(Country.class);
        Root<Country> root = sqlQueue.from(Country.class);
        if("asc".equals(params.get("iso"))) {
            sqlQueue.orderBy(cb.asc(root.get("iso")));
        }else {
            sqlQueue.orderBy(cb.desc(root.get("iso")));
        }
        List<Country> t= entityManager.createQuery(sqlQueue).getResultList();
        return new PageImpl<>(entityManager.createQuery(sqlQueue).getResultList());
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
