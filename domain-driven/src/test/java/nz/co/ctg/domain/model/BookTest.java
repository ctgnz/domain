package nz.co.ctg.domain.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BookTest {

    private static final String SERIALIZED = "{\"id\":42,\"isbn\":\"9780671432419\",\"catalogId\":null,\"title\":\"The Hitchhiker's Guide to the Galaxy\",\"subtitle\":null,\"publicationDate\":null,\"authorList\":\"Douglas Adams\",\"categoryList\":\"Science Fiction, Humour\"}";

    @Test
    public void testAuthors() throws Exception {
        Book book = new Book();
        book.setId(42L);
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setIsbn("9780671432419");

        assertThat("Authors should be empty", book.getAuthors(), empty());

        Author author = new Author();
        author.setFirstName("Douglas");
        author.setLastName("Adams");
        author.setFullName("Douglas Adams");

        book.addAuthor(author);
        assertThat("Author should have been added", book.getAuthors(), hasSize(1));
        assertThat("Book should have been added to author", author.getBooks(), hasSize(1));
        assertThat("Book should have been added to author", author.getBooks().iterator().next(), is(book));
    }

    @Test
    public void testSerialize() throws Exception {
        Book book = new Book();
        book.setId(42L);
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setIsbn("9780671432419");

        Author author = new Author();
        author.setId(54L);
        author.setFirstName("Douglas");
        author.setLastName("Adams");
        author.setFullName("Douglas Adams");
        book.addAuthor(author);

        Category cat1 = new Category();
        cat1.setId(1L);
        cat1.setName("Science Fiction");
        book.addCategory(cat1);

        Category cat2 = new Category();
        cat2.setId(1L);
        cat2.setName("Humour");
        book.addCategory(cat2);

        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writer().writeValue(out, book);
        assertThat("Incorrect serialization", new String(out.toByteArray()), is(SERIALIZED));
    }

    @Test
    public void testDeserialize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readerFor(Book.class).readValue(new StringReader(SERIALIZED));
        assertThat("Wrong ID", book.getId(), is(42L));
        assertThat("Wrong title", book.getTitle(), is("The Hitchhiker's Guide to the Galaxy"));
        // serialized form doesn't include authors
        assertThat("Authors should be empty", book.getAuthors(), empty());
    }
}
