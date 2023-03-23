package by.asalalaiko.apiadmin.controller;

import by.asalalaiko.apiadmin.dto.Product;
import by.asalalaiko.apiadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Product product) {
        final boolean update = productService.saveProduct(product);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/product/{p_id}/discount/{d_id}")
    public ResponseEntity<Product> addDiscount(@PathVariable(name = "p_id") int pID, @PathVariable(name = "d_id") int dID) {
        final boolean update = productService.addDiscountToProduct(pID, dID);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
