package lk.ijse.dao.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.ItemDao;
import lk.ijse.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Object save = session.save(entity);
        if (save != null) {
            transaction.commit();
            session.close();
            return true;
        }
        transaction.rollback();
        return false;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Item where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public List<Item> getAll() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Item");
        List<Item> item = query.list();
        transaction.commit();
        session.close();
        return item;
    }
}
