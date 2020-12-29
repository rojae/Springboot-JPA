package org.rojae.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @Rollback(false)
    public void run(){
        // Given
        Comment comment = new Comment();
        comment.setComment("Test");

        // Then
        assertThat(comment.getId()).isNull();

        // When
        commentRepository.save(comment);

        // Then
        assertThat(comment.getId()).isEqualTo(1);

        // When
        List<Comment> list = commentRepository.findAll();

        // Then
        assertThat(list.size()).isEqualTo(1);

        // When
        Page<Comment> page = commentRepository.findByCommentContains("Test", PageRequest.of(0, 10));

        // Then
        assertThat(page.getNumberOfElements()).isEqualTo(1);
    }

}
