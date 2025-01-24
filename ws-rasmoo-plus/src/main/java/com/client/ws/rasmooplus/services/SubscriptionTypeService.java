package com.client.ws.rasmooplus.services;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;

import java.util.List;


public interface SubscriptionTypeService {

   List<SubscriptionsType> findAll();

   SubscriptionsType findById(Long id);

   SubscriptionsType create(SubscriptionsTypeDto subscriptionsType);

   SubscriptionsType update (Long id,SubscriptionsTypeDto subscriptionsType );

    void delete(Long id);


}
