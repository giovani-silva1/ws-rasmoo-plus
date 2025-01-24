package com.client.ws.rasmooplus.services;

import com.client.ws.rasmooplus.model.SubscriptionsType;

import java.util.List;


public interface SubscriptionTypeService {

   List<SubscriptionsType> findAll();

   SubscriptionsType findById(Long id);

   SubscriptionsType create(SubscriptionsType subscriptionsType);

   SubscriptionsType update (Long id,SubscriptionsType subscriptionsType );

    void delete(Long id);


}
