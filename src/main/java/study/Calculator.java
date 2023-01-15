package study;

public class Calculator {
	
	public int add(int x, int y) {
		return x+y;
	}
	
	public int subtract(int x, int y) {
		return x-y;
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
	
	public String[] seperate(String input) {
		return input.split(" ");
	}
	
	public int calculate(int x, String op, int y) {
		
		if (op.equals("+")) {
			return add(x, y);
		}
		
		if (op.equals("-")) {
			return subtract(x, y);
		}
		
		if (op.equals("*")) {
			return multiply(x, y);
		}
		
		if (op.equals("/")) {
			return divide(x, y);
		} 
		
		else {
			System.out.println("값이 잘못됐습니다."+"x:"+x+" /op:"+op+" /y:"+y);
			return Integer.MAX_VALUE;
		}
	}

	public int calString(String[] input) {
		int result = 0;
		
		for (int i=0; i<input.length; i+=2) {
			if (i == 0) {
				result = calculate(Integer.parseInt(input[i]), input[i+1], Integer.parseInt(input[i+2]));
				i++;
			} else {
				result = calculate(result, input[i], Integer.parseInt(input[i+1]));
			}
		}
		
		return result;
	}
}
