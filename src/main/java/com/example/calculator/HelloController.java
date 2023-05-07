package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField text_result;


    String op = "";
    long number1;
    long number2;

    public void Number(ActionEvent ae) {
        String no = ((Button) ae.getSource()).getText();
        text_result.setText(text_result.getText() + no);

    }

    public void Operation(ActionEvent ae) {
        String operation= ((Button) ae.getSource()).getText();
        if (!operation.equals("=")) {
            if (!op.equals("")) {
                return;
            }
            op = operation;
            number1 = Long.parseLong(text_result.getText());
            text_result.setText("");
        } else {
            if (op.equals("")) {
                return;
            }
            number2 = Long.parseLong(text_result.getText());
            calculate(number1, number2, op);
            op = "";
        }
    }

    public void calculate(double n1, double n2, String op) {
        switch (op) {
            case "+":
                text_result.setText(n1 + n2 + "");
                break;
            case "-":
                text_result.setText(n1 - n2 + "");
                break;
            case "*":
                text_result.setText(n1 * n2 + "");
                break;
            case "%":
                text_result.setText((n1 /100 )+ "");
                break;
            case "/":
                if (n2 == 0) {
                    text_result.setText("0");
                    break;
                }
                text_result.setText(n1 / n2 + "");
                break;

        }

    }
    public void  Clear(ActionEvent actionEvent){
        text_result.setText("");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}