import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    String check;
    String x;
    String y;
    String r;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check = req.getParameter("check");
        x = req.getParameter("x");
        y = req.getParameter("y");
        r = req.getParameter("r");

        if (checkNull()) {
            if (check.equals("clear") || check.equals("sendData") || check.equals("sendDot")){
                req.getRequestDispatcher("/AreaCheckServlet").forward(req, resp);
            }else {
                resp.sendRedirect("upload.jsp");
            }
        }else {
            resp.sendError(422, "Неполный запрос!");
        }
    }

    private boolean checkNull() {
        return check != null && !check.trim().equals("") && (x != null && y != null && r != null) && (!x.trim().equals("")
                && !y.trim().equals("") && !r.trim().equals(""));
    }
}

