package org.example.mockitoexample.mock.ch2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.mockitoexample.basic.stub.QueryContext;
import org.example.mockitoexample.entitiea.Country;
import org.example.mockitoexample.repostory.maintain.MaintainCountryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/*
    @author : Eton.lin
    @description 利用Mockito進行單元測試。
    用以測試物件行為，傾向主動設定預期結果，測試未達預期或呼叫方法參數不匹配或其他預期條件未達成，則失敗。
    @date 2025-03-28 上午 12:13
*/
@ExtendWith(MockitoExtension.class)
public class TestAnswer {

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private CriteriaQuery<Country> criteriaQuery;

    @Mock
    private Root<Country> root;

    @Mock
    private TypedQuery<Country> typedQuery;

    @InjectMocks
    private MaintainCountryDao maintainCountryDao;

    @Mock
    private QueryContext queryContext;

    @BeforeEach
    public void setUp() {
        maintainCountryDao.setEntityManager(entityManager);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Country.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Country.class)).thenReturn(root);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(List.of(new Country(), new Country()));
    }

    @Test
    public void shouldGetResultWhenRequestISOColumnDescAndP1From2Page() {
        when(queryContext.getSorts()).thenReturn(Map.of("iso", "asc"));
//          忽略未使用的 stubbing
//         lenient().when(queryContext.getSize()).thenReturn(2);
//         lenient().when(queryContext.getPage()).thenReturn(1);

        var result = maintainCountryDao.retrieve(queryContext);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
    }
}