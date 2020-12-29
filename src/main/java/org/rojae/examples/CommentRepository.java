package org.rojae.examples;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

// JPA repository 실제 구현, (not extends JpaRepository)
@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository {

    Comment save(Comment comment);

    List<Comment> findAll();

    Page<Comment> findByCommentContains(String comment, Pageable pageable);
}
