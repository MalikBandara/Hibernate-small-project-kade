package lk.ijse.view;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class OrderTM {
    @Id
    private int orderId;
    private Date orderDate;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Item item;
}
