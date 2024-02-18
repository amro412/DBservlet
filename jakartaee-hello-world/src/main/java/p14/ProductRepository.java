package p14;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static ProductRepository instance;
    //private EntityManagerFactory entityManagerFactory;
    private int sequence = 1;

    List<Product> products = new ArrayList<>();

    public ProductRepository() {
        //entityManagerFactory = Persistence.createEntityManagerFactory("sh1");
        products.add(new Product(sequence++, "Product A", 100));
        products.add(new Product(sequence++, "Product B", 150));
        products.add(new Product(sequence++, "Product C", 170));
        products.add(new Product(sequence++, "Product D", 80));
        products.add(new Product(sequence++, "Product E", 120));
        products.add(new Product(sequence++, "Product F", 50));
        products.add(new Product(sequence++, "Product G", 150));
    }

    public static synchronized ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }
    public List<Product> findProducts() {
        return products;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Handle appropriately if the product is not found
    }

    public void addProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
    }

    public boolean deleteProduct(int id) {

        return products.removeIf(p -> p.getId() == id);
    }
}