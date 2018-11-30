package nz.co.ctg.domain.model;

import static java.util.stream.Collectors.joining;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "isbn", "catalogId", "title", "subtitle", "publicationDate", "authorList", "categoryList" })
public class Book {
    private Long id;
    private String isbn;
    private String catalogId;
    private String title;
    private String subtitle;
    private LocalDate publicationDate;
    private List<Author> authors;
    private Set<Category> categories;

    public Book() {
    }

    public void addAuthor(Author author) {
        if (!getAuthors().contains(author)) {
            getAuthors().add(author);
            author.addBook(this);
        }
    }

    public void removeAuthor(Author author) {
        if (getAuthors().contains(author)) {
            getAuthors().remove(author);
            author.removeBook(this);
        }
    }

    @JsonProperty(access = Access.READ_ONLY)
    public String getAuthorList() {
        return getAuthors().stream().map(Author::getFullName).collect(joining(", "));
    }

    public void addCategory(Category category) {
        getCategories().add(category);
    }

    public void removeCategory(Category category) {
        getCategories().remove(category);
    }

    @JsonProperty(access = Access.READ_ONLY)
    public String getCategoryList() {
        return getCategories().stream().map(Category::getName).collect(joining(", "));
    }

    @JsonIgnore
    public List<Author> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<>();
        }
        return authors;
    }

    public String getCatalogId() {
        return catalogId;
    }

    @JsonIgnore
    public Set<Category> getCategories() {
        if (categories == null) {
            categories = new HashSet<>();
        }
        return categories;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return Objects.equals(isbn, other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

}
