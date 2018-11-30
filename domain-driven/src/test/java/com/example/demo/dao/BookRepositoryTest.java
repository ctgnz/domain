package com.example.demo.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.example.demo.entity.Book;

public class BookRepositoryTest extends BaseRepositoryTest {
    @Resource
    private BookRepository bookRepo;

    @Test
    public void testFindAll() throws Exception {
        List<Book> allBooks = bookRepo.findAll();
        assertThat("Should have found book", allBooks, hasSize(4));
    }

    @Test
    public void testSave() throws Exception {
      Book book = new Book();
      book.setTitle("Swallows and Amazons");
      book.setIsbn("9781567924206");
      bookRepo.save(book);
      assertThat("Should have included new book", bookRepo.findAll(), hasSize(5));
    }

    @Test
    public void testFindByTitle() throws Exception {
        Book book = bookRepo.findByTitle("The Catcher in the Rye");
        assertThat("Should have found book by title", book, notNullValue());
    }

    @Test
    public void testFindByIsbn() throws Exception {
        Book book = bookRepo.findByIsbn("9780743273565");
        assertThat("Should have found book by title", book, notNullValue());
        assertThat("Should have found The Great Gatsby", book.getTitle(), is("The Great Gatsby"));
    }

    @Test
    public void testFindByAuthor() throws Exception {
        List<Book> books = bookRepo.findByAuthorsFullName("Charles Dickens");
        assertThat("Should have included new book", books, hasSize(2));
    }
}
