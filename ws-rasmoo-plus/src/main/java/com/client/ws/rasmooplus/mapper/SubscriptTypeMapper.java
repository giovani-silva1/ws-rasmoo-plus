package com.client.ws.rasmooplus.mapper;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;

public class SubscriptTypeMapper {

    public static SubscriptionsType fromDtoToEntity(SubscriptionsTypeDto subscriptionsTypeDto){
        return SubscriptionsType.builder()
                .id(subscriptionsTypeDto.getId())
                .name(subscriptionsTypeDto.getName())
                .price(subscriptionsTypeDto.getPrice())
                .accessMonths(subscriptionsTypeDto.getAccessMonths())
                .productKey(subscriptionsTypeDto.getProductKey())
                .build();
    }
}
