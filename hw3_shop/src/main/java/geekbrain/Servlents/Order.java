package geekbrain.Servlents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order", urlPatterns = "/order/*")
public class Order extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ContextPath", ("<p>ContextPath = " + req.getContextPath()+"</p>"));
        req.setAttribute("PathInfo", ("PathInfo = " + req.getPathInfo()));
        req.setAttribute("Parameters", ("Parameters = " + req.getQueryString()));

        getServletContext().getRequestDispatcher("/WEB-INF/order.jsp").forward(req, resp);
    }
}
