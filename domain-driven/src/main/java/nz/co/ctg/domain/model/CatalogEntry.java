package nz.co.ctg.domain.model;

public class CatalogEntry {
    private Book book;
    private int copies;

    public CatalogEntry() {
    }

    public Book getBook() {
        return book;
    }

    public int getCopies() {
        return copies;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
