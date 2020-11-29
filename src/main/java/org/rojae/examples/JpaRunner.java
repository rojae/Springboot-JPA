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
        Study study = Study.builder().name("Spring Data JPA").build();
        HashSet<Study> studies = new HashSet<>();
        studies.add(study);

        Account account1 = Account.builder().username("jpa").password("123").studies(studies).build();
        Account account2 = Account.builder().username("hibernate").password("123").build();



        this.runWithJpa(account1);
        this.runWithHibernate(account2, study);
    }

    public void runWithJpa(Account account) {
        System.out.println("Run with JPA");
        System.out.println(account);
        entityManager.persist(account);

    }

    public void runWithHibernate(Account account, Study study) {
        System.out.println("Run with Hibernate");
        System.out.println(account);
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }

}
