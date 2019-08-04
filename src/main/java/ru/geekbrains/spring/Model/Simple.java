package ru.geekbrains.spring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Simple {

    public Simple(){
        this.id= UUID.randomUUID().toString();
    }

    @Id
    private String id;

    private String name;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Simple simple = (Simple) o;
        return Objects.equals(id, simple.id) &&
                Objects.equals(name, simple.name) &&
                Objects.equals(description, simple.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
