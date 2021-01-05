package org.rojae.examples;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
 Bean으로 자동으로 등록되기 때문에 @Repository 필요 없음
 @Import(JpaRepositoriesRegistrar.class)
 */
public interface PostRepository extends  CommonRepository<Post, Long>
{
    public Page<Post> findByTitleContains(String title, Pageable pageable);
    public Long countByTitleContains(String title);

}
