package by.asalalaiko.apiadmin.service.imp;

import by.asalalaiko.apiadmin.dto.Discount;
import by.asalalaiko.apiadmin.repository.DiscountRepository;
import by.asalalaiko.apiadmin.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPADiscountService implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount getDiscount(Integer id) {
        Optional<Discount> discountResponse =  discountRepository.findById(id);
        Discount discount = discountResponse.get();
        return discount;
    }

    @Override
    public boolean addDiscount(Discount discount) {
        saveDiscount(discount);
        return true;
    }

    @Override
    public boolean saveDiscount(Discount discount) {
        discountRepository.save(discount);
        return true;
    }

    @Override
    public List<Discount> findAllDiscounts() {
        return discountRepository.findAll();
    }
}
