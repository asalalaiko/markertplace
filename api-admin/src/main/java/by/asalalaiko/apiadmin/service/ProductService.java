package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.Product;

import java.util.List;

public interface ProductService {

    Product getProduct (Integer id);

    boolean addProduct(Product product) ;

    boolean saveProduct(Product product);

    List<Product> findAllProducts();

    boolean addDiscountToProduct(Integer pId, Integer dId);
}
