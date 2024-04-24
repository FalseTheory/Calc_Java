package actions;

import javax.swing.*;
import java.util.Objects;

public class ActionManager {

    private static final String SUM = "+";
    private static final String SUBTRACTION = "-";
    private static final String EQUAL = "=";
    private static final String PERCENT = "%";
    private static final String CLEAR_ALL = "C";
    private static final String CLEAR_FIELD = "CE";
    private static final String BACKSPACE = "<-";
    private static final String DIVIDE_BY = "1/x";
    private static final String SQUARE = "x^2";
    private static final String SQUARE_ROOT = "2√x";
    private static final String DIVISION = "/";
    private static final String MULTIPLY = "x";
    private static final String CHANGE_SIGN = "+\\-";
    private static final String DOT_SIGN = ".";
    private static Double bufferValue = null;
    private static String bufferChar = null;

    public static void pressEvent(String command, JTextField field, JTextField bufferField){
        switch(command){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                field.setText(field.getText() + command);
                break;
            case DOT_SIGN:
                if (!field.getText().contains(DOT_SIGN)) {
                    field.setText(field.getText() + DOT_SIGN);
                }
                break;
            case SUM:
                bufferValue = Double.parseDouble(field.getText());
                field.setText("");
                bufferChar = SUM;
                bufferField.setText(bufferValue + " " + bufferChar);
                break;
            case SUBTRACTION:
                bufferValue = Double.parseDouble(field.getText());
                field.setText("");
                bufferChar = SUBTRACTION;
                bufferField.setText(bufferValue + " " + bufferChar);
                break;
            case MULTIPLY:
                bufferValue = Double.parseDouble(field.getText());
                field.setText("");
                bufferChar = MULTIPLY;
                bufferField.setText(bufferValue + " " + bufferChar);
                break;
            case DIVISION:
                bufferValue = Double.parseDouble(field.getText());
                field.setText("");
                bufferChar = DIVISION;
                bufferField.setText(bufferValue + " " + bufferChar);
                break;
            case EQUAL:
                if(bufferValue !=null && !Objects.equals(field.getText(), "")){
                    bufferField.setText(bufferField.getText() + field.getText() + " =");
                    field.setText(equalEvent(bufferValue,bufferChar,Double.parseDouble(field.getText())));
                    nullBuffer();
                    break;
                }
            case CLEAR_ALL:
                nullBuffer();
                field.setText("");
                bufferField.setText("");
                break;
            case CLEAR_FIELD:
                field.setText("");
                break;
            case BACKSPACE:
                if(!field.getText().isEmpty()){
                    String currentText = field.getText();
                    field.setText(currentText.substring(0,currentText.length()-1));

                }
                break;
            case DIVIDE_BY:
                if(!field.getText().isEmpty()){
                    field.setText(String.valueOf(1/Double.parseDouble(field.getText())));
                }

                break;
            case SQUARE:
                if(!field.getText().isEmpty()){
                    field.setText(String.valueOf(Math.pow(Double.parseDouble(field.getText()),2)));
                }
                break;
            case SQUARE_ROOT:
                if(!field.getText().isEmpty()){
                    field.setText(String.valueOf(Math.sqrt(Double.parseDouble(field.getText()))));
                }
                break;
            case CHANGE_SIGN:
                if(!field.getText().startsWith("-")){
                    field.setText("-"+field.getText());
                }else{
                    field.setText(field.getText().substring(1));
                }



        }
    }

    public static String equalEvent(double bufferValue,String bufferChar, double currentValue){
        return switch (bufferChar) {
            case "+" -> String.valueOf(bufferValue + currentValue);
            case "-" -> String.valueOf(bufferValue - currentValue);
            case "x" -> String.valueOf(bufferValue * currentValue);
            case "/" -> String.valueOf(bufferValue / currentValue);
            default -> null;
        };
    }
    private static void nullBuffer(){
        bufferChar = null;
        bufferValue = null;
    }
}
