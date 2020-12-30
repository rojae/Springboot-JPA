package org.rojae.examples;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(@NonNull E entity);

    // LIST는 null이 나오지 않고 비어있는 collection이 반환됌
    List<T> findAll();

    long count();

    // Optional을 사용해서 null 체크
    <E extends T> Optional<E> findById(Id id);

}
