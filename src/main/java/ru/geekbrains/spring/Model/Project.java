package ru.geekbrains.spring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import ru.geekbrains.spring.Enumerated.Status;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_Project")
@Getter
@Setter
public class Project {

    public Project(){
        this.id= UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Column
    private String name;

    @Enumerated
    private Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) &&
                Objects.equals(name, project.name) &&
                status == project.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }
}
