package nz.co.ctg.domain.model;

import java.util.List;

public class Library {
    private String name;
    private List<LibraryBranch> branches;
    private List<CatalogEntry> catalog;

    public Library() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LibraryBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<LibraryBranch> branches) {
        this.branches = branches;
    }

    public List<CatalogEntry> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<CatalogEntry> catalog) {
        this.catalog = catalog;
    }
}
