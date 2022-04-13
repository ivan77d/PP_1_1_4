package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            final String sql = "CREATE TABLE IF NOT EXISTS user (" +
                    "id BIGINT (10) AUTO_INCREMENT,\n" +
                    "name varchar(45) NOT NULL,\n" +
                    "lastName varchar(45) NOT NULL,\n" +
                    "age int (10) NOT NULL,\n" +
                    "PRIMARY KEY (id)\n" +
                    ")";
            session.createSQLQuery(sql);
            session.getTransaction().commit();
            session.close();
        } catch(Exception ex)
        {
            throw ex;
        }
    }


    @Override
    public void dropUsersTable() {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS user";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            System.out.println("Table drop");
            session.getTransaction().commit();
            session.close();
        }catch(Exception ex)
        {
            throw ex;
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            System.out.printf("User с именем %s добавлен в базу данных", user.getName());
            session.getTransaction().commit();
            session.close();
        }catch(Exception ex)
        {
            throw ex;
        }

    }

    @Override
    public void removeUserById(long id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete User WHERE id = :Id");
            query.setParameter("Id", id);
            query.executeUpdate();
            System.out.println("User delete");
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception ex)
        {
            throw ex;
        }

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) sessionFactory.openSession().createQuery("FROM User", User.class).list();
    }

    @Override
    public void cleanUsersTable() {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            for (User user : getAllUsers()) {
                removeUserById(user.getId());
            }
            session.getTransaction().commit();
            session.close();
        }catch(Exception ex)
        {
            throw ex;
        }

    }
}
