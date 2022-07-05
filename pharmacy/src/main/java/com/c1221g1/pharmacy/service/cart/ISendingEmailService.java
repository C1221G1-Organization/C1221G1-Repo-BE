package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CustomerMailing;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ISendingEmailService {

    void sendEmail(CustomerMailing customerMailing) throws MessagingException, IOException, TemplateException;
}
