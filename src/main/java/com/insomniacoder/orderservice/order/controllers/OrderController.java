package com.insomniacoder.orderservice.order.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final RestTemplate restTemplate;

    private final String PROMOTION_SERVICE_URL = "http://promotion-service/promotion/";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //id = order id
    @SuppressWarnings("unchecked")
    @GetMapping("/{id}/promotion/{promotionCode}")
    @HystrixCommand(fallbackMethod = "getPromotionFallBack")
    public Map<String, String> getPromotion(@PathVariable Long id,
                                            @PathVariable String promotionCode) {

        LOGGER.info("getting promotion for %id", id);

        Object promotion = restTemplate.getForObject(PROMOTION_SERVICE_URL + promotionCode, Object.class);

        HashMap<String, String> response = new HashMap<>();


        response.put("success", "true");
        response.put("message", promotion.toString());
        return response;
    }

    public Map<String, String> getPromotionFallBack(Long id, String promotionCode, Throwable hystrixCommand) {
        String message = hystrixCommand.getMessage();
        LOGGER.info(message);
        HashMap<String, String> response = new HashMap<>();
        response.put("success", "false");
        response.put("message", message);
        return response;
    }


}
