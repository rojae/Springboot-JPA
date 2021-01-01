package org.rojae.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void run(){
        // GIVEN
        this.createComment(100, "SPRING 100 LIKE COUNT");
        this.createComment(50, "SPRING 50 LIKE COUNT");
        this.createComment(10, "SPRING 10 LIKE COUNT");

        // WHEN (단순 키워드 내림차순 검색)
        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");

        // TEST (리스트의 반환 첫번째의 좋아요는 100)
        assertThat(comments.size()).isEqualTo(3);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount" , 100);

        // When (단순 키워드 오름차순 검색)
        comments = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountAsc("spring");


        // Test (리스트의 반환 첫번째의 좋아요는 10)
        assertThat(comments.size()).isEqualTo(3);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount" , 10);

        // When (페이지 반환 키워드 검색)
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Page<Comment> pageComment = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);

        // Test (내림차순의 경우 첫번째 좋아요는 100이다)
        assertThat(pageComment.getNumberOfElements()).isEqualTo(3);
        assertThat(pageComment).first().hasFieldOrPropertyWithValue("likeCount", 100);

        // When (페이지 반환 키워드 검색)
        pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "LikeCount"));
        pageComment = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);

        // Test (오름차순의 경우 첫번째 좋아요는 10이다)
        assertThat(pageComment.getNumberOfElements()).isEqualTo(3);
        assertThat(pageComment).first().hasFieldOrPropertyWithValue("likeCount", 10);

    }

    private void createComment(int likeCount, String txt){
        Comment comment = new Comment();
        comment.setComment(txt);
        comment.setLikeCount(likeCount);
        commentRepository.save(comment);
    }

}
