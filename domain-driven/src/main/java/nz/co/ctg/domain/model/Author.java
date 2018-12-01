package nz.co.ctg.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;
    @ManyToMany(mappedBy = "authors")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonIgnore
    public Set<Book> getBooks() {
        if (books == null) {
            books = new HashSet<>();
        }
        return books;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, fullName, lastName);
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
}
