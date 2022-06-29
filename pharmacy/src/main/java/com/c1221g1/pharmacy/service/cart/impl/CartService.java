package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.cart.ICartRepository;
import com.c1221g1.pharmacy.service.cart.ICartService;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private IMedicineService iMedicineService;

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: finding cart object have status false (incomplete) with customer id
     *
     * @param customerId
     * @return
     */
    @Override
    public Cart findCartByCustomerId(String customerId) {
        return this.iCartRepository.findCartByCustomerId(customerId, false);
    }

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: call repository to save cart object into database
     *
     * @param cart
     */
    @Override
    public void save(Cart cart) {
        cart.setCartStatus(false);
        cart.setDateCreate(LocalDate.now().toString());
        this.iCartRepository.saveCart(cart);
    }

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: check exist of cart and medicine object. if not exist then add error into bindingResult
     *
     * @param cartDetailDto
     */
    @Override
    public void checkExistOfLinksObject(CartDetailDto cartDetailDto, BindingResult bindingResult) {
        Cart cart = this.iCartRepository.findCartById(cartDetailDto.getCart().getCartId(), false);
        if (cart == null) {
            bindingResult.rejectValue("cart", "cart.notfound");
        }
        Medicine medicine = this.iMedicineService.findMedicineById(cartDetailDto.getMedicine().getMedicineId());
        if (medicine == null) {
            bindingResult.rejectValue("medicine", "medicine.notfound");
        }
    }
}
