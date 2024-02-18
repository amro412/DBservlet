package p14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepository repository = ProductRepository.getInstance();
        //ProductRepository repository = new ProductRepository();
        List<Product> products = repository.findProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/Products.jsp").forward(request, response);
    }
}