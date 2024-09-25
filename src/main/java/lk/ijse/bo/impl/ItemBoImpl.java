package lk.ijse.bo.impl;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.DAOType;
import lk.ijse.dao.ItemDao;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getCrudDAO(DAOType.Item);

    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return  itemDao.save(new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getPrice(),itemDTO.getQuantity()));

    }

    @Override
    public boolean UpdateItem(ItemDTO itemDTO) throws Exception {
        return  itemDao.update(new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity()));
    }

    @Override
    public boolean DeleteItem(int id) {
        return  itemDao.delete(id);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> Items =  itemDao.getAll();
        for (Item item: Items) {
            itemDTOS.add(new ItemDTO(item.getId(),item.getName(), item.getPrice(), item.getQuantity()));
        }
        return itemDTOS;
    }

}
