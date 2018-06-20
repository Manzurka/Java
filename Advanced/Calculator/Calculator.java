package calculator;

public class Calculator implements java.io.Serializable {
	private double num1;
	private double num2;
	private String operation;
	private static double results = 0;
	
	public Calculator() {
		results = 0;
	}
	
	public Calculator(double num1, String operation, double num2) {
		this.num1=num1;
		this.num2=num2;
		this.operation=operation;
		if (this.operation == "+")
	    {
	    	results = num1 + num2;
	        
	    }
	    if (this.operation == "-")
	    {
	    	results = num1 - num2;

	    }
	
	    if (this.operation == "/")
	    {
	    	results = num1 / num2;

	    }
	    if (this.operation == "*")
	    {
	    	results = num1 * num2;

	    }
		System.out.println(results);  
		results = 0;
	}
	
	public void setOperandOne(double n1){
        num1 = n1;
    }
  
    public void setOperandTwo(double n2){
        num2 = n2;
    }
    
    public void setOperation(String operation) {
    	this.operation=operation;
    }
    
    
    public void performOperation(String operation) {
    
	    if (operation == "+")
	    {
	    	results = num1 + num2;
//	        System.out.println("Result is " + (num1 + num2));
	        
	    }
	    if  (operation == "-")
	    {
	    	results = num1 - num2;
//	        System.out.println("Result is " + (num1 - num2));
	    }
	
	    if (operation == "/")
	    {
	    	results = num1 / num2;
//	        System.out.println("Result is " + (num1 / num2));
	    }
	    if (operation == "*")
	    {
	    	results = num1 * num2;
//	        System.out.println("Result is " + (num1 * num2));
	    }
    }
    
    public static double getResults(){
        return results;
    }
}
