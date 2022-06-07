package repository.impl;

import Model.Gender;
import repository.IGenderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IGenderRepositoryImpl implements IGenderRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_GENDER = " select * from gioi_tinh ";

    public List<Gender> findAllGender(){
        List<Gender> genders = new ArrayList<>();
        Connection  connection = connectDataBase.getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_GENDER);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_gioi_tinh");
                String name = rs.getString("ten_gioi_tinh");
                genders.add(new Gender(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genders;
    }
}
