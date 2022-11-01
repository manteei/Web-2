import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import resposeFormation.ResponseFormator;
import validate.Validator;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        String check = request.getParameter("check");
        ServletContext servletContext = request.getServletContext();
        Validator validate = new Validator();
        ResponseFormator responseFormator = new ResponseFormator();
        ArrayList<String[]> answer;

        if (validate.checkNull(check, x, y, r)) {
            if (validate.checkValue(x, y, r) && check.equals("sendData") || check.equals("sendDot")) {
                if (servletContext.getAttribute("answer")!= null){
                     answer =  (ArrayList<String[]>) servletContext.getAttribute("answer");
                }else{
                     answer = new ArrayList<>();
                }
                answer.add(responseFormator.formation(x, y, r));
                servletContext.setAttribute("answer", answer);

                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/table.jsp");
                requestDispatcher.forward(request, response);
            }else {
                response.sendError(425, "Значение некорректно");
            }
        }else {
            response.sendError(424, "Не хватает переменных");
        }
    }
}