package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPaymentOnlineRepository extends JpaRepository<PaymentOnline, Integer> {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database with payment id and customer name
     * @param paymentOnlineIdVal
     * @param customerNameVal
     * @param pageable
     * @return
     */
    @Query(value = "SELECT payment_id, discount, note, time_create, po.cart_id\n" +
            "FROM payment_online po\n" +
            "         JOIN cart c ON po.cart_id = c.cart_id\n" +
            "         JOIN customer ct ON c.customer_id = ct.customer_id\n" +
            "WHERE po.payment_id = :payment_id\n" +
            "  AND ct.customer_name LIKE :customer_name", nativeQuery = true)
    Page<PaymentOnline> findPaymentOnlineByIdAndCustomerName(@Param("payment_id") String paymentOnlineIdVal,
                                                             @Param("customer_name") String customerNameVal,
                                                             Pageable pageable);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database of customer have same name of parameter customer name
     * @param customerNameVal
     * @param pageable
     * @return
     */
    @Query(value = "SELECT payment_id, discount, note, time_create, po.cart_id\n" +
            "FROM payment_online po\n" +
            "         JOIN cart c ON po.cart_id = c.cart_id\n" +
            "         JOIN customer ct ON c.customer_id = ct.customer_id\n" +
            "WHERE ct.customer_name LIKE :customer_name", nativeQuery = true)
    Page<PaymentOnline> findAllPaymentOnlineByCustomerName(@Param("customer_name") String customerNameVal, Pageable pageable);
}
