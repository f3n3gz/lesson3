package ru.geekbrains.spring.DAO;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.Model.Simple;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class SimpleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Simple simple) {
        entityManager.persist(simple);
    }

    public void merge(Simple simple) {
        entityManager.merge(simple);
    }

    public Simple find(String id) {
        return entityManager.find(Simple.class, id);
    }

    public void remove(String id){
        entityManager.remove(find(id));
    }

    public List<Simple> findAll(){
        return entityManager.createQuery("SELECT e FROM Simple e",Simple.class).getResultList();
    }

    public void removeAll(){
        entityManager.createQuery("DELETE FROM Simple e").executeUpdate();
    }
}
