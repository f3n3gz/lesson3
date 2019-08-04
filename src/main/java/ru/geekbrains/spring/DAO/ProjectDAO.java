package ru.geekbrains.spring.DAO;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.Model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProjectDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(final Project project) {
        entityManager.persist(project);
    }

    public void merge(final Project project) {
        entityManager.merge(project);
    }

    public Project find(String id) {
        return entityManager.find(Project.class, id);
    }

    public void remove(String id) {
        entityManager.remove(find(id));
    }

    public List<Project> findAll(){
        return entityManager.createQuery("SELECT e FROM Project e",Project.class).getResultList();
    }

    public void removeAll(){
        entityManager.createQuery("DELETE FROM Project e").executeUpdate();
    }
}
