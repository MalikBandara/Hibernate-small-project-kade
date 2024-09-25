package lk.ijse.dao;

import lk.ijse.dao.impl.CustomerDAOImpl;
import lk.ijse.dao.impl.ItemDaoImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public CrudDAO getCrudDAO(DAOType daoType) {

        switch (daoType) {
             case CUSTOMER:
                 return new CustomerDAOImpl();
            case Item:
                return new ItemDaoImpl();
                 default:
                     return null;
        }

    }
}
