import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        Double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("Operator");
        double result = 0.0;
        String str = "Error";

        switch (operator){
            case "+": result = firstOperand + secondOperand;
                break;
            case "-": result = firstOperand - secondOperand;
                break;
            case "*": result = firstOperand * secondOperand;
                break;
            case "/":
                try{
                    if(secondOperand == 0){
                        throw new ArithmeticException("Can't devide zero");
                    }
                    else{
                        result = firstOperand / secondOperand;
                    }
                }
                catch (ArithmeticException e){
                    e.printStackTrace();
                };
                break;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
