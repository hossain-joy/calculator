package com.example.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity // Tells JPA this class is a table in the database
public class Calculation {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    private String expression;
    private double result;
    private LocalDateTime timestamp;

    // Constructors, Getters, and Setters (your IDE can generate these)
    public Calculation() {
        this.timestamp = LocalDateTime.now();
    }

    public Calculation(String expression, double result) {
        this.expression = expression;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    // --- Generate Getters and Setters for all fields ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}