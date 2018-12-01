package nz.co.ctg.domain.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nz.co.ctg.domain.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Override
    List<Author> findAll();
}
