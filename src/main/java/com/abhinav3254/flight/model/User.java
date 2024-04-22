package com.abhinav3254.flight.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String gender;
    private String role;
}
