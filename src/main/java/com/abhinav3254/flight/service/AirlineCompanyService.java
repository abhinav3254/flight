package com.abhinav3254.flight.service;


import com.abhinav3254.flight.dto.AirlinesCompanyDTO;
import com.abhinav3254.flight.dto.AirlinesCompanyResponse;
import com.abhinav3254.flight.dto.ServerResponse;
import com.abhinav3254.flight.exception.CustomException;
import com.abhinav3254.flight.jwt.JwtFilter;
import com.abhinav3254.flight.model.AirlinesCompany;
import com.abhinav3254.flight.repository.AirlinesCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class AirlineCompanyService {

    @Autowired
    private AirlinesCompanyRepository airlinesCompanyRepository;

    @Autowired
    private JwtFilter jwtFilter;

    public ResponseEntity<?> addAirline(AirlinesCompanyDTO airlinesCompanyDTO) {
        if (jwtFilter.isAdmin()) {
            try {
                AirlinesCompany airlinesCompany = new AirlinesCompany();
                airlinesCompany.setAirlineImage(airlinesCompanyDTO.getAirlineImage().getBytes());
                airlinesCompany.setAirlineName(airlinesCompanyDTO.getAirlineName());
                airlinesCompanyRepository.save(airlinesCompany);
                return ResponseEntity.ok(new ServerResponse<>("airline added"));
            } catch (IOException e) {
                return ResponseEntity.status(500).body(new ServerResponse<>("INTERNAL SERVER ERROR "+e.getMessage()));
            }
        }
        throw new CustomException("You don't have admin access",HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<?> getAll() {
        if (jwtFilter.isAdmin()) {
            List<AirlinesCompany> airlinesCompanies = airlinesCompanyRepository.findAll();
            List<AirlinesCompanyResponse> airlinesCompanyResponses = new ArrayList<>();
            for (AirlinesCompany company:airlinesCompanies) {
                AirlinesCompanyResponse airlinesCompanyResponse = new AirlinesCompanyResponse();
                airlinesCompanyResponse.setId(company.getId());
                airlinesCompanyResponse.setAirlineName(company.getAirlineName());
                airlinesCompanyResponse.setFlights(company.getFlights());
                String base64Image = Base64.getEncoder().encodeToString(company.getAirlineImage());
                airlinesCompanyResponse.setAirlineImage(base64Image);

                airlinesCompanyResponses.add(airlinesCompanyResponse);
            }
            return ResponseEntity.status(200).body(new ServerResponse<>(airlinesCompanyResponses));
        } else throw new CustomException("unkown",HttpStatus.FORBIDDEN);
    }
}
