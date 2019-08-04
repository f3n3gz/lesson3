package ru.geekbrains.spring.DAO;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public abstract class AbstractDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> void persist(T object){
        entityManager.persist(object);
    }

    public <T> void merge(T object){
        entityManager.merge(object);
    }

    public <T> T getEntity(TypedQuery<T> query){
        final List<T> resultList=query.getResultList();
        if (resultList.isEmpty()){
            return null;
        }
        return resultList.get(0);
    }

//    public <T> Object find(String id){
//        return  entityManager.find(tClass.getClass(),id);
//    }
//
//    public <T> void remove (T object){
//        entityManager.remove(f);
//    }
}
