package com.client.ws.rasmooplus.dto;

import com.client.ws.rasmooplus.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPaymentInfoDto {

    private Long id;

    @Size(min = 16, max = 16, message = "Deve conter 16 caracteres")
    private String cardNumber;


    private Long cardExpirationMonth;

    private Long cardExpirationYear;


    @Size(min = 3, max = 3, message = "Deve conter 3 caracteres")
    private String cardSecurityCode;

    private BigDecimal price;

    private Integer instalments;


    private LocalDate dtPayment = LocalDate.now();

    @NotNull(message = "Deve ser informado")
    private Long userId;

}
