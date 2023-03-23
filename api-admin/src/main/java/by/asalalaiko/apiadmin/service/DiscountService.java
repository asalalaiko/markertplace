package by.asalalaiko.apiadmin.service;

import by.asalalaiko.apiadmin.dto.Discount;

import java.util.List;

public interface DiscountService {

    Discount getDiscount (Integer id);

    boolean addDiscount(Discount discount) ;

    boolean saveDiscount(Discount discount);

    List<Discount> findAllDiscounts();
}
