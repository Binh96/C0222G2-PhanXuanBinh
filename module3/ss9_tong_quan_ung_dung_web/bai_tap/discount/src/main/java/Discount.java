import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Discount", value = "/display-discount.html")
public class Discount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double price = Double.parseDouble(req.getParameter("listprice"));
        double percent = Double.parseDouble(req.getParameter("discountpercent"));
        String name = req.getParameter("productdesc");

        PrintWriter writer = resp.getWriter();
        double result = price * percent *0.01;
        double priceAfterDiscount = result - price;
        writer.println("<html>");
        writer.println("<h1>Discount Amount: "+ result+"</h1>");
        writer.println("<h1>Discount Price: "+ priceAfterDiscount +"</h1>");
        writer.println("</html>");
    }
}
