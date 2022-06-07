package repository.impl;

import Model.Service;
import repository.IServiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IServiceRepositoryImpl implements IServiceRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SELECT_ALL_SERVICE = " select * from dich_vu where `status` = 0";
    private final static String SQL_SELECT_SERVICE_BY_ID = " select * from dich_vu where ma_dich_vu = ? and `status` = 0";
    private final static String SQL_SELECT_SERVICE_BY_NAME = " select * from dich_vu where ten_dich_vu like ? and `status` = 0 ";
    private final static String SQL_UPDATE_SERVICE = " call update_service(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private final static String SQL_DELETE_SERVICE = " call delete_service(?) ";
    private final static String SQL_INSERT_SERVICE = " call insert_service(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    @Override
    public List<Service> selectAllService() {
        Connection connection = connectDataBase.getConnection();
        List<Service> services = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_SERVICE);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer code = rs.getInt("ma_dich_vu");
                String name = rs.getString("ten_dich_vu");
                Integer area = rs.getInt("dien_tich");
                Double cost = rs.getDouble("chi_phi_thue");
                Integer maxPeople = rs.getInt("so_nguoi_toi_da");
                String standard = rs.getString("tieu_chuan_phong");
                String desc = rs.getString("mo_ta_tien_nghi_khac");
                Double areaPool = rs.getDouble("dien_tich_ho_boi");
                Integer numberFloor = rs.getInt("so_tang");
                Integer typeRent = rs.getInt("ma_kieu_thue");
                Integer typeService = rs.getInt("ma_loai_dich_vu");

                services.add(new Service(code, name, area, cost, maxPeople, standard, desc, areaPool, numberFloor, typeRent, typeService));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return services;
    }

    @Override
    public Service findServiceByName(String name) {
        Connection connection = connectDataBase.getConnection();
        Service services = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_SERVICE_BY_NAME);
            preparedStatement.setString(1, '%' + name +'%');
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer code = rs.getInt("ma_dich_vu");
                Integer area = rs.getInt("dien_tich");
                Double cost = rs.getDouble("chi_phi_thue");
                Integer maxPeople = rs.getInt("so_nguoi_toi_da");
                String standard = rs.getString("tieu_chuan_phong");
                String desc = rs.getString("mo_ta_tien_nghi_khac");
                Double areaPool = rs.getDouble("dien_tich_ho_boi");
                Integer numberFloor = rs.getInt("so_tang");
                Integer typeRent = rs.getInt("ma_kieu_thue");
                Integer typeService = rs.getInt("ma_dich_vu");

                services = new Service(code, name, area, cost, maxPeople, standard, desc, areaPool, numberFloor, typeRent, typeService);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }

    @Override
    public Service findServiceById(int id) {
        Connection connection = connectDataBase.getConnection();
        Service services = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("ten_dich_vu");
                Integer area = rs.getInt("dien_tich");
                Double cost = rs.getDouble("chi_phi_thue");
                Integer maxPeople = rs.getInt("so_nguoi_toi_da");
                String standard = rs.getString("tieu_chuan_phong");
                String desc = rs.getString("mo_ta_tien_nghi_khac");
                Double areaPool = rs.getDouble("dien_tich_ho_boi");
                Integer numberFloor = rs.getInt("so_tang");
                Integer typeRent = rs.getInt("ma_kieu_thue");
                Integer typeService = rs.getInt("ma_dich_vu");

                services = new Service(id, name, area, cost, maxPeople, standard, desc, areaPool, numberFloor, typeRent, typeService);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }

    @Override
    public void insertService(Service service) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_INSERT_SERVICE);
            callableStatement.setString(1, service.getName());
            callableStatement.setInt(2, service.getArea());
            callableStatement.setDouble(3, service.getCost());
            callableStatement.setInt(4, service.getMaxPeople());
            callableStatement.setString(5, service.getStandardRoom());
            callableStatement.setString(6, service.getDesc());
            callableStatement.setDouble(7, service.getPoolArea());
            callableStatement.setInt(8, service.getNumberFloor());
            callableStatement.setInt(9, service.getTypeRent());
            callableStatement.setInt(10, service.getServiceType());
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
    public void updateService(Integer id, Service service) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_UPDATE_SERVICE);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, service.getName());
            callableStatement.setInt(3, service.getArea());
            callableStatement.setDouble(4, service.getCost());
            callableStatement.setInt(5, service.getMaxPeople());
            callableStatement.setString(6, service.getStandardRoom());
            callableStatement.setString(7, service.getDesc());
            callableStatement.setDouble(8, service.getPoolArea());
            callableStatement.setInt(9, service.getNumberFloor());
            callableStatement.setInt(10, service.getTypeRent());
            callableStatement.setInt(11, service.getServiceType());
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
    public void deleteService(int id) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_DELETE_SERVICE);
            callableStatement.setInt(1, id);
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
}


