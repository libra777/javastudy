package edu.sun.app.dao;

import edu.sun.app.model.MemberInfo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-12
 */
@Component
public class MemberInfoDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(MemberInfo memberInfo) {
        entityManager.persist(memberInfo);
    }

    public List<MemberInfo> list() {
        return entityManager.createQuery("select t from MemberInfo t")
                .getResultList();
    }
}
