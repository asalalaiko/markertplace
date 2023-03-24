package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.Discount;
import by.asalalaiko.apiadmin.dto.Product;
import by.asalalaiko.apiadmin.repository.DiscountRepository;
import by.asalalaiko.apiadmin.repository.ProductRepository;
import by.asalalaiko.apiadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JPAProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> productResponse =  productRepository.findById(id);
        Product product = productResponse.get();
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

    @Override
    public boolean addDiscountToProduct(Integer pId, Integer dId) {
        Optional<Product> productResponse =  productRepository.findById(pId);
        Product product = productResponse.get();
        Optional<Discount> discountResponse = discountRepository.findById(dId);
        Discount discount = discountResponse.get();
        Set<Discount> discountsProduct = product.getDiscounts();

        if (product != null || discount != null) {
            return false;
        }
        discountsProduct.add(discount);
        product.setDiscounts(discountsProduct);
        saveProduct(product);
        return true;
    }
}
