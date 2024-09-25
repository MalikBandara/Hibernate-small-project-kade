package lk.ijse.bo;

import lk.ijse.bo.impl.CustomerBOImpl;
import lk.ijse.bo.impl.ItemBoImpl;
import lk.ijse.entity.Customer;

public class BoFactory {

    private static BoFactory instance;

    private BoFactory() {

    }

    public static BoFactory getBoFactory() {
        if (instance == null) {
            instance = new BoFactory();
        }
        return instance;
    }
    public SuperBo getBo(BOTypes boType) {
        switch (boType) {
            case Customer :
                return new CustomerBOImpl();
            case Item:
                return new ItemBoImpl();
                default:
                    return null;
        }

    }
}
