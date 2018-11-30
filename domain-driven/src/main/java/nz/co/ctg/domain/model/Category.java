package nz.co.ctg.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {
    private Long id;
    private String name;
    private Set<String> alternateNames;

    public Category() {
    }

    public Set<String> getAlternateNames() {
        if (alternateNames == null) {
            alternateNames = new HashSet<>();
        }
        return alternateNames;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
        Category other = (Category) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
