package repository.impl;

import model.MatBang;
import repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements IMatBangRepository {
    private final static ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL = " select * from mat_bang ";

    @Override
    public List<MatBang> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<MatBang> matBangs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("ma_loai_mat_bang");
                String name = rs.getString("ten_loai_mat_bang");
                matBangs.add(new MatBang(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return matBangs;
    }
}
