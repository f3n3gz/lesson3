package ru.geekbrains.spring.Model;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.spring.Enumerated.Status;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_Task")
@Getter
@Setter
public class Task {

    public Task(){
        this.id= UUID.randomUUID().toString();
    }

    @Id
    private String id;

    private String name;

    @ManyToOne
    private Project project;

    @Enumerated
    private Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(name, task.name) &&
                Objects.equals(project, task.project) &&
                status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, project, status);
    }
}
