import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "TimeSystem", urlPatterns = "/index.jsp")
public class TimeSystem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Date date = new Date();
        printWriter.write("<html>");
        printWriter.write("<body>");
        printWriter.write("<h2>" + date + "</h2>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
