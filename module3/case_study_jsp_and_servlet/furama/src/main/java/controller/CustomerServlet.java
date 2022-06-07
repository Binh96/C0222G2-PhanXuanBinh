package controller;

import Model.Customer;
import Model.Employee;
import Model.Gender;
import Model.TypeOfCustomer;
import service.impl.ICustomerServiceImpl;
import service.impl.ICustomerTypeServiceImpl;
import service.impl.IEmployeeServiceImpl;
import service.impl.IGenderServiceImpl;
import service.utils.validate.MyDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();
    ICustomerTypeServiceImpl customerTypeService = new ICustomerTypeServiceImpl();
    IGenderServiceImpl genderService = new IGenderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addNewCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showPageCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "list":
                showListCustomer(request, response);
                break;
            case "add":
                showAddPageCustomer(request, response);
                break;
            case "update":
                showUpdatePageCustomer(request, response);
                break;
            case "delete":
                showDeletePageCustomer(request, response);
                break;
            case "detail":
                break;
            default:
                showPageCustomer(request, response);
                break;
        }
    }

    private void showPageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/customer/customer.jsp").forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Customer> customers = customerService.selectAll();
        List<TypeOfCustomer> typeOfCustomers = customerTypeService.selectAll();

        request.setAttribute("customers", customers);
        request.setAttribute("customerType", typeOfCustomers);
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }

    private void showAddPageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Gender> genders = genderService.findAllGender();
        List<TypeOfCustomer> typeOfCustomers = customerTypeService.selectAll();

        request.setAttribute("genders", genders);
        request.setAttribute("customerTypes", typeOfCustomers);
        request.getRequestDispatcher("/customer/addNewCustomer.jsp").forward(request, response);
    }

    private void showDeletePageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Gender> genders = genderService.findAllGender();
        List<TypeOfCustomer> typeOfCustomers = customerTypeService.selectAll();
        Customer customer = customerService.findById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("customer", customer);
        request.setAttribute("genders", genders);
        request.setAttribute("customerTypes", typeOfCustomers);
        request.getRequestDispatcher("/customer/delete.jsp").forward(request, response);
    }

    private void showUpdatePageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Gender> genders = genderService.findAllGender();
        List<TypeOfCustomer> typeOfCustomers = customerTypeService.selectAll();
        Customer customer = customerService.findById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("customer", customer);
        request.setAttribute("genders", genders);
        request.setAttribute("customerTypes", typeOfCustomers);
        request.getRequestDispatcher("/customer/update.jsp").forward(request, response);
    }


    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Date dob = MyDateFormat.covertDate(request.getParameter("dob"));
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("id");
        String numberPhone = request.getParameter("numberPhone");
        String email  = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerType = Integer.parseInt(request.getParameter("customerType"));

        customerService.insertCustomer(new Customer(name, dob, gender, cmnd, numberPhone, email, address, customerType));

        response.sendRedirect("customer?action=list");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        customerService.deleteCustomer(Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int customerCode = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        Date dob = MyDateFormat.covertDate(request.getParameter("dob"));
        String id = request.getParameter("cmnd");
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        Integer customerType = Integer.parseInt(request.getParameter("customerType"));

        customerService.updateCustomer(customerCode, new Customer(name, dob, gender, id, numberPhone, email, address, customerType));
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("search");
        Customer customer = customerService.findByName(name);
        Employee employee = employeeService.findEmployeeByName(name);
        if(customer != null){
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/interface/search.jsp").forward(request,response);
        }

        if(employee!=null){
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/interface/search.jsp").forward(request,response);
        }
    }
}
