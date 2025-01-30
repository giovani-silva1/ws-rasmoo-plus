package com.client.ws.rasmooplus.services.impl;

import com.client.ws.rasmooplus.dto.PaymentProcessDto;
import com.client.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.client.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.client.ws.rasmooplus.exception.BussinessExceptionException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.integration.MailIntegration;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.mapper.raspay.*;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserPaymentInfo;
import com.client.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.services.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPaymentInfoRepository userPaymentInfoRepository;

    @Autowired
    private  WsRaspayIntegration wsRaspayIntegration;

    @Autowired
    private MailIntegration mailIntegration;

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
        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(),dto));
        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(),orderDto.getId(), CreditCardMapper.build(dto.getUserPaymentInfoDto(),user.getCpf()));

        Boolean sucess_Payment = wsRaspayIntegration.processPayment(paymentDto);
        if(sucess_Payment){
            UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(),user);
            userPaymentInfoRepository.save(userPaymentInfo);
            mailIntegration.send(user.getEmail(),"Usuário: " + user.getEmail()  + " Senha: alunorasmoo","ACESSO LIBERADO");
            return true;
        }

        return false;



    }
}
