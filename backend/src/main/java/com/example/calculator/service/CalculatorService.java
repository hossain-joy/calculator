package com.example.calculator.service;

import com.example.calculator.model.Calculation;
import com.example.calculator.repository.CalculationRepository;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this as a Spring service component
public class CalculatorService {

    @Autowired // Spring automatically provides an instance of CalculationRepository
    private CalculationRepository calculationRepository;

    public Calculation performCalculation(String expressionStr) {
        try {
            // Use the exp4j library to evaluate the expression
            Expression expression = new ExpressionBuilder(expressionStr).build();
            double result = expression.evaluate();

            // Create a new Calculation object to save to the database
            Calculation calculation = new Calculation(expressionStr, result);
            return calculationRepository.save(calculation);
        } catch (Exception e) {
            // Handle cases like "5+*" which are invalid
            throw new IllegalArgumentException("Invalid expression: " + expressionStr);
        }
    }

    public List<Calculation> getHistory() {
        return calculationRepository.findAll();
    }
}