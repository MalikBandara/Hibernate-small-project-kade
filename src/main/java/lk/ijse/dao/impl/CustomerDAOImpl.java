package lk.ijse.dao.impl;

import lk.ijse.config.SessionFactoryConfiguration;
import lk.ijse.dao.CustomerDAO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public  boolean save(Customer customer) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Object save = session.save(customer);
        if (save!=null){
            tx.commit();
            session.close();
            return true;
        }
        tx.rollback();
        return false;
    }

    @Override
    public boolean update(Customer entity)  {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
        return true;

    }


    @Override
    public boolean delete(int id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Customer where id="+id).executeUpdate();
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public List<Customer> getAll() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> customer = query.list();
        transaction.commit();
        session.close();
        return customer;
    }


}
