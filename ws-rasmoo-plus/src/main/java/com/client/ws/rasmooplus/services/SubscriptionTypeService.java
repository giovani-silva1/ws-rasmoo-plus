package com.client.ws.rasmooplus.services;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeService {

    @Autowired
    private SubscriptionsTypeRepository subscriptionsTypeRepository;


    public List<SubscriptionsType> findAll(){
        return  subscriptionsTypeRepository.findAll();

    }
}
