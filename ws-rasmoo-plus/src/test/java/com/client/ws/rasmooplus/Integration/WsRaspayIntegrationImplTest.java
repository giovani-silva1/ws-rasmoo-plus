package com.client.ws.rasmooplus.Integration;

import com.client.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.integration.impl.WsRaspayIntegrationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCusterWhenDtoOk(){
        CustomerDto dto = new CustomerDto(null,"Miguel","Silva","miguelCod@live.com","03804989012");
        wsRaspayIntegration.createCustomer(dto);
    }
}
