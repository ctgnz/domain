package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
