package com.abhinav3254.flight.dto;


import com.abhinav3254.flight.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AirlinesCompanyResponse {
    private Long id;
    private String airlineImage;
    private String airlineName;

    private List<Flight> flights;
}
