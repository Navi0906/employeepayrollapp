package com.bridgelabz.employeepayroll.dto;

//import org.springframework.stereotype.Service;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object data;
}
