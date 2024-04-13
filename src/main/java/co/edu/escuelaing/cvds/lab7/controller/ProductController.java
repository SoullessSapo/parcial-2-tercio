package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.service.ProductService;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id){
        return this.productService.getProductById(id);
    }
    @PostMapping("/addProduct")
    public void createProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(Integer.parseInt(id), updatedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(Integer.parseInt(id));
    }
    @PatchMapping("/update-Partial/{id}")
    public Product updateProductPatch(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(Integer.parseInt(id), updatedProduct);
    }

}
