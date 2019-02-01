package net.dovale.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractCrudDao<T> {

    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;
    private final String entityName;

    protected AbstractCrudDao(SessionFactory sessionFactory, Class<T> entityClass, String entityName) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
        this.entityName = entityName;
    }

    public T save(T entity){
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public void delete(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    public T find(long id){
        return sessionFactory.getCurrentSession().find(entityClass, id);
    }

    public List<T> list(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
        query.select(query.from(entityClass));
        return session.createQuery(query).getResultList();
    }
}