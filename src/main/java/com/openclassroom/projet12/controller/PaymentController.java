package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.PaymentDTO;
import com.openclassroom.projet12.dto.PayementSessionDTO;
import com.openclassroom.projet12.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/checkout")
    public PayementSessionDTO checkout(@RequestBody PaymentDTO paymentDTO) throws StripeException {
        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");
        List<Object> lineItems = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("price", paymentService.createPrice(paymentDTO));
        item.put("quantity", paymentDTO.getQuantity());
        lineItems.add(item);
        Map<String, Object> params = new HashMap<>();
        params.put("success_url", "http://localhost:4200/api/order/payment/success?order=" + paymentDTO.getProductName());
        params.put("cancel_url", "http://localhost:4200/api/order/payment/failure?order=" + paymentDTO.getProductName());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("line_items", lineItems);
        params.put("mode", "payment");
        Session session = Session.create(params);
        return PayementSessionDTO.builder()
                .sessionId(session.getId())
                .build();
    }

}
