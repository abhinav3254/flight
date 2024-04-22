package com.abhinav3254.flight.controller;


import com.abhinav3254.flight.dto.AirlinesCompanyDTO;
import com.abhinav3254.flight.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/airline")
@RestController
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyService airlineCompanyService;
    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ResponseEntity<?> addAirline(@ModelAttribute AirlinesCompanyDTO airlinesCompany) {
        return airlineCompanyService.addAirline(airlinesCompany);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAirlines() {
        return airlineCompanyService.getAll();
    }
}
