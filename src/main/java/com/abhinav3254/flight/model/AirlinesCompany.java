package com.abhinav3254.flight.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "airline_company")
public class AirlinesCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airlineName;

    @Lob
    private byte[] airlineImage;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private List<Flight> flights;
}
