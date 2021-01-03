package org.rojae.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void run(){
        // When
        Post post = new Post();
        post.setTitle("Test");
        postRepository.save(post);

        // Then
        List<Post> list = postRepository.findMyPost();
        list.forEach(System.out::println);
        assertThat(list.size()).isEqualTo(1);

        // When
        postRepository.delete(post);
        postRepository.flush();

        // Then
        list = postRepository.findMyPost();
        assertThat(list.size()).isEqualTo(0);
    }



}
