package repository.impl;

import Model.TypeOfCustomer;
import repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL_CUSTOMER = " select * from loai_khach ";

    @Override
    public List<TypeOfCustomer> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<TypeOfCustomer> typeOfCustomers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_loai_khach");
                String name = rs.getString("ten_loai_khach");
                typeOfCustomers.add(new TypeOfCustomer(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeOfCustomers;
    }
}
