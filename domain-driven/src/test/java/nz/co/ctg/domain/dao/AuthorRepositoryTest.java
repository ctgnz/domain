package nz.co.ctg.domain.dao;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import nz.co.ctg.domain.dao.AuthorRepository;
import nz.co.ctg.domain.model.Author;

public class AuthorRepositoryTest extends BaseRepositoryTest {
    @Resource
    private AuthorRepository candidate;

    @Test
    public void testFindAll() throws Exception {
        List<Author> all = candidate.findAll();
        assertThat("Wrong number of authors", all, hasSize(3));
    }
}
