package repository.impl;

import Model.Level;
import repository.ILevelRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ILevelRepositoryImpl implements ILevelRepository {
    private final String SQL_SELECT_ALL_GENDER = " select * from trinh_do ";

    ConnectDataBase connectDataBase = new ConnectDataBase();

    @Override
    public List<Level> findAllLevel() {
        List<Level> levels = new ArrayList<>();
        Connection connection = connectDataBase.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_GENDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("ma_trinh_do");
                String name = resultSet.getString("ten_trinh_do");
                levels.add(new Level(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return levels;
    }
}
