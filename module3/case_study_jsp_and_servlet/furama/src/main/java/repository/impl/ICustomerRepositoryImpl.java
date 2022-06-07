package repository.impl;

import Model.Customer;
import repository.ICustomerRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ICustomerRepositoryImpl implements ICustomerRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static String SQL_SELECT_ALL_CUSTOMER = " select * from khach_hang where `status` = 0 ";
    private final static String SQL_INSERT_CUSTOMER = " call insert_customer(?, ?, ?, ?, ?, ?, ?, ?) ";
    private final static String SQL_DELETE_CUSTOMER = " call delete_customer(?) ";
    private final static String SQL_UPDATE_CUSTOMER = " call update_customer(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private final static String SQL_SELECT_CUSTOMER = " select * from khach_hang where id= ? and `status` = 0 ";
    private final static String SQL_SELECT_BY_ID = " select * from khach_hang where ma_khach_hang = ? and `status`= 0 ";
    private final static String SQL_SELECT_BY_NAME = " select * from khach_hang where ho_ten like ? and `status`= 0 ";

    @Override
    public List<Customer> selectAll() {
        Connection connection = connectDataBase.getConnection();
        List<Customer> customers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer codeCustomer = rs.getInt("ma_khach_hang");
                String name = rs.getString("ho_ten");
                Date dob = rs.getDate("ngay_sinh");
                Integer gender = rs.getInt("ma_gioi_tinh");
                String cmnd = rs.getString("so_cmnd");
                String numberPhone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Integer customerType = rs.getInt("ma_loai_khach");
                customers.add(new Customer(codeCustomer, name, dob, gender, cmnd, numberPhone, email, address, customerType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = connectDataBase.getConnection();

        try{
            String dob = simpleDateFormat.format(customer.getDateOfBirth());
            CallableStatement callableStatement = connection.prepareCall(SQL_INSERT_CUSTOMER);
            callableStatement.setString(1, customer.getName());
            callableStatement.setInt(2, customer.getGender());
            callableStatement.setString(3, dob);
            callableStatement.setString(4, customer.getId());
            callableStatement.setString(5, customer.getPhoneMobile());
            callableStatement.setString(6, customer.getEmail());
            callableStatement.setString(7, customer.getAddress());
            callableStatement.setInt(8, customer.getCustomerType());
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
    public Customer findById(int id) {
        Connection connection = connectDataBase.getConnection();
        Customer customer = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("ho_ten");
                Date dob = rs.getDate("ngay_sinh");
                Integer gender = rs.getInt("ma_gioi_tinh");
                String cmnd= rs.getString("so_cmnd");
                String numberPhone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Integer customerType = rs.getInt("ma_loai_khach");
                customer = new Customer(id, name, dob, gender, cmnd, numberPhone, email, address, customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer findByName(String name) {
        Connection connection = connectDataBase.getConnection();
        Customer customer = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME);
            preparedStatement.setString(1, '%' + name +'%');
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ma_khach_hang");
                String name2 = rs.getString("ho_ten");
                Date dob = rs.getDate("ngay_sinh");
                Integer gender = rs.getInt("ma_gioi_tinh");
                String cmnd= rs.getString("so_cmnd");
                String numberPhone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Integer customerType = rs.getInt("ma_loai_khach");
                customer = new Customer(id, name2, dob, gender, cmnd, numberPhone, email, address, customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Connection connection = connectDataBase.getConnection();

        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_DELETE_CUSTOMER);
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

    @Override
    public boolean checkCustomer(int id) {
        Connection connection = connectDataBase.getConnection();
        try{
           PreparedStatement preparedStatement= connection.prepareStatement(SQL_SELECT_CUSTOMER);
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()){
               Integer id1 = rs.getInt("ma_khach_hang");
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void updateCustomer(int id, Customer customer){
        Connection connection = connectDataBase.getConnection();

        try{
            String dob = simpleDateFormat.format(customer.getDateOfBirth());
            CallableStatement callableStatement = connection.prepareCall(SQL_UPDATE_CUSTOMER);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, customer.getName());
            callableStatement.setInt(3, customer.getGender());
            callableStatement.setString(4, dob);
            callableStatement.setString(5, customer.getId());
            callableStatement.setString(6, customer.getPhoneMobile());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());
            callableStatement.setInt(9, customer.getCustomerType());
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
