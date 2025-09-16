package com.example.calculator.repository;

import com.example.calculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {
    // JpaRepository gives us methods like save(), findAll(), findById() for free!
}