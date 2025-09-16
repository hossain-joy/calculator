package com.example.calculator.controller;

import com.example.calculator.dto.CalculationRequest;
import com.example.calculator.model.Calculation;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this as a controller for REST APIs
@RequestMapping("/api/calculator") // Base URL for all endpoints in this class
@CrossOrigin(origins = "http://localhost:5173") // IMPORTANT: Allows our React app to call this API
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<Calculation> calculate(@RequestBody CalculationRequest request) {
        try {
            Calculation result = calculatorService.performCalculation(request.getExpression());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculation>> getHistory() {
        List<Calculation> history = calculatorService.getHistory();
        return ResponseEntity.ok(history);
    }
}