package lk.ijse.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ItemDTO {

    private int id;
    private String name;
    private double price;
    private int quantity;
}
