package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDAO {

    public Session session;

    public AbstractDAO() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public abstract void insert(Object object);

    public abstract void update(Object object);

    public abstract void delete(Object object);

    public abstract Object list(int object);

    public abstract Object listAll();

}
