package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartController_updateItem {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateItem_cartDetailQuantity_19() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(null);

        Medicine medicine = new Medicine();
        medicine.setMedicineId("T-0001");
        cartDetailDto.setMedicine(medicine);

        Cart cart = new Cart();
        cart.setCartId(1);
        cartDetailDto.setCart(cart);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/carts/{id}", "KH-0001")
                        .content(this.objectMapper.writeValueAsString(cartDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateItem_cartDetailQuantity_20() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity("");

        Medicine medicine = new Medicine();
        medicine.setMedicineId("T-0001");
        cartDetailDto.setMedicine(medicine);

        Cart cart = new Cart();
        cart.setCartId(1);
        cartDetailDto.setCart(cart);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/carts/{id}", "KH-0001")
                        .content(this.objectMapper.writeValueAsString(cartDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
