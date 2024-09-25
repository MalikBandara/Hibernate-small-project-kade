package lk.ijse.bo;


import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;

import java.sql.SQLException;
import java.util.List;


public interface CustomerBo extends SuperBo {

    boolean saveCustomer(CustomerDTO customer);

    boolean updateCustomer(CustomerDTO customer ) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(int  id) throws SQLException, ClassNotFoundException;

    List<CustomerDTO> getAllCustomer();
}
