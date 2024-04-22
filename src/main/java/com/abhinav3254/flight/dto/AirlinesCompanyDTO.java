package com.abhinav3254.flight.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor @NoArgsConstructor
public class AirlinesCompanyDTO {
    private String airlineName;

    private MultipartFile airlineImage;
}
