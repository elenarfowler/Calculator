package application;

public class CalculatorModel {
	
	public double v1;
	public double v2;
	public String operator;
	
	public CalculatorModel(double v1, double v2, String op) {
		this.v1 = v1;
		this.v2 = v2;
		this.operator = op;
	}
	
	public String calculate() {
		String value1 = "";
	    	try {
		    	if(operator.equals("+")) {
		    		value1 = String.valueOf(v1+v2);
		    	}
		    	else if(operator.equals("-")) {
		    		value1 = String.valueOf(v1-v2);
		    	}
		    	else if(operator.equals("/")) {
		    		if(v2 == 0) {
		    			throw new Exception();
		    		}
		    		value1 = String.valueOf(v1/v2);
		    	}
		    	else if(operator.equals("*")) {
		    		value1 = String.valueOf(v1*v2);
		    	}
		    	return value1;
	    	}
	    	catch(Exception e) {
	    		value1="";
	    		return value1;
	    	}
    	}
}
