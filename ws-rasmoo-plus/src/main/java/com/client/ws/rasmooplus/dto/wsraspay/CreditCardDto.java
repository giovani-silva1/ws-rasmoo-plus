package com.client.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDto {


    private String number;


    private Long cvv;


    private Long month;


    private Long year;


    private String documentNumber;

    private Long installments;
}