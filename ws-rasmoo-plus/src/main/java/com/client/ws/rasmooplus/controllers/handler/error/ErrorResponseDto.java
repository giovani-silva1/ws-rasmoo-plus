package com.client.ws.rasmooplus.controllers.handler.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {

    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;


}
