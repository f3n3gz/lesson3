package ru.geekbrains.spring.DAO;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.Model.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TaskDAO extends AbstractDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Task task) {
        entityManager.persist(task);
    }

    public void merge(Task task) {
        entityManager.merge(task);
    }

    public Task find(String id) {
        return entityManager.find(Task.class, id);
    }

    public void remove(String id) {
        entityManager.remove(find(id));
    }

    public List<Task> findAll() {
        return entityManager.createQuery("SELECT e FROM Task e", Task.class).getResultList();
    }

    public Task getById(final String id) {
        if (id.isEmpty()) {
            return null;
        }
        return getEntity(entityManager.createQuery("SELECT e FROM Task e WHERE e.id=:id", Task.class)
                .setParameter("id", id));
    }

    public void removeAll() {
        entityManager.createQuery("DELETE FROM Task e").executeUpdate();
    }
}
