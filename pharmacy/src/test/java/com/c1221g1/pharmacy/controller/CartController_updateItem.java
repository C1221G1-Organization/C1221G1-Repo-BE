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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have quantity field is null.
     * Quantity field is Type of Integer -> can't not test with case 20-21;
     *
     * @throws Exception
     */
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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have quantity negative.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_cartDetailQuantity_22() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(-1);

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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have quantity field large in medicine quantity in database.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_cartDetailQuantity_23() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(3000);

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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have medicine field is null.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_medicine_19() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);
        Medicine medicine = null;
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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have medicine id equal "" .
     *
     * @throws Exception
     */
    @Test
    public void updateItem_medicine_20() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);
        Medicine medicine = new Medicine();
        medicine.setMedicineId("");
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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have medicine id wrong format
     * include min lenght max lenght (21-22-23).
     *
     * @throws Exception
     */
    @Test
    public void updateItem_medicine_21() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);
        Medicine medicine = new Medicine();
        medicine.setMedicineId("ABD-0001");
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

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have cart field is null.
     * cart field is Type of Cart -> can't not test with case 20-21;
     *
     * @throws Exception
     */
    @Test
    public void updateItem_cart_19() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);

        Medicine medicine = new Medicine();
        medicine.setMedicineId("T-0001");
        cartDetailDto.setMedicine(medicine);

        Cart cart = null;

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/carts/{id}", "KH-0001")
                        .content(this.objectMapper.writeValueAsString(cartDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have cart id  is negative.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_cart_22() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);

        Medicine medicine = new Medicine();
        medicine.setMedicineId("T-0001");
        cartDetailDto.setMedicine(medicine);

        Cart cart = new Cart();
        cart.setCartId(-1);
        cartDetailDto.setCart(cart);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/carts/{id}", "KH-0001")
                        .content(this.objectMapper.writeValueAsString(cartDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object have cart id  not in database.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_cart_23() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);

        Medicine medicine = new Medicine();
        medicine.setMedicineId("T-0001");
        cartDetailDto.setMedicine(medicine);

        Cart cart = new Cart();
        cart.setCartId(500);
        cartDetailDto.setCart(cart);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/carts/{id}", "KH-0001")
                        .content(this.objectMapper.writeValueAsString(cartDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: test case update cartDetail object with all item valid.
     *
     * @throws Exception
     */
    @Test
    public void updateItem_24() throws Exception {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setCartDetailQuantity(1);

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
                .andExpect(status().is2xxSuccessful());
    }
}
