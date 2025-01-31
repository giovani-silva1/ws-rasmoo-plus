package com.client.ws.rasmooplus.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "Atributo obrigatório")
    private String username;
    @NotBlank(message = "Atributo obrigatório")
    private String password;
}
