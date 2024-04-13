package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;
import org.springframework.stereotype.Service;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    public List<Product> getAllProducts() {return productRepository.findAll();}

    public Product updateProduct(int id, Product updatedProduct){
        Product product = productRepository.findById(id);
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());
        productRepository.save(product);
        return product;
    }

    public Product getProductById(String id) {
        return productRepository.findById(Integer.parseInt(id));
    }
}
