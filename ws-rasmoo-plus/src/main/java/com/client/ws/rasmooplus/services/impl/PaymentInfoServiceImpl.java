package com.client.ws.rasmooplus.services.impl;

import com.client.ws.rasmooplus.dto.PaymentProcessDto;
import com.client.ws.rasmooplus.exception.BussinessExceptionException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.services.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class PaymentInfoServiceImpl implements PaymentInfoService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean process(PaymentProcessDto dto) {
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());
        if(userOpt.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        User user = userOpt.get();
        if(Objects.nonNull(user.getSubscriptionsType())){
            throw  new BussinessExceptionException("Pagamento não pode ser processado pois o usuário ja possui assinatura.");
        }

    }
}
