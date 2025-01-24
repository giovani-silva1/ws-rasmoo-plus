package com.client.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubscriptionsTypeDto {

    private Long id;

    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    private String name;
    @Max(value = 12, message = "Campo não pode ser maior que 12")
    private Long accessMonths;

    @NotNull(message = "Campo não pode ser nulo")
    private Double price;

    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min=5,max=15 , message = "Campo deve ser maior que 5 e menor que 15")
    private String productKey;
}
