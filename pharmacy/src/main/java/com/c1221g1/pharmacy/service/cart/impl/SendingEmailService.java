package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.CustomerMailing;
import com.c1221g1.pharmacy.dto.cart.MailModel;
import com.c1221g1.pharmacy.service.cart.ISendingEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendingEmailService implements ISendingEmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;

    @Override
    public void sendEmail(CustomerMailing customerMailing) throws MessagingException, IOException, TemplateException {
        MailModel mailModel = new MailModel();

        Map<String, String> model = new HashMap<>();
        model.put("name", customerMailing.getName());
        model.put("total", customerMailing.getTotal().toString());
        model.put("address", customerMailing.getAddress());
        model.put("phone", customerMailing.getPhone());
        model.put("location", "Đội ngũ C1221G1");
        model.put("signature", "Pharmacode Group");
        model.put("content", "1000.000");

        /**
         * Add below line if you need to create a token to verification emails and uncomment line:32 in "email.ftl"
         * model.put("token",UUID.randomUUID().toString());
         */

        mailModel.setModel(model);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/static/logo.jpg"));

        Template template = emailConfig.getTemplate("email.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailModel.getModel());

        mimeMessageHelper.setTo(customerMailing.getEmail());
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setSubject("Đơn hàng của bạn đã được xác nhận");
        mimeMessageHelper.setFrom("noreply@C12Pharmacy.com");
        emailSender.send(message);

        emailSender.send(message);
    }
}
