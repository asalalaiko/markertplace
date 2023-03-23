package by.asalalaiko.apiadmin.repository;

import by.asalalaiko.apiadmin.dto.Discount;
import by.asalalaiko.apiadmin.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

}
