package controller;

import Model.Customer;
import Model.Employee;
import service.impl.ICustomerServiceImpl;
import service.impl.IEmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", urlPatterns = "")
public class FuramaServlet extends HttpServlet {
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();
    IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "search":
                search(request, response);
                break;
            default:
                homePage(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "contract":
                break;
            case "service":
                showPageService(request, response);
                break;
            case "customer":
                showPageCustomer(request, response);
                break;
            case "employee": {
                showPageEmployee(request, response);
                break;
            }
            default:
                homePage(request, response);
                break;
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/interface/index.jsp").forward(request, response);
    }

    private void showPageEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("/employee");
    }

    private void showPageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("/customer");
    }

    private void showPageService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("/service");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("search");
        Customer customer = customerService.findByName(name);
        Employee employee = employeeService.findEmployeeByName(name);
        if(customer != null){
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("interface/search.jsp").forward(request,response);
        }

        if(employee!=null){
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("interface/search.jsp").forward(request,response);
        }
    }

}
