package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.Product;
import by.asalalaiko.apiadmin.repository.ProductRepository;
import by.asalalaiko.apiadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JPAProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> userResponse =  productRepository.findById(id);
        Product product = userResponse.get();
        return product;
    }

    @Override
    public boolean addProduct(Product product) {
        Product productFromDb = productRepository.findByName(product.getName());

        if (productFromDb != null) {
            return false;
        }

        saveProduct(product);
        return true;
    }

    @Override
    public boolean saveProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
