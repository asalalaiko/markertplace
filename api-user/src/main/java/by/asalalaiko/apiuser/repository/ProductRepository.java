package by.asalalaiko.apiuser.repository;

import by.asalalaiko.apiuser.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
