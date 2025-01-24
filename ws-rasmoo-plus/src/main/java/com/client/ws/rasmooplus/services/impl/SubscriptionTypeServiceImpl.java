package com.client.ws.rasmooplus.services.impl;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionsTypeRepository;
import com.client.ws.rasmooplus.services.SubscriptionTypeService;
import com.client.ws.rasmooplus.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl  implements SubscriptionTypeService {

    @Autowired
    private SubscriptionsTypeRepository subscriptionsTypeRepository;

    @Override
    public List<SubscriptionsType> findAll() {
        return subscriptionsTypeRepository.findAll();
    }

    @Override
    public SubscriptionsType findById(Long id) {
        Optional<SubscriptionsType> subscriptionsTypeFound = subscriptionsTypeRepository.findById(id);
        if(subscriptionsTypeFound.isEmpty()){
            throw new NotFoundException("Objeto não encontrado para o ID" + id + " informado");
        }
        return subscriptionsTypeFound.get();

    }

    @Override
    public SubscriptionsType create(SubscriptionsType subscriptionsType) {
        SubscriptionsType subscriptionsTypeCreated = new SubscriptionsType(null,subscriptionsType.getName(),subscriptionsType.getAccessMonths(),subscriptionsType.getPrice(),subscriptionsType.getProductKey());
        return subscriptionsTypeRepository.save(subscriptionsTypeCreated);
    }

    @Override
    public SubscriptionsType update(Long id, SubscriptionsType subscriptionsType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}