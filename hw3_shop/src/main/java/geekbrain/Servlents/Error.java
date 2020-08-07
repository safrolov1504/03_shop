package geekbrain.Servlents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "error", urlPatterns = "/error")
public class Error extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Error</h1>");
        resp.getWriter().println("<h1>Ошибка</h1>");

        resp.getWriter().println("<a href = 'catalog'>to catalog<a>");
        resp.getWriter().println("<a href = 'main'>to main<a>");
        resp.getWriter().println("<a href = 'order'>to order<a>");
        resp.getWriter().println("<a href = 'product'>to product<a>");
        resp.getWriter().println("<a href = 'cart'>to cart<a>");
    }

}
