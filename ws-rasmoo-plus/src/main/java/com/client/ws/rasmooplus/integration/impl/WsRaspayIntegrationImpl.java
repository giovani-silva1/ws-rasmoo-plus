package com.client.ws.rasmooplus.integration.impl;

import com.client.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;

    private final HttpHeaders headers;

    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
    }


    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try{
            String credentials ="rasmooplus:r@sm00";
            String base64 = new String ( Base64.encodeBase64(credentials.getBytes()));
            headers.add("Authorization","Basic "+base64);
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto,headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("http://localhost:8082/ws-raspay/v1/customer", HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (Exception e ) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try{
            String credentials ="rasmooplus:r@sm00";
            String base64 = new String ( Base64.encodeBase64(credentials.getBytes()));
            headers.add("Authorization","Basic "+base64);
            HttpEntity<OrderDto> request = new HttpEntity<>(dto,headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange("http://localhost:8082/ws-raspay/v1/order", HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (Exception e ) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try{
            String credentials ="rasmooplus:r@sm00";
            String base64 = new String ( Base64.encodeBase64(credentials.getBytes()));
            headers.add("Authorization","Basic "+base64);
            HttpEntity<PaymentDto> request = new HttpEntity<>(dto,headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange("http://localhost:8082/ws-raspay/v1/payment/credit-card/", HttpMethod.POST, request, Boolean.class);
            return response.getBody();
        } catch (Exception e ) {
            throw new RuntimeException(e);
        }
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credentials ="rasmooplus:r@sm00";
        String base64 = new String ( Base64.encodeBase64(credentials.getBytes()));
        headers.add("Authorization","Basic "+base64);
        return headers;
    }
}
