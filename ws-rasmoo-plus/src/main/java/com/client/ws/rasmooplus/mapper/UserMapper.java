package com.client.ws.rasmooplus.mapper;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto userDto,UserType userType, SubscriptionsType subscriptionsType) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .cpf(userDto.getCpf())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .dtExpiration(userDto.getDtExpiration())
                .dtSubscription(userDto.getDtSubscription())
                .subscriptionsType(subscriptionsType)
                .userType(userType)
                .build();
    }
}
