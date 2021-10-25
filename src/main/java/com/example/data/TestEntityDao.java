package com.example.data;

import com.example.struct.test_entity.TestEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDao<TestEntity> {

    public TestEntityDao() {
        super();
        setClazz(TestEntity.class);
    }
}
