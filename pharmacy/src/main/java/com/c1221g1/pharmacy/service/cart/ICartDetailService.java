package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import org.springframework.validation.BindingResult;

public interface ICartDetailService {
    void checkExistOfLinksObject(CartDetailDto cartDetailDto, BindingResult bindingResult);

    void save(CartDetail cartDetail);

    void updateItemCartDetail(CartDetail cartDetail);
}
