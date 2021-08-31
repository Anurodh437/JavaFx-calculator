package sample;

import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
//    @FXML
//    private Label resultField;
//    private long number1 = 0;
//    private String operator = "";

//    private boolean start = true;
//
//    public float calculate(long number1, long number2, String operator) {
//        switch (operator) {
//            case "+":
//                return number1 + number2;
//            case "-":
//                return number1 - number2;
//            case "*":
//                return number1 * number2;
//            case "/":
//                if (number2 == 0) {
//                    return 0;
//                }
//                return number1 / number2;
//            default:
//                return 0;
//        }
//    }
//
//    @FXML
//    public void processNumber(ActionEvent actionEvent) {
//        if (start) {
//            resultField.setText("");
//            start = false;
//        }
//        String value = ((Button) actionEvent.getSource()).getText();
//        resultField.setText(resultField.getText() + value);
//    }
//
//    @FXML
//    public void processOperator(ActionEvent event) {
//        String value = ((Button) event.getSource()).getText();
//        if (!value.equals("=")) {
//            if (!operator.isEmpty())
//                return;
//
//            operator = value;
//            number1 = Long.parseLong(resultField.getText());
////            resultField.setText("");
//        } else {
//            if (operator.isEmpty())
//                return;
//            long number2 = Long.parseLong(resultField.getText());
//            float output = calculate(number1, number2, operator);
//            resultField.setText(String.valueOf(output));
//            operator = "";
//            start = true;
//        }
//    }
//
//    public void handle(ActionEvent event) {
//        resultField.setText("");
//        operator = "";
//        start = false;
//    }
//
//    public void handleDecimal(ActionEvent event) {
//        resultField.setText("");
//    }
    public Button button;
    public String output = "",result = "";
    public char ch,sym;
    public double a = -1,b = -1;
    public Label resultField;
    public void handle(ActionEvent event){
        var k = event.getSource();
        ch = k.toString().charAt(k.toString().length() - 2);
//        System.out.println(k.toString().length());
//        System.out.println(ch);
        result += ch;
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
        {
            a = Double.parseDouble(output);
            //System.out.println("a is " + a);
            sym = ch;
            // System.out.println("sym = "+sym);
            output = "";
        }
        else if (ch == '=')
        {
            result = "";
            b = Double.parseDouble(output);
            //System.out.println("b is " + b);
            output = "";
            if (sym =='+')
                result = String.valueOf(a + b);
            if (sym == '-')
                result = String.valueOf(a - b);
            if (sym == '*')
                result = String.valueOf(a * b);
            if (sym == '/')
                result = String.valueOf(a / b);
        }
        else if (ch == 'r')
            result = "";
        else
        {
            output = output + ch;
        }
        resultField.setText(result);
    }
}
