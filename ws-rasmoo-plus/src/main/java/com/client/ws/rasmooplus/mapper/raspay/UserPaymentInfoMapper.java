package com.client.ws.rasmooplus.mapper.raspay;

import com.client.ws.rasmooplus.dto.UserPaymentInfoDto;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserPaymentInfo;

public class UserPaymentInfoMapper {


    public static UserPaymentInfo fromDtoToEntity(UserPaymentInfoDto dto, User user){
        return UserPaymentInfo.builder()
                .id(dto.getId())
                .user(user)
                .dtPayment(dto.getDtPayment())
                .price(dto.getPrice())
                .cardExpirationMonth(dto.getCardExpirationMonth())
                .cardExpirationYear(dto.getCardExpirationYear())
                .cardSecurityCode(dto.getCardSecurityCode())
                .instalments(dto.getInstalments())
                .cardNumber(dto.getCardNumber())
                .build();
    }
}
