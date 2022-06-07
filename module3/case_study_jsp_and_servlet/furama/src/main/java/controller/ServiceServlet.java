package controller;

import Model.model.*;
import Model.repository.impl.ITypeOfRentRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();
    IEmployeeServiceImpl employeeService = new IEmployeeServiceImpl();


    IServiceImpl serviceImpl = new IServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addService(request, response);
            case "update":
                updateService(request, response);
                break;
            case "delete":
                deleteService(request, response);
            case "search":
                search(request, response);
                break;
            default:
                showPageService(request, response);
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
                showPageListService(request, response);
                break;
            case "search":
                break;
            case "add":
                showPageAddService(request, response);
                break;
            case "update":
                showPageUpdateService(request, response);
                break;
            case "delete": {
                showPageDeleteService(request, response);
                break;
            }
            default:
                showPageService(request, response);
                break;
        }
    }

    private void showPageService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/service/service.jsp").forward(request, response);
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

    private void showPageAddService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ITypeOfRentServiceImpl typeOfRentService = new ITypeOfRentServiceImpl();
        ITypeOfServiceImpl iTypeOfService = new ITypeOfServiceImpl();
        List<TypeOfRent> typeOfRents = typeOfRentService.selectAll();
        List<TypeOfService> typeOfServices = iTypeOfService.selectAll();

        request.setAttribute("typeOfRent", typeOfRents);
        request.setAttribute("typeServices", typeOfServices);
        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/insert.jsp").forward(request,response);
    }

    private void showPageListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ITypeOfRentServiceImpl typeOfRentService = new ITypeOfRentServiceImpl();
        ITypeOfServiceImpl iTypeOfService = new ITypeOfServiceImpl();
        List<TypeOfRent> typeOfRents = typeOfRentService.selectAll();
        List<TypeOfService> typeOfServices = iTypeOfService.selectAll();
        List<Service> services = serviceImpl.selectAllService();

        request.setAttribute("services", services);
        request.setAttribute("typeOfRent", typeOfRents);
        request.setAttribute("typeServices", typeOfServices);
        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }

    private void showPageUpdateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ITypeOfRentServiceImpl typeOfRentService = new ITypeOfRentServiceImpl();
        ITypeOfServiceImpl iTypeOfService = new ITypeOfServiceImpl();
        Service service = serviceImpl.findServiceById(Integer.parseInt(request.getParameter("id")));
        List<TypeOfRent> typeOfRents = typeOfRentService.selectAll();
        List<TypeOfService> typeOfServices = iTypeOfService.selectAll();

        request.setAttribute("service", service);
        request.setAttribute("typeOfRents", typeOfRents);
        request.setAttribute("typeOfServices", typeOfServices);
        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/update.jsp").forward(request,response);
    }

    private void showPageDeleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ITypeOfRentServiceImpl typeOfRentService = new ITypeOfRentServiceImpl();
        ITypeOfServiceImpl iTypeOfService = new ITypeOfServiceImpl();
        Service service = serviceImpl.findServiceById(Integer.parseInt(request.getParameter("id")));
        List<TypeOfRent> typeOfRents = typeOfRentService.selectAll();
        List<TypeOfService> typeOfServices = iTypeOfService.selectAll();

        request.setAttribute("service", service);
        request.setAttribute("typeOfRents", typeOfRents);
        request.setAttribute("typeOfServices", typeOfServices);
        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/delete.jsp").forward(request,response);
    }

    private void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("feeRent"));
        Integer maxPerson = Integer.parseInt(request.getParameter("maxPerson"));
        String standard = request.getParameter("standard");
        String desc = request.getParameter("anotherDesc");
        Double areaPool = Double.parseDouble(request.getParameter("areaPool"));
        Integer numFloor = Integer.parseInt(request.getParameter("numFloor"));
        Integer typeRent = Integer.parseInt(request.getParameter("typeOfRents"));
        Integer codeTypeServices = Integer.parseInt(request.getParameter("codeTypeServices"));

        Service service = new Service(name, area, cost, maxPerson, standard, desc, areaPool, numFloor, typeRent, codeTypeServices);

        serviceImpl.insertService(service);
        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/service.jsp").forward(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("cost"));
        Integer max = Integer.parseInt(request.getParameter("maxPerson"));
        String standard = request.getParameter("standard");
        String desc = request.getParameter("anotherDesc");
        Double areaPool = Double.parseDouble(request.getParameter("areaPool"));
        Integer numFloor = Integer.parseInt(request.getParameter("numFloor"));
        Integer typeRent = Integer.parseInt(request.getParameter("typeOfRents"));
        Integer codeTypeServices = Integer.parseInt(request.getParameter("codeTypeServices"));
        Service service = new Service(name, area, cost, max, standard, desc, areaPool, numFloor, typeRent, codeTypeServices);
        serviceImpl.updateService(id, service);

        request.setAttribute("title", "Service");
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        serviceImpl.deleteService(id);
        request.getRequestDispatcher("/service/list.jsp").forward(request,response);
    }

}
