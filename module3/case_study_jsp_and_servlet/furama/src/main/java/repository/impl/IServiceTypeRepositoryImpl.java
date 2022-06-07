package repository.impl;

import Model.TypeOfService;
import repository.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IServiceTypeRepositoryImpl implements IServiceTypeRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL_TYPE_OF_SERVICE = " select * from loai_dich_vu ";

    @Override
    public List<TypeOfService> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<TypeOfService> typeOfServices = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_TYPE_OF_SERVICE);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_loai_dich_vu");
                String name = rs.getString("ten_loai_dich_vu");

                typeOfServices.add(new TypeOfService(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeOfServices;
    }
}
