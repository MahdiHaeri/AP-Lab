package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    public void handleButtonAction(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (start) {
            display.setText("");
            start = false;
        }

        if ("0123456789.".contains(value)) {
            display.setText(display.getText() + value);
        }
        else {
            if (operator.isEmpty()) {
                operator = value;
                num1 = Double.parseDouble(display.getText());
                display.setText("");
            }
            else {
                if (!display.getText().isEmpty()) {
                    double num2 = Double.parseDouble(display.getText());
                    double result = calculate(num1, num2, operator);
                    display.setText(String.valueOf(result));
                    num1 = result;
                }
                operator = value;
            }
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0)
                    return num1 / num2;
                else
                    return 0;
            default:
                return 0;
        }
    }
}
