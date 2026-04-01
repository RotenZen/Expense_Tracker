package com.sami.expensetracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sami.expensetracker.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //tells SB that the class below is a Table in db
@Table(name = "expenses") //sets the table name to expenses, default is Expense
@Data // This is from Lombok - it automatically creates Getters, Setters, and toString()
public class Expense {

    @Id //Marks this as the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Handles Id, automatically types ID;Auto Increment
    private Long id;

    @Column(nullable = false) //Puts restriction, Cannot save an expense without amount
    private BigDecimal amount; //BigDecimal used for money to avoid rounding errors

    @Enumerated(EnumType.STRING)
    @Column(nullable= false)
    private Category category; 

    //@Column(nullable = false)
    //private String category; // We will turn this into a separate Table later, but let's keep it simple for now

    private String description; //Description can be empty

    @Column(nullable = false)
    private LocalDate date;
}