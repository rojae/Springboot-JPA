package org.rojae.examples;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomRepository<T> {
    List<Post> findMyPost();

    // remove시 엔티티 remove에서 삭제하는 이유
    // casecade의 경우 ~> 성능적인 면에서 별로지만, casecade를 취소하거나
    // 묶여있어서 취소가 불가능한 경우, rollback을 시켜야하는데, 이때 insert를 해야함..
    // ~> 비효율적

    // custom delete
    void delete(T entity);
}
