package application;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLController implements Initializable{

    @FXML
    private Button nine;
    @FXML
    private Button minus;
    @FXML
    private Button six;
    @FXML
    private Button one;
    @FXML
    private Button clear;
    @FXML
    private Button seven;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button eight;
    @FXML
    private Button zero;
    @FXML
    private Button four;
    @FXML
    private Label inputDisplay;
    @FXML
    private Button divide;
    @FXML
    private Button enter;
    @FXML
    private Button multiply;
    @FXML
    private Button five;
    @FXML
    private Button decimal;
    
    private String value1 = "";
    private String value2 = "";
    private boolean operating = false;
    private String operator = "";

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	inputDisplay.setText(value1);
    }
    
    public void inputNumber(String num) {
    	if(operating) {
    		if(!(num.equals(".") && value2.contains("."))) {
    			value2 += num;
        		inputDisplay.setText(value2);
    		}
    	}
    	else {
    		if(!(num.equals(".") && value1.contains("."))) {
    			value1 += num;
        		inputDisplay.setText(value1);
    		}
    	}
    }
    
    public void calculate() {
    	if(value2.equals("") && operating==false) {
    		inputDisplay.setText(value1);
    	}
    	else {
	    	try {
		    	double v1 = Double.parseDouble(value1);
		    	double v2 = Double.parseDouble(value2);
		    	CalculatorModel m = new CalculatorModel(v1, v2, operator);
		    	value1 = m.calculate();
		    	if(value1 == ""){
		    		throw new Exception();
		    	}
		    	inputDisplay.setText(value1);
	    	}
	    	catch(Exception e) {
	    		value1="";
	    		inputDisplay.setText("ERROR");
	    	}
	    	value2 = "";
	    	operating = false;
	    	operator = "";
    	}
    }


    
    @FXML
    void inputOne(ActionEvent event) {
    	inputNumber("1");
    }

    @FXML
    void inputFour(ActionEvent event) {
    	inputNumber("4");
    }

    @FXML
    void inputSeven(ActionEvent event) {
    	inputNumber("7");
    }

    @FXML
    void inputTwo(ActionEvent event) {
    	inputNumber("2");
    }

    @FXML
    void inputFive(ActionEvent event) {
    	inputNumber("5");
    }

    @FXML
    void inputEight(ActionEvent event) {
    	inputNumber("8");
    }

    @FXML
    void inputZero(ActionEvent event) {
    	inputNumber("0");
    }

    @FXML
    void inputThree(ActionEvent event) {
    	inputNumber("3");
    }

    @FXML
    void inputSix(ActionEvent event) {
    	inputNumber("6");
    }

    @FXML
    void inputNine(ActionEvent event) {
    	inputNumber("9");
    }

    @FXML
    void enter(ActionEvent event) {
    	calculate();
    }

    @FXML
    void divide(ActionEvent event) {
    	if(value1 != "" && value2 != "") {
    		calculate();
    	}
    	operator="/";
    	operating = true;
    }

    @FXML
    void multiply(ActionEvent event) {
    	if(value1 != "" && value2 != "") {
    		calculate();
    	}
    	operator="*";
    	operating = true;
    }

    @FXML
    void subtract(ActionEvent event) {
    	if(value1 != "" && value2 != "") {
    		calculate();
    	}
    	operator="-";
    	operating = true;
    }

    @FXML
    void add(ActionEvent event) {
    	if(value1 != "" && value2 != "") {
    		calculate();
    	}
    	operator="+";
    	operating = true;
    }
    
    @FXML
    void log(ActionEvent event) {
    	if(value1 != "" && value2 != "") {
    		calculate();
    	}
    	operator="log";
    	operating = true;
    	calculate();
    }

    @FXML
    void clear(ActionEvent event) {
    	operating = false;
    	value1="";
    	value2="";
    	operator = "";
    	inputDisplay.setText(value1);
    }
    
    @FXML
    void decimal(ActionEvent event) {
    	inputNumber(".");
    }

}