package lk.ijse.bo.impl;

import lk.ijse.bo.CustomerBo;
import lk.ijse.dao.CustomerDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.DAOType;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;

import java.util.ArrayList;
import java.util.List;


public class CustomerBOImpl implements CustomerBo {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getCrudDAO(DAOType.CUSTOMER);


    public  boolean saveCustomer(CustomerDTO customer) {
        return  customerDAO.save(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerPhone()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer)  {
        return customerDAO.update(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerPhone()));
    }
    public boolean deleteCustomer(int id)  {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<Customer> customers =  customerDAO.getAll();
        for (Customer customer: customers) {
            customerDTOS.add(new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerPhone()));
        }
        return customerDTOS;
    }

}
