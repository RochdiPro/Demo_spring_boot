package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DefaultService<T, E> {

    default T add(T entity) {
        return this.getRepository().save(entity);
    }

    default T update(T entity) {
        return this.getRepository().save(entity);
    }

    default List<T> findAll() {
        return this.getRepository().findAll();
    }

    default Optional<T> getById(E id) {
        return this.getRepository().findById(id);
    }

    default void delete(E id) {
        this.getRepository().deleteById(id);
    }

    JpaRepository<T, E> getRepository();

}
