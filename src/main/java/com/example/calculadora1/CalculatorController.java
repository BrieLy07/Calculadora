package com.example.calculadora1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = performCalculation(num1, num2, operation);
        model.addAttribute("result", result);
        return "calculator";
    }

    private double performCalculation(double num1, double num2, String operation) {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.POSITIVE_INFINITY; // Handle division by zero
                }
            default:
                return 0.0;
        }
    }
}

