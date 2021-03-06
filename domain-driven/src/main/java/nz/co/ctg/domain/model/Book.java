package nz.co.ctg.domain.model;

import static java.util.stream.Collectors.joining;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "isbn", "catalogId", "title", "subtitle", "publicationDate", "authorList", "categoryList" })
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String subtitle;
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "author_id") })
    @Column(name = "author_id")
    @OrderColumn(name = "author_index")
    private List<Author> authors;
    @Column(name = "publ_date")
    private LocalDate publicationDate;
    @Column
    private String isbn;
    @Column(name = "catalog_id")
    private String catalogId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category", inverseJoinColumns = { @JoinColumn(name = "category_id") })
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonIgnore
    public List<Author> getAuthors() {
        if (authors == null) {
            authors = new ArrayList<>();
        }
        return authors;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    @JsonIgnore
    public Set<Category> getCategories() {
        if (categories == null) {
            categories = new HashSet<>();
        }
        return categories;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
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

}
