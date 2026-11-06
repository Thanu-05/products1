package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;
    // activity3 , task10
    public ProductService() {

        // Add DigitalProduct
        products.add(new DigitalProduct(
                1L, "Java Ebook", 500.0,
                "https://example.com/java.pdf", 15.5
        ));

        // Add PhysicalProduct
        products.add(new PhysicalProduct(
                2L, "Laptop", 150000.0,
                2.5, "35x25x2 cm"
        ));

        nextId = 3L;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products) {
            summaries.add(p.getSummary());
        }
        return summaries;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
