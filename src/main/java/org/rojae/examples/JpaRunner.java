package org.rojae.examples;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    // JPA 핵심
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // runWithPersistent
        Account account = new Account();
        account.setUsername("hinernate");
        account.setPassword("123");

        Study study = new Study();
        study.setName("Spring Data JPA");

        // 객체 관련 맵핑 N:M
        study.setOwner(account);
        account.addStudy(study);

        this.runWithPersistent(account, study);

        // runWithPost()
        runWithPost();
    }

    // Post의 CasCade로 인해서 post만 save해도 comments가 등록됌
    // 삭제도 연쇄 삭제
    public void runWithPost(){
        Post post = new Post();
        post.setTitle("Spring DATRA JPA 언제 보나...");

        Comment comment1 = new Comment();
        comment1.setComment("빨리 보고 싶어요");

        Comment comment2 = new Comment();
        comment2.setComment("그러니까 말입니다");

        post.addComment(comment1);
        post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);
        //session.delete(post);
    }

    // Persistent 상태
    // insert는 트랙젠션이 종료된 이후에 발생된다.
    // println() 이후에 insert 커밋
    // 알아서 update 수행
    // dirty checking : 객체의 변경 상태를 모니터링
    // Write Behind : 객체의 추적 상태를 데이터베이스에 최소의 변경으로 적용
    public void runWithPersistent(Account account, Study study) {
        System.out.println("Run with Hibernate");
        System.out.println(account);
        System.out.println(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account rojae = session.load(Account.class, account.getId());
        account.setUsername("rojae");
        account.setUsername("rojae");
        account.setUsername("rojae");
        System.out.println("====================");
        System.out.println(rojae.getUsername());
    }

}
