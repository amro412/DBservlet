package p14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product(0, name, price);
        ProductRepository repository = ProductRepository.getInstance();
        //ProductRepository repository = new ProductRepository();
        repository.addProduct(product);

        response.sendRedirect(request.getContextPath() + "/products");

        ProductDB productDB = new ProductDB();
        productDB.insert(product);
    }
}