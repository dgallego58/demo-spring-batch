package com.self.trainee.example.repo;


import com.self.trainee.example.model.CreditCardRisk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRiskRepository extends JpaRepository<CreditCardRisk, Long> {
}
