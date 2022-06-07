package repository.impl;

import Model.Division;
import repository.IDevisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDevisionRepositoryImpl implements IDevisionRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL_DIVISION = " select * from bo_phan ";

    @Override
    public List<Division> findAllDivision() {
        List<Division> divisions = new ArrayList<>();
        Connection connection = connectDataBase.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_DIVISION);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_bo_phan");
                String name = rs.getString("ten_trinh_do");
                divisions.add(new Division(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }
}
