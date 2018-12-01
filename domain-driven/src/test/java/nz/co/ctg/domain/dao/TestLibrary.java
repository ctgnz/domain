package nz.co.ctg.domain.dao;

import java.util.ArrayList;
import java.util.List;

import nz.co.ctg.domain.model.Author;
import nz.co.ctg.domain.model.Book;
import nz.co.ctg.domain.model.Category;

public class TestLibrary {
    private List<Category> categories = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public TestLibrary() {
        categories.add(createCategory("Fiction - American"));
        categories.add(createCategory("Fiction - British"));
        categories.add(createCategory("Fiction - Young Adult"));
        authors.add(createAuthor("J.D. Salinger", "Salinger", "Jerome"));
        authors.add(createAuthor("F. Scott Fitzgerald", "Fitzgerald", "Scott"));
        authors.add(createAuthor("Charles Dickens", "Dickens", "Charles"));
        books.add(createBook("The Catcher in the Rye", "9787543321724", "FIC-001", getAuthor("J.D. Salinger"), getCategory("Fiction - American")));
        books.add(createBook("The Great Gatsby", "9780743273565", "FIC-002", getAuthor("F. Scott Fitzgerald"), getCategory("Fiction - American")));
        books.add(createBook("A Tale of Two Cities", "9780553211764", "FIC-03", getAuthor("Charles Dickens"), getCategory("Fiction - British")));
        books.add(createBook("Great Expectations", "9781613820766", "FIC-004", getAuthor("Charles Dickens"), getCategory("Fiction - British")));
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Author getAuthor(String fullName) {
        return authors.stream().filter(author -> author.getFullName().equals(fullName)).findAny().orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(String fullName) {
        return books.stream().filter(book -> book.getTitle().equals(fullName)).findAny().orElse(null);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory(String name) {
        return categories.stream().filter(cat -> cat.getName().equals(name)).findAny().orElse(null);
    }

    protected Author createAuthor(String fullName, String lastName, String firstName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setFullName(fullName);
        return author;
    }

    protected Book createBook(String title, String isbn, String catalogId, Author author, Category category) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setCatalogId(catalogId);
        book.getCategories().add(category);
        book.addAuthor(author);
        return book;
    }

    protected Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
