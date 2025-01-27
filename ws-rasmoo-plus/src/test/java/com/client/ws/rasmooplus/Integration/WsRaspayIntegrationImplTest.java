package com.client.ws.rasmooplus.Integration;

import com.client.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.client.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.integration.impl.WsRaspayIntegrationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCustomerWhenDtoOk(){
        CustomerDto dto = new CustomerDto(null,"Miguel","Silva","miguelCod@live.com","03804989012");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDtoOk(){
        OrderDto dto = new OrderDto(null,"6797fda4f8a22d53fca23ea4","MONTH22",BigDecimal.ZERO);
        wsRaspayIntegration.createOrder(dto);
    }


    @Test
    void createPaymentWhenDtoOk(){
        CreditCardDto creditCardDto = new CreditCardDto("1234",132L,6L,2024L,"23499009981",2L);
        PaymentDto dto = new PaymentDto("6797fda4f8a22d53fca23ea4","679812d0f8a22d53fca23ea8",creditCardDto);
        wsRaspayIntegration.processPayment(dto);
    }
}
