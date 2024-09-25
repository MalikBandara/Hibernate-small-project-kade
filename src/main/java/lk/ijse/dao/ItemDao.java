package lk.ijse.dao;


import lk.ijse.entity.Item;


import java.sql.SQLException;

public interface ItemDao extends CrudDAO<Item>{
     boolean save(Item entity) throws SQLException, ClassNotFoundException ;
}
