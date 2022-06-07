package controller;

import Model.*;
import Model.model.*;
import service.impl.*;
import service.utils.validate.MyDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();
    IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                showPageEmployee(request, response);
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
                showPageListEmployee(request, response);
                break;
            case "add":
                showPageAddEmployee(request, response);
                break;
            case "update":
                showPageUpdateEmployee(request, response);
                break;
            case "delete":
                showPageDelete(request, response);
                break;
            case "detail":
                break;
            default:
                showPageEmployee(request, response);
                break;
        }
    }

    private void showPageEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("title", "Employees");
        request.getRequestDispatcher("/employee/employee.jsp").forward(request, response);
    }

    private void showPageListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        IGenderServiceImpl genderService = new IGenderServiceImpl();
        IPositionServiceImpl positionService = new IPositionServiceImpl();
        IDivisionServiceImpl divisionService = new IDivisionServiceImpl();

        List<Employee> employees = employeeService.selectAll();
        List<Gender> genders = genderService.findAllGender();
        List<Position> positions = positionService.findAllPosition();
        List<Division> divisions = divisionService.findAllDivision();

        request.setAttribute("division", divisions);
        request.setAttribute("genders", genders);
        request.setAttribute("positions", positions);
        request.setAttribute("title", "Employees");
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    private void showPageAddEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ILevelServiceImpl levelService = new ILevelServiceImpl();
        IPositionServiceImpl positionService = new IPositionServiceImpl();
        IDivisionServiceImpl divisionService = new IDivisionServiceImpl();
        IGenderServiceImpl genderService  = new IGenderServiceImpl();

        List<Gender> genders = genderService.findAllGender();
        List<Position> positions = positionService.findAllPosition();
        List<Division> divisions = divisionService.findAllDivision();
        List<Level> levels = levelService.findAllLevel();


        request.setAttribute("genders", genders);
        request.setAttribute("title", "Employees");
        request.setAttribute("division", divisions);
        request.setAttribute("positions", positions);
        request.setAttribute("levels", levels);
        request.getRequestDispatcher("/employee/add.jsp").forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Date dob = MyDateFormat.covertDate(request.getParameter("dob"));
        String id = request.getParameter("id");
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        Integer level = Integer.parseInt(request.getParameter("level"));
        Integer position = Integer.parseInt(request.getParameter("position"));
        Long salary = Long.parseLong(request.getParameter("salary"));
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        Integer codeTask = Integer.parseInt(request.getParameter("task"));
        String address = request.getParameter("address");
        employeeService.addEmployee(name, dob, id, gender, salary, numberPhone, email, address, position, level, codeTask);

        request.setAttribute("title", "Employees");
        request.getRequestDispatcher("/employee/add.jsp").forward(request, response);
    }

    private void showPageUpdateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();
        IGenderServiceImpl genderService = new IGenderServiceImpl();
        ILevelServiceImpl levelService = new ILevelServiceImpl();
        IPositionServiceImpl positionService = new IPositionServiceImpl();
        IDivisionServiceImpl divisionService = new IDivisionServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findEmployeeById(id);

        List<Gender> genders = genderService.findAllGender();
        List<Position> positions = positionService.findAllPosition();
        List<Division> divisions = divisionService.findAllDivision();
        List<Level> levels = levelService.findAllLevel();

        request.setAttribute("employee", employee);
        request.setAttribute("title", "Employees");
        request.setAttribute("division", divisions);
        request.setAttribute("genders", genders);
        request.setAttribute("positions", positions);
        request.setAttribute("levels", levels);

        request.getRequestDispatcher("/employee/formEdit.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int crCode = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dob = MyDateFormat.covertDate(request.getParameter("dob"));
        String id = request.getParameter("id");
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        Integer level = Integer.parseInt(request.getParameter("level"));
        Integer position = Integer.parseInt(request.getParameter("position"));
        Long salary = Long.parseLong(request.getParameter("salary"));
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        Integer codeTask = Integer.parseInt(request.getParameter("task"));
        String address = request.getParameter("address");

        Employee employee = new Employee(name, gender, dob, id, salary, numberPhone,
                email, address, position, level, codeTask);

        employeeService.updateEmployee(crCode, employee);
        request.setAttribute("title", "Employees");
        request.getRequestDispatcher("/employee/formEdit.jsp").forward(request, response);
    }

    private void showPageDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();
        IGenderServiceImpl genderService = new IGenderServiceImpl();
        ILevelServiceImpl levelService = new ILevelServiceImpl();
        IPositionServiceImpl positionService = new IPositionServiceImpl();
        IDivisionServiceImpl divisionService = new IDivisionServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findEmployeeById(id);

        List<Gender> genders = genderService.findAllGender();
        List<Position> positions = positionService.findAllPosition();
        List<Division> divisions = divisionService.findAllDivision();
        List<Level> levels = levelService.findAllLevel();

        request.setAttribute("employee", employee);
        request.setAttribute("title", "Employees");
        request.setAttribute("division", divisions);
        request.setAttribute("genders", genders);
        request.setAttribute("positions", positions);
        request.setAttribute("levels", levels);

        request.getRequestDispatcher("/employee/delete.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int crCode = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(crCode);
        response.sendRedirect("/employee/list.jsp");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("search");
        Customer customer = customerService.findByName(name);
        Employee employee = employeeService.findEmployeeByName(name);
        if(customer != null){
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/employee/search.jsp").forward(request,response);
        }

        if(employee!=null){
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/employee/search.jsp").forward(request,response);
        }
    }
}
