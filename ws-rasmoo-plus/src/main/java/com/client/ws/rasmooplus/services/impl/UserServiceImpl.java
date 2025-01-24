package com.client.ws.rasmooplus.services.impl;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.mapper.UserMapper;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.rasmooplus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserDto userDto) {
        if(Objects.nonNull(userDto.getId())){
            throw new BadRequestException("O id deve ser nulo");
        }
        var userType = userTypeRepository.findById(userDto.getUserTypeId());
        if(userType.isEmpty()){
            throw new BadRequestException("UserType não encontrado");
        }
        UserType userTypeFound = userType.get();
        return userRepository.save(UserMapper.fromDtoToEntity(userDto,userTypeFound,null));



    }


}
