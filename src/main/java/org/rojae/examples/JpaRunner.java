package org.rojae.examples;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    // JPA 핵심
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("hinernate");
        account.setPassword("123");

        Study study = new Study();
        study.setName("Spring Data JPA");

        // 객체 관련 맵핑 N:M
        study.setOwner(account);
        account.addStudy(study);

        this.runWithHibernate(account, study);
    }

    public void runWithHibernate(Account account, Study study) {
        System.out.println("Run with Hibernate");
        System.out.println(account);
        System.out.println(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }

}
