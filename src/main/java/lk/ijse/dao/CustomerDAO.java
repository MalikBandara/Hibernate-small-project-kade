package lk.ijse.dao;


import lk.ijse.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer> {

    boolean save(Customer customer);

    boolean update(Customer customer);

}
