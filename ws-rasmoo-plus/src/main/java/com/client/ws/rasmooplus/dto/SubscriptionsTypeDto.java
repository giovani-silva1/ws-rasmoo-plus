package com.client.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubscriptionsTypeDto {

    private Long id;

    private String name;

    private Long accessMonths;

    private Double price;


    private String productKey;
}
