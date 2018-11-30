package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Override
    List<Author> findAll();
}
