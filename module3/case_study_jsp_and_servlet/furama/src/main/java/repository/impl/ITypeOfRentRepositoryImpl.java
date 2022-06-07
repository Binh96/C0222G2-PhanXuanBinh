package repository.impl;

import Model.TypeOfRent;
import repository.ITypeOfRentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ITypeOfRentRepositoryImpl implements ITypeOfRentRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL_TYPE_OF_RENT = " select * from kieu_thue ";

    @Override
    public List<TypeOfRent> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<TypeOfRent> typeOfRents = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_TYPE_OF_RENT);
            ResultSet  rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_kieu_thue");
                String name = rs.getString("ten_kieu_thue");

                typeOfRents.add(new TypeOfRent(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeOfRents;
    }
}
