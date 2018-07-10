package com.insomniacoder.orderservice.order.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    private final RestTemplate restTemplate;

    private final String PROMOTION_SERVICE_URL = "http://promotion-service/promotion";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //id = order id
    @SuppressWarnings("unchecked")
    @GetMapping("/{id}/promotion/{promotionCode}")
    public Map<String, String> getPromotion(@PathVariable Long id,
                                            @PathVariable String promotionCode) {
        return restTemplate.getForObject(PROMOTION_SERVICE_URL + promotionCode, Map.class);
    }
}
