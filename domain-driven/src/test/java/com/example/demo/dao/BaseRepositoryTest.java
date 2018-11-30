package com.example.demo.dao;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = true)
public abstract class BaseRepositoryTest {

    @Resource
    protected TestEntityManager entityManager;

    protected TestLibrary library = new TestLibrary();

    @Before
    public void setup() {
        library.getCategories().forEach(cat -> entityManager.persist(cat));
        library.getAuthors().forEach(author -> entityManager.persist(author));
        library.getBooks().forEach(book -> entityManager.persist(book));
    }

    protected Book createBook(String title, String isbn, String catalogId, Author author, Category category) {
        return library.createBook(title, isbn, catalogId, author, category);
    }

    protected Author createAuthor(String fullName, String lastName, String firstName) {
        return library.createAuthor(fullName, lastName, firstName);
    }

    protected Category createCategory(String name) {
        return library.createCategory(name);
    }
}