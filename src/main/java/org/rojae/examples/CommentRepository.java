package org.rojae.examples;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long>{

    // keyword의 문자를 대문자로 바꾸어 준다
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String keyword);

    // Page
    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);


}
