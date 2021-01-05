package org.rojae.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
@EnableJpaRepositories(repositoryBaseClass = CommonRepositoryImpl.class)       // 공통 레파지토리를 baseClass로 알려줌
public class CustomRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void run(){
        // When
        Post post = new Post();
        post.setTitle("Test");

        // Transient
        assertThat(postRepository.contains(post)).isFalse();

        // save
        postRepository.save(post.publish());

        // Persist
        assertThat(postRepository.contains(post)).isTrue();

        postRepository.findAll();

        // Then
        //List<Post> list = postRepository.findMyPost();
        //list.forEach(System.out::println);
        //assertThat(list.size()).isEqualTo(1);

        // When
        //postRepository.delete(post);
        //postRepository.flush();

        // Then
        //list = postRepository.findMyPost();
        //assertThat(list.size()).isEqualTo(0);
    }



}
