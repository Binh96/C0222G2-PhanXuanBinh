import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/translate")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("how", "the nao");
        dictionary.put("book", "sach");
        dictionary.put("computer", "may tinh");

        PrintWriter printWriter = response.getWriter();
        String search = request.getParameter("eng");
        String result = dictionary.get(search);

        if(result != null){
            request.setAttribute("word", result);
        }
        else{
            request.setAttribute("word", "not found");
        }

        request.getRequestDispatcher("translate.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
