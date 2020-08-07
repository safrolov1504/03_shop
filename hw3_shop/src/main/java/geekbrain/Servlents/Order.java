package geekbrain.Servlents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order", urlPatterns = "/order")
public class Order extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from order</h1>");
        resp.getWriter().println("<h1>Привет из заказов</h1>");
        resp.getWriter().println("<p>ContextPath = " + req.getContextPath()+"</p>");
        resp.getWriter().println("<p>ServletPath = " + req.getServletPath()+"</p>");
        resp.getWriter().println("<p>ContextPath = " + req.getContextPath()+"</p>");
        resp.getWriter().println("<p>PathInfo = " + req.getPathInfo()+"</p>");
        resp.getWriter().println("<p>Parameters = " + req.getQueryString()+"</p>");

        resp.getWriter().println("<a href = 'catalog'>to catalog<a>");
        resp.getWriter().println("<a href = 'main'>to main<a>");
        resp.getWriter().println("<a href = 'order'>to order<a>");
        resp.getWriter().println("<a href = 'product'>to product<a>");
        resp.getWriter().println("<a href = 'cart'>to cart<a>");
    }
}
