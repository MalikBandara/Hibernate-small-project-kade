package lk.ijse.bo.impl;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.ItemDTO;

import java.util.List;

public interface ItemBo extends SuperBo {

     boolean saveItem(ItemDTO itemDTO) throws Exception;

    boolean UpdateItem(ItemDTO itemDTO) throws Exception;

    boolean DeleteItem(int id);

    List<ItemDTO> getAllItems();
}
