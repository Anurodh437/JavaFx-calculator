package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label resultField;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    public float calculate(long number1, long number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;
            default:
                return 0;
        }
    }

    @FXML
    public void processNumber(ActionEvent actionEvent) {
        if (start) {
            resultField.setText("");
            start = false;
        }
        String value = ((Button) actionEvent.getSource()).getText();
        resultField.setText(resultField.getText() + value);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(resultField.getText());
//            resultField.setText("");
        } else {
            if (operator.isEmpty())
                return;
            long number2 = Long.parseLong(resultField.getText());
            float output = calculate(number1, number2, operator);
            resultField.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }

    public void handle(ActionEvent event) {
        resultField.setText("");
        operator = "";
        start = false;
    }

    public void handleDecimal(ActionEvent event) {
        resultField.setText("");
    }
}
