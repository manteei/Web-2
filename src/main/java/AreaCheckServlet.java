import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

@WebServlet("/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    LinkedList<String> answer = new LinkedList<>();
    String message;
    String x, y, r;
    String check;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        check = request.getParameter("check");
        x = request.getParameter("x");
        y = request.getParameter("y");
        r = request.getParameter("r");

        if (checkNull()) {
            if (check.equals("clear")) {
                answer = new LinkedList<>();
                servletContext.setAttribute("answer", answer);
                response.sendRedirect("table.html");
            } else {
                if (checkValue() && check.equals("sendData") || check.equals("sendDot")) {
                    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    long startTime = System.nanoTime();
                    checkResult(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r));
                    long timeResponse = (System.nanoTime() - startTime);
                    answer.addFirst("<tr>" +
                            "<td>" + "</td>" +
                            "<td class=\"elementX\">" + x + "</td>" +
                            "<td class=\"elementY\">" + y + "</td>" +
                            "<td class=\"elementR\">" + r + "</td>" +
                            "<td>" + message + "</td>" +
                            "<td>" + timeResponse + " ns" + "</td>" +
                            "<td>" + currentTime + "</td></tr>");
                    servletContext.setAttribute("answer", answer);
                    response.sendRedirect("table.html");
                } else {
                    response.sendError(425, "Значение некорректно");
                }
            }
        } else {
            response.sendError(424, "Не хватает переменных");
        }
    }

    private boolean checkNull() {
        return check != null && !check.trim().equals("") && (x != null && y != null && r != null);
    }

    private boolean checkValueX() {
        try {
            double newX = Double.parseDouble(x);
            return newX >= -5 && newX <= 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean checkValueY() {
        try {
            double newY = Double.parseDouble(y);
            return newY == -3 || newY == -2 || newY == -1 || newY == 0 || newY == 1 || newY == 2 || newY == 3 || newY == 4 || newY == 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean checkValueR() {
        try {
            double newR = Double.parseDouble(r);
            return newR == 1 || newR == 2 || newR == 3 || newR == 4 || newR == 5;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean checkValue() {
        return checkValueX() && checkValueY() && checkValueR();
    }

    private void checkResult(double x, double y, double r) {
        if ((x >= 0 && y >= 0 && x * x + y * y <= r * r) ||
                (x <= 0 && y >= 0 && x >= -r && y <= r) ||
                (x >= 0 && y <= 0 && y >= x - r / 2)) {
            message = "<span style='color: green'>TRUE</span>";
        } else {
            message = "<span style='color: red'>FALSE</span>";
        }
    }

}
