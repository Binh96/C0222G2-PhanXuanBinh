package repository.impl;

import Model.Position;
import repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IPositionRepositoryImpl implements IPositionRepository {
    private final String SQL_SELECT_ALL_POSITION = " select * from vi_tri ";

    ConnectDataBase connectDataBase = new ConnectDataBase();

    @Override
    public List<Position> findAllPosition(){
        List<Position> positions = new ArrayList<>();
        Connection connection = connectDataBase.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_POSITION);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_vi_tri");
                String name = rs.getString("ten_vi_tri");
                positions.add(new Position(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positions;
    }
}
