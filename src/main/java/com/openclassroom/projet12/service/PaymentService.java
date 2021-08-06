package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.PaymentDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    public String createPrice(PaymentDTO paymentDTO) throws StripeException {
        Stripe.apiKey = "sk_test_51JCoGrIvqpPoFOLayuamObwJQ9Dd3Uk4ydvclTT6ToVeMKYWL7HqSjL6MjF8dqOlbQgEDqfUq5JUFlAHqTnDIGlr00b4Pe5Zbw";
        Map<String, Object> productParams = new HashMap<>();
        productParams.put("name", paymentDTO.getProductName());
        Product product = Product.create(productParams);
        Map<String, Object> params = new HashMap<>();
        params.put("unit_amount", paymentDTO.getPrice());
        params.put("currency", "eur");
        params.put("product", product.getId());
        Price price = Price.create(params);
        return price.getId();
    }
}
