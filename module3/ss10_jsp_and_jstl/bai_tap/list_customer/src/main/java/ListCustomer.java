import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListCustomer", urlPatterns = "")
public class ListCustomer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("Mai Van Hoan", "1983-08-02", "Ha Noi", "https://c.s-microsoft.com/en-us/CMSImages/Surface_Home_Store_AccessibilityHero_Photo_V1.png?version=b0195066-cb63-17ee-eb1d-31a0bff45396");
        customers[1] = new Customer("Nguyen Van Nam", "1983-08-22", "Bac Giang", "https://images.unsplash.com/photo-1653763742809-98f8b759c01e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80");
        customers[2] = new Customer("Nguyen Thai Hoa", "1983-08-20", "Nam Dinh", "https://images.unsplash.com/photo-1653828576037-f7c4d734c6b5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxMnx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60");
        customers[3] = new Customer("Tran Dang Khoa", "1983-08-18", "Ha Tay", "https://images.unsplash.com/photo-1653830107226-c4d29d9497bb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxOHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60");
        customers[4] = new Customer("Nguyen Dinh Thi", "1983-08-19", "Ha Noi", "https://images.unsplash.com/photo-1648737965997-38b0cdf41c94?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwyMXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60");

        request.setAttribute("listcustomer", customers);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
