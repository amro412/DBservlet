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

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        ProductRepository repository = ProductRepository.getInstance();
        //ProductRepository repository = new ProductRepository();
        if (repository.deleteProduct(productId)) {
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
        }

        ProductDB productDB = new ProductDB();
        productDB.delete(productId);
    }
}
