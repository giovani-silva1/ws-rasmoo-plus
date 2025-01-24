package com.client.ws.rasmooplus.Controllers;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionsTypeRepository;
import com.client.ws.rasmooplus.services.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/plans")
public class SubscriptionsTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionsTypeService;


    @GetMapping()
    public ResponseEntity<List<SubscriptionsType>> findAll(){
        List<SubscriptionsType> listaEncontrada = subscriptionsTypeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaEncontrada);
    }
}
