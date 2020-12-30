package org.rojae.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void run(){
//        // Given
//        Comment comment = new Comment();
//        comment.setComment("Test");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commentRepository.count();
//        assertThat(count).isEqualTo(1);


        // When and Then
        commentRepository.save(null);

        // When
        Optional<Comment> comment = commentRepository.findById(100l);
        assertThat(comment).isEmpty();

        // Then
        Comment one = comment.orElseThrow(IllegalArgumentException::new);

    }

}
