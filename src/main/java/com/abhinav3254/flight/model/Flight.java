package com.abhinav3254.flight.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String flightName;
    private String source;
    private String destination;

    @Temporal(TemporalType.TIMESTAMP)
    private Date takeOffTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date landingTime;

    private Integer seats;

    private Double price;

    @Lob
    private byte[] flightImage;
}
