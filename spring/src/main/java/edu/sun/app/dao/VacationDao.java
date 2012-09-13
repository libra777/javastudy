package edu.sun.app.dao;

import edu.sun.app.entity.Vacation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
@Component
@Transactional
public class VacationDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<Vacation> listVacationsByMemberId(String memberId, String logYear) {

        Query query = entityManager.
                createQuery("select  v from Vacation v where v.member.memberId=:memberId and v.logYear=:logYear")
                .setParameter("memberId", memberId)
                .setParameter("logYear", logYear);

        return query.getResultList();
    }

    public void saveVacation(Vacation vacation) {
        this.entityManager.persist(vacation);
    }

}
