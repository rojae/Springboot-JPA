package org.rojae.examples;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    // JPA 핵심
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // JPQL not typeSafe
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        // CriteriaBuilder type safe
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query2 = builder.createQuery(Post.class);
        Root<Post> root = query2.from(Post.class);
        query2.select(root);

        List<Post> posts2 = entityManager.createQuery(query2).getResultList();
        posts2.forEach(System.out::println);

        // Native query
        List<Post> posts3 = entityManager.createNativeQuery("SELECT * FROM Post", Post.class).getResultList();
        posts3.forEach(System.out::println);
    }
}
