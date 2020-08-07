package geekbrain.Servlents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "about", urlPatterns = "/about/*")
public class About extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("ContextPath", ("ContextPath = " + req.getContextPath()));
        req.setAttribute("PathInfo", ("PathInfo = " + req.getPathInfo()));
        req.setAttribute("Parameters", ("Parameters = " + req.getQueryString()));

        getServletContext().getRequestDispatcher("/WEB-INF/about.jsp").forward(req, resp);
    }
}
