package nz.co.ctg.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private Set<Book> books;

    public Author() {
    }

    public void addBook(Book book) {
        getBooks().add(book);
    }

    public void removeBook(Book book) {
        if (getBooks().contains(book)) {
            getBooks().remove(book);
        }
    }

    @JsonIgnore
    public Set<Book> getBooks() {
        if (books == null) {
            books = new HashSet<>();
        }
        return books;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        Author other = (Author) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(fullName, other.fullName) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, fullName, lastName);
    }
}
