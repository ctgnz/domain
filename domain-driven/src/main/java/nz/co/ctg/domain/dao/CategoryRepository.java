package nz.co.ctg.domain.dao;

import org.springframework.data.repository.CrudRepository;

import nz.co.ctg.domain.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
