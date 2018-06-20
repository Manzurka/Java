package calculator;

public class CalculatorTester {
	public static void main(String[] args) {
	Calculator cal = new Calculator();
	cal.setOperandOne(10.5);
	cal.setOperandTwo(5.2);
	cal.performOperation("+");
	System.out.println(cal.getResults());
	Calculator cal2 = new Calculator();
	cal2.setOperandOne(10.5);
	cal2.setOperandTwo(5.2);
	cal2.performOperation("-");
	System.out.println(cal2.getResults());
	Calculator cal3 = new Calculator(12.4, "-",2);
	Calculator cal4 = new Calculator(12.4, "/",2);
	}
}
