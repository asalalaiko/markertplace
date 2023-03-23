package by.asalalaiko.apiadmin.controller;

import by.asalalaiko.apiadmin.dto.Discount;
import by.asalalaiko.apiadmin.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;


    //Create Discount
    @PostMapping(value = "/discount")
    public ResponseEntity<?> create(@RequestBody Discount discount) {
        final boolean create = discountService.addDiscount(discount);
        return create
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Update Discount
    @PostMapping(value = "/discount/{id}")
    public ResponseEntity<?> create(@PathVariable(name = "id") int id, @RequestBody Discount discount) {
        final boolean update = discountService.addDiscount(discount);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
