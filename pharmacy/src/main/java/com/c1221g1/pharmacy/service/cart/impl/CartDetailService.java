package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.cart.ICartDetailRepository;
import com.c1221g1.pharmacy.repository.cart.ICartRepository;
import com.c1221g1.pharmacy.service.cart.ICartDetailService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class CartDetailService implements ICartDetailService {
    @Autowired
    private ICartDetailRepository iCartDetailRepository;

    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private IMedicineService iMedicineService;

    /**
     * Created by: KhoaPV
     * Date created: 28/6/2022
     * function: check exist of cart and medicine object. if not exist then add error into bindingResult
     *
     * @param cartDetailDto
     * @param bindingResult
     */
    @Override
    public void checkExistOfLinksObject(CartDetailDto cartDetailDto, BindingResult bindingResult) {
        Cart cart = this.iCartRepository.findCartById(cartDetailDto.getCart().getCartId(), false);
        if (cart == null) {
            bindingResult.rejectValue("cart", "cart.notfound");
        }
        Medicine medicine = this.iMedicineService.findMedicineById(cartDetailDto.getMedicine().getMedicineId()).orElse(null);
        if (medicine == null) {
            bindingResult.rejectValue("medicine", "medicine.notfound");
        }
    }

    @Override
    public void save(CartDetail cartDetail) {

    }

    @Override
    public void updateItemCartDetail(CartDetail cartDetail) {

    }
}
