package com.abhinav3254.flight.dto;


import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String gender;
}
