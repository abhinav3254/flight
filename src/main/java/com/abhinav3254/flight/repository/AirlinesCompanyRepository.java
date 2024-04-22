package com.abhinav3254.flight.repository;


import com.abhinav3254.flight.model.AirlinesCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlinesCompanyRepository extends JpaRepository<AirlinesCompany,Long> {
}
