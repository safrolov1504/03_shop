package geekbrain.Servlents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class Сart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from cart</h1>");
        resp.getWriter().println("<h1>Привет из корзины</h1>");
        resp.getWriter().println("<p>ContextPath = " + req.getContextPath()+"</p>");
        resp.getWriter().println("<p>ServletPath = " + req.getServletPath()+"</p>");
        resp.getWriter().println("<p>ContextPath = " + req.getContextPath()+"</p>");
        resp.getWriter().println("<p>PathInfo = " + req.getPathInfo()+"</p>");
        resp.getWriter().println("<p>Parameters = " + req.getQueryString()+"</p>");

        resp.getWriter().println("<a href = 'hw2/catalog/'>to catalog<a>");
        resp.getWriter().println("<a href = 'hw2/main/'>to main<a>");
        resp.getWriter().println("<a href = 'hw2/order/'>to order<a>");
        resp.getWriter().println("<a href = 'hw2/product/'>to product<a>");
        resp.getWriter().println("<a href = 'hw2/cart/'>to cart<a>");
    }
}
