package repository.impl;

import model.ToaNha;
import repository.IToaNhaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToaNhaRepositoryImpl implements IToaNhaRepository {
    private final static ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL = " select * from toa_nha where `status`= 0 ";
    private final static String SQL_SELECT_BY_ID = " select * from toa_nha where ma_mat_bang = ? and `status`= 0 ";
    private final static String SQL_INSERT_BUILDING = " call insert_toa_nha(?, ?, ?, ?,?,?, ?, ?, ?) ";
    private final static String SQL_UPDATE_BUILDING = " call update_toa_nha(?, ?, ?, ?, ?,?,?) ";
    private final static String SQL_DELETE_BUILDING = " call delete_toa_nha(?) ";
    private final static String SQL_SELECT_ALL_ATTRIBUTE = " select * from toa_nha "+
            " join mat_bang on toa_nha.loai_mat_bang = mat_bang.ma_loai_mat_bang "+
            " join trang_thai_mat_bang on toa_nha.ha_tang = trang_thai_mat_bang.ma_trang_thai "+
            " where ma_mat_bang like ? " +
            " and mat_bang.ma_loai_mat_bang like ? " + " and trang_thai_mat_bang.ma_trang_thai like ? ";


    @Override
    public List<ToaNha> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<ToaNha> toaNhas = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String code = rs.getString("ma_mat_bang");
                Integer haTang = rs.getInt("ha_tang");
                Double dienTich = rs.getDouble("dien_tich");
                Integer soTang = rs.getInt("so_tang");
                Integer loaiMatBang = rs.getInt("loai_mat_bang");
                String desc = rs.getString("mo_ta_chi_tiet");
                Integer giaTien = rs.getInt("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                toaNhas.add(new ToaNha(code, haTang, dienTich, soTang, loaiMatBang, desc,giaTien, ngayBatDau, ngayKetThuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toaNhas;
    }

    @Override
    public ToaNha selectByCode(String name) {
        return null;
    }

    @Override
    public List<ToaNha> selectByManyAttribute(String name, String trangThai, String matBang) {
        Connection connection = connectDataBase.getConnection();
        List<ToaNha> toaNhas = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ATTRIBUTE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, matBang);
            preparedStatement.setString(3, trangThai);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String code = rs.getString("ma_mat_bang");
                Integer haTang = rs.getInt("ha_tang");
                Double dienTich = rs.getDouble("dien_tich");
                Integer soTang = rs.getInt("so_tang");
                Integer loaiMatBang = rs.getInt("loai_mat_bang");
                String desc = rs.getString("mo_ta_chi_tiet");
                Integer giaTien = rs.getInt("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                toaNhas.add(new ToaNha(code, haTang, dienTich, soTang, loaiMatBang, desc,giaTien, ngayBatDau, ngayKetThuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toaNhas;
    }

    @Override
    public void insert(ToaNha toaNha) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_INSERT_BUILDING);
            callableStatement.setString(1, toaNha.getMaToaNha());
            callableStatement.setInt(2, toaNha.getHaTang());
            callableStatement.setDouble(3, toaNha.getDienTich());
            callableStatement.setInt(4, toaNha.getSoTang());
            callableStatement.setInt(5, toaNha.getLoaiMatBang());
            callableStatement.setString(6, toaNha.getDesc());
            callableStatement.setInt(7, toaNha.getGiaTien());
            callableStatement.setString(8, toaNha.getNgayBatDau());
            callableStatement.setString(9, toaNha.getNgayKetThuc());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_DELETE_BUILDING);
            callableStatement.setString(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String id, ToaNha toaNha) {

    }
}
