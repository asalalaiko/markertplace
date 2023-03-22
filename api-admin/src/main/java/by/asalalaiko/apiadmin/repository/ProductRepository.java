package by.asalalaiko.apiadmin.repository;

import by.asalalaiko.apiadmin.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
