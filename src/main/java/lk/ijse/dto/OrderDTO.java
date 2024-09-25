package lk.ijse.dto;


import jakarta.persistence.ManyToOne;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderDTO {

    private int orderId;
    private Date orderDate;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Item item;


}
