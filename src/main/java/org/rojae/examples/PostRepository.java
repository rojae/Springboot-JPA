package org.rojae.examples;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 Bean으로 자동으로 등록되기 때문에 @Repository 필요 없음
 @Import(JpaRepositoriesRegistrar.class)
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}
