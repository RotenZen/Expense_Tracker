package com.sami.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sami.expensetracker.model.Expense;
import com.sami.expensetracker.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/expenses") //Api address
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    // A "GET" request to see all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // A "POST" request to add a new expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }
}