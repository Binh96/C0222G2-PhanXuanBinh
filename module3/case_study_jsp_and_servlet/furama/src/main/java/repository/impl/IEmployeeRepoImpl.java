package repository.impl;

import Model.Employee;
import repository.IEmployeeRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IEmployeeRepoImpl implements IEmployeeRepository {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String SQL_SELECT_ALL_EMPLOYEE = " select * from nhan_vien where `status` = 0";
    private static final String SQL_SELECT_EMPLOYEE_BY_ID = " select * from nhan_vien where ma_nhan_vien = ? ";
    private static final String SQL_SELECT_EMPLOYEE_BY_NAME = " select * from nhan_vien where ho_va_ten like ? ";
    private static final String SQL_INSERT_EMPLOYEE = " call insert_nhan_vien(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_UPDATE_EMPLOYEE = " call update_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_DELETE_EMPLOYEE = " call delete_employee(?) ";


    ConnectDataBase connectDataBase = new ConnectDataBase();

    @Override
    public void insertEmployee(Employee employee) {
        Connection connection = connectDataBase.getConnection();
        try{
            CallableStatement callableStatement = connection.prepareCall(SQL_INSERT_EMPLOYEE);
            String mySqlDate = simpleDateFormat.format(employee.getDateOfBirth());
            callableStatement.setString(1, employee.getName());
            callableStatement.setInt(2, employee.getGender());
            callableStatement.setString(3, mySqlDate);
            callableStatement.setString(4, employee.getId());
            callableStatement.setLong(5, employee.getSalary());
            callableStatement.setString(6, employee.getPhoneMobile());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setString(8, employee.getAddress());
            callableStatement.setInt(9, employee.getPosition());
            callableStatement.setInt(10, employee.getLevel());
            callableStatement.setInt(11, employee.getCodeTask());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = connectDataBase.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_va_ten");
                Date dob = resultSet.getDate("ngay_sinh");
                String cmnd = resultSet.getString("so_cmnd");
                Integer gender = resultSet.getInt("ma_gioi_tinh");
                Long salary = resultSet.getLong("luong");
                String numberPhone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Integer codePosition = resultSet.getInt("ma_vi_tri");
                Integer codeLevel = resultSet.getInt("ma_trinh_do");
                Integer codeTask = resultSet.getInt("ma_bo_phan");

                employees.add(new Employee(name, dob, gender, cmnd, numberPhone, email, id, codeLevel, codePosition,
                        salary, codeTask, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(int codeEmployee, Employee employee) {
        Connection connection = connectDataBase.getConnection();
        try{
            String mySqlDate = simpleDateFormat.format(employee.getDateOfBirth());
            CallableStatement callableStatement = connection.prepareCall(SQL_UPDATE_EMPLOYEE);
            callableStatement.setInt(1, codeEmployee);
            callableStatement.setString(2, employee.getName());
            callableStatement.setInt(3, employee.getGender());
            callableStatement.setString(4, mySqlDate);
            callableStatement.setString(5, employee.getId());
            callableStatement.setLong(6, employee.getSalary());
            callableStatement.setString(7, employee.getPhoneMobile());
            callableStatement.setString(8, employee.getEmail());
            callableStatement.setString(9, employee.getAddress());
            callableStatement.setInt(10, employee.getPosition());
            callableStatement.setInt(11, employee.getLevel());
            callableStatement.setInt(12, employee.getCodeTask());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee findEmployeeById(int id) {
        Connection connection = connectDataBase.getConnection();
        Employee employee = null;
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs  = preparedStatement.executeQuery();
            while(rs.next()){
                int crcode = rs.getInt("ma_nhan_vien");
                String name = rs.getString("ho_va_ten");
                Date dob = rs.getDate("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                Integer gender = rs.getInt("ma_gioi_tinh");
                Long salary = rs.getLong("luong");
                String numberPhone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Integer codePosition = rs.getInt("ma_vi_tri");
                Integer codeLevel = rs.getInt("ma_trinh_do");
                int codeTask = rs.getInt("ma_bo_phan");

                employee = new Employee(crcode, name, dob, gender, cmnd, numberPhone, email, codeLevel, codePosition, salary, address, codeTask);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    public Employee findEmployeeByName(String name) {
        Connection connection = connectDataBase.getConnection();
        Employee employee = null;
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, '%' + name + '%');
            ResultSet rs  = preparedStatement.executeQuery();
            while(rs.next()){
                int crcode = rs.getInt("ma_nhan_vien");
                String name2 = rs.getString("ho_va_ten");
                Date dob = rs.getDate("ngay_sinh");
                String cmnd = rs.getString("so_cmnd");
                Integer gender = rs.getInt("ma_gioi_tinh");
                Long salary = rs.getLong("luong");
                String numberPhone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Integer codePosition = rs.getInt("ma_vi_tri");
                Integer codeLevel = rs.getInt("ma_trinh_do");
                int codeTask = rs.getInt("ma_bo_phan");

                employee = new Employee(crcode, name2, dob, gender, cmnd, numberPhone, email, codeLevel, codePosition, salary, address, codeTask);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int codeEmployee) {
        Connection connection = connectDataBase.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(SQL_DELETE_EMPLOYEE);
            callableStatement.setInt(1, codeEmployee);
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
