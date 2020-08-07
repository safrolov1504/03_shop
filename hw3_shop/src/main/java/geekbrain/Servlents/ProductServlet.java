package geekbrain.Servlents;

import geekbrain.products.Product;
import geekbrain.products.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "ProductControllerServlet", urlPatterns = {"/product/*"})
public class ProductServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        if (productRepository == null) {
            throw new ServletException("Product repository not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<p>contextPath = " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath = " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo = " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString = " + req.getQueryString() + "</p>");

        if(req.getPathInfo() == null){
            try {
                req.setAttribute("products", productRepository.findAll());
                getServletContext().getRequestDispatcher("/WEB-INF/products.jsp").forward(req,resp);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        } else if (req.getPathInfo().equals("/new")) {
            logger.info("Add a new");
            req.setAttribute("product", new Product());
            getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/edit")) {
            String id = req.getParameter("id");
            try {
                Optional<Product> opt = productRepository.findById(Long.parseLong(id));
                if (opt.isPresent()) {
                    req.setAttribute("product", opt.get());
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }
            } catch (SQLException ex) {
                throw new IllegalStateException(ex);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getPathInfo().equals("/upsert")) {
            try {
                String strId = req.getParameter("id");
                if (strId.isEmpty()) {
                    productRepository.insert(new Product(-1L,
                            req.getParameter("name"),
                            req.getParameter("description"),
                            null));
                } else {
                    productRepository.update(new Product(Long.parseLong(strId),
                            req.getParameter("name"),
                            req.getParameter("description"),
                            null));
                }
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (SQLException ex) {
                throw new IllegalStateException(ex);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
