package edu.sun.app.dao;

import edu.sun.app.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-11
 */
@Component
@Transactional
public class MemberDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @return
     */
    public List<Member> getAllWorkingMember() {
        return entityManager.createQuery("select m from Member m  order by memberId").getResultList();

    }

    /**
     * @return
     */
    public List<Member> getAllMember() {
        return entityManager.createQuery("select m from Member m order by memberId").getResultList();
    }


    /**
     * @param member
     * @return
     */
    public Member saveMember(Member member) {

        entityManager.merge(member);
        //entityManager.persist(member);
        return member;
    }
}
