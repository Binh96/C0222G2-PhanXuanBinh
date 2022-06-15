package management.controller;

import management.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import management.service.CustomerService;
import management.service.CustomerServiceFactory;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class CustomerController extends HttpServlet {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/view")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "view/list.jsp";
    }
}
