package nz.co.ctg.domain.dao;

import java.util.List;

import javax.persistence.criteria.ListJoin;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import nz.co.ctg.domain.model.Author;
import nz.co.ctg.domain.model.Author_;
import nz.co.ctg.domain.model.Book;
import nz.co.ctg.domain.model.Book_;

public interface BookRepository extends CrudRepository<Book, Long> {

    default Specification<Book> byAuthorFullName(String fullName) {
        return (root, query, cb) -> {
            ListJoin<Book, Author> join = root.join(Book_.authors);
            return cb.equal(join.get(Author_.fullName), fullName);
        };
    }

    @Override
    List<Book> findAll();

    List<Book> findAll(Specification<Book> spec);

    default List<Book> findByAuthorsFullName(String fullName) {
        return findAll(byAuthorFullName(fullName));
    }

    Book findByIsbn(String string);

    Book findByTitle(String title);
}
