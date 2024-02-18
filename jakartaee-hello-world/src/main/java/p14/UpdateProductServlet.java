package p14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        ProductRepository repository = ProductRepository.getInstance();
        //ProductRepository repository = new ProductRepository();
        Product product = repository.findProducts().stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);

        request.setAttribute("product", product);
        request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("name");
        double productPrice = Double.parseDouble(request.getParameter("price"));

        ProductRepository repository = ProductRepository.getInstance();

        Product existingProduct = repository.findProductById(productId);

        if (existingProduct == null) {

            response.sendRedirect(request.getContextPath() + "/UpdateProduct.jsp?error=Product not found");
            return;
        }

        existingProduct.setName(productName);
        existingProduct.setPrice(productPrice);

        response.sendRedirect(request.getContextPath() + "/products");

        Product product= new Product(0, productName, productPrice);
        ProductDB productDB = new ProductDB();
        productDB.update(product);


    }
}