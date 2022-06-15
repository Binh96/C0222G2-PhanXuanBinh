package repository.impl;

import model.TrangThaiMatBang;
import repository.ITrangThaiMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiMatBangRepositoryImpl implements ITrangThaiMatBangRepository {
    private final static ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL = " select * from trang_thai_mat_bang ";

    @Override
    public List<TrangThaiMatBang> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<TrangThaiMatBang> trangThaiMatBangs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("ma_trang_thai");
                String name = rs.getString("ten_loai_trang_thai");
                trangThaiMatBangs.add(new TrangThaiMatBang(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return trangThaiMatBangs;
    }
}
