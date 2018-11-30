package com.example.demo.entity;

public class CatalogEntry {
    private Book book;
    private LibraryBranch branch;
    private int copies;

    public CatalogEntry() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LibraryBranch getBranch() {
        return branch;
    }

    public void setBranch(LibraryBranch branch) {
        this.branch = branch;
    }
}
