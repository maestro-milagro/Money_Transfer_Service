package com.milagro.springmoneytransferservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ExceptionDTO {
    private String message;
    private int id;

}
