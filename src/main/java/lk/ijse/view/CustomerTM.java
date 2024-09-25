package lk.ijse.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CustomerTM {
    @Id
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", name='" + customerName + '\'' +
                ", address='" + customerAddress + '\'' +
                ", tele='" + customerPhone + '\'' +
                '}';
    }
}
