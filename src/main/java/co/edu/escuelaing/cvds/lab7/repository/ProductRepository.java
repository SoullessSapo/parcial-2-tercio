package co.edu.escuelaing.cvds.lab7.repository;


import co.edu.escuelaing.cvds.lab7.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findById(int id);
}
