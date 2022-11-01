import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        if (check.equals("sendData") || check.equals("sendDot")){
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        }else if (check.equals("clear")){
            getServletContext().getRequestDispatcher("/ClearServlet").forward(request, response);
        }else {
            response.sendRedirect("/index.jsp");
        }

    }
}