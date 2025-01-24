package com.client.ws.rasmooplus.dto;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {


    private Long id;

    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    private String name;
    @Email(message = "Invalido")
    private String email;
    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    @Size(max=11,min =11)
    private String phone;
    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    @Size(max=11,min =11, message = "Campo deve conter 11 caracteres")
    private String cpf;


    private LocalDate dtSubscription = LocalDate.now();


    private LocalDate dtExpiration= LocalDate.now();

    @NotNull
    private Long userTypeId;


    private Long subscriptionsTypeId;
}
