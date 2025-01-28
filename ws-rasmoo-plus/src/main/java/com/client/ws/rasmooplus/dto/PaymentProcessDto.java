package com.client.ws.rasmooplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentProcessDto {

    @NotBlank(message = "deve ser inforamado")
    private String productKey;

    private BigDecimal discount;


    @NotNull(message = "Dados devem ser preenchidos")
    @JsonProperty("userPaymentInfo")
    private UserPaymentInfoDto userPaymentInfoDto;

}
